package net.javaguides.ems.Controller;


import net.javaguides.ems.Service.DepartmentService;
import net.javaguides.ems.dto.DepartmentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/departments")
public class DepartmentController
{
    @Autowired
    private DepartmentService departmentService;
    // Build Add Department details Rest API

    @PostMapping("/saveDep")
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto)
    {
       DepartmentDto saveDepartmemtDto=departmentService.createDepartment(departmentDto);
       return new ResponseEntity<>(saveDepartmemtDto, HttpStatus.CREATED);
    }

    @GetMapping("/AllDepartments")
    public  ResponseEntity<List<DepartmentDto>> getAllDepartments()
    {
        List<DepartmentDto> allDepartmemts=departmentService.getAllDepartments();
        return new ResponseEntity<>(allDepartmemts,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("id") Long id)
    {
       DepartmentDto department=departmentService.getDepartment(id);

        return  ResponseEntity.ok(department);
    }
    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") Long id,@RequestBody DepartmentDto departmentDto)
    {
        DepartmentDto department =departmentService.updateDepartment(id,departmentDto);
        return new ResponseEntity<>(department, HttpStatus.OK);



    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDep(@PathVariable("id") Long id)
    {
        departmentService.deleteDep(id);
        return ResponseEntity.ok("Department has been deleted succussfully");
    }

}
