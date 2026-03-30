package net.javaguides.ems.Service.Impl;

import lombok.NoArgsConstructor;
import net.javaguides.ems.Entity.Department;
import net.javaguides.ems.Expection.ResourceNotFoundExpection;
import net.javaguides.ems.Mapper.DepartmentMapper;
import net.javaguides.ems.Repository.DepartmentRepository;
import net.javaguides.ems.Service.DepartmentService;
import net.javaguides.ems.dto.DepartmentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@NoArgsConstructor
public class DepartmentServiceImpl implements DepartmentService
{
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto)
    {
      Department department= DepartmentMapper.maptoDepartment(departmentDto);
         Department Savedepartment=departmentRepository.save(department);
         System.out.println("Department details saved has been succussfully");
         DepartmentDto departmentDto1 =DepartmentMapper.maptoDepartmentDto(Savedepartment);
         return departmentDto1;

    }

    @Override
    public List<DepartmentDto> getAllDepartments()
    {
       List<Department> allDepartmensts=departmentRepository.findAll();
       List<DepartmentDto> toList=new ArrayList<>();
       for(int i=0;i<allDepartmensts.size();i++)
       {
           Department dep=allDepartmensts.get(i);
           DepartmentDto departmentDto=DepartmentMapper.maptoDepartmentDto(dep);
           toList.add(departmentDto);
        }
       return  toList;

    }

    @Override
    public DepartmentDto getDepartment(Long id) {
        Department department=departmentRepository.findById(id).orElseThrow(()->new ResourceNotFoundExpection("Employee is not found as per give id"));
        DepartmentDto departmentDto1= DepartmentMapper.maptoDepartmentDto(department);
        return  departmentDto1;
    }

    @Override
    public DepartmentDto updateDepartment(Long id, DepartmentDto departmentDto) {
        Department department=departmentRepository.findById(id).orElseThrow(()->new ResourceNotFoundExpection("Employee is not found as per give id"));
        department.setId(department.getId());
          department.setDepartmentName(departmentDto.getDepartmentName());
          department.setDepartmentDescription(departmentDto.getDepartmentDescription());
         Department updateDep=departmentRepository.save(department);
         return DepartmentMapper.maptoDepartmentDto(updateDep);

    }

    @Override
    public void deleteDep(Long id) {
        departmentRepository.deleteById(id);
        System.out.println("Department has be deleted");
    }


}
