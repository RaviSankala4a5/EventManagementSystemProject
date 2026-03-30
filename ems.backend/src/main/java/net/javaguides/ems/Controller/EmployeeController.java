package net.javaguides.ems.Controller;

import lombok.AllArgsConstructor;
import net.javaguides.ems.Service.EmployeeService;
import net.javaguides.ems.dto.EmployeeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController
{
    private EmployeeService employeeService;

    //build Add Employee Rest API
    @PostMapping("/save")
    public ResponseEntity<EmployeeDto> creatEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto  savedEmployee=employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") Long employeeId)
    {
        EmployeeDto employeeDto  =employeeService.getEmployee(employeeId);
        return  ResponseEntity.ok(employeeDto);

    }
    @GetMapping("/AllEmployees")
public  ResponseEntity<List<EmployeeDto>> getAllEmployees()
{
    List<EmployeeDto> employeeDto=employeeService.getAllEmployee();
    return new ResponseEntity<>(employeeDto,HttpStatus.OK);
}
@PutMapping("/{id}")
public ResponseEntity<EmployeeDto> updateEmp(@PathVariable("id") Long empId, @RequestBody EmployeeDto employeeDto)
{
    EmployeeDto empDto=employeeService.updatedEmp(empId, employeeDto);

    return ResponseEntity.ok(empDto);
}
@DeleteMapping("/{id}")
public ResponseEntity<String>deleteEmp(@PathVariable("id") Long empId)
{
  employeeService.deleteEmp(empId);
 return ResponseEntity.ok("Employee has been deleted succussfully");

}


}
