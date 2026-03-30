package net.javaguides.ems.Service.Impl;

import lombok.AllArgsConstructor;
import net.javaguides.ems.Entity.Department;
import net.javaguides.ems.Entity.Employee;
import net.javaguides.ems.Expection.ResourceNotFoundExpection;
import net.javaguides.ems.Mapper.EmployeeMapper;
import net.javaguides.ems.Repository.DepartmentRepository;
import net.javaguides.ems.Repository.EmployeeRepostitory;
import net.javaguides.ems.Service.EmployeeService;
import net.javaguides.ems.dto.EmployeeDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepostitory employeeRepostitory;
    private DepartmentRepository departmentRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto)
    {
       Employee employee= EmployeeMapper.maptoEmployee(employeeDto);
       Department department= departmentRepository.findById(employeeDto.getDepartmentId())
               .orElseThrow(()-> new ResourceNotFoundExpection("this id is not exist in the db"));
       employee.setDepartment(department);
       System.out.println(department.getId());
       Employee savedEmployee =employeeRepostitory.save(employee);
       System.out.println("employee details has be saved successfully");

      EmployeeDto returnEmpDto= EmployeeMapper.maptoEmployeeDto(savedEmployee);
       return  returnEmpDto;

 }

    @Override
    public EmployeeDto getEmployee(Long employeeId)
    {
        Employee employee=employeeRepostitory.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundExpection("Employee is not found with given Id"+employeeId));

    return  EmployeeMapper.maptoEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> allEmployees=employeeRepostitory.findAll();
        List<EmployeeDto> todoList=new ArrayList<>();
     for(int i=0;i<allEmployees.size();i++)
     {
         Employee emp=allEmployees.get(i);
         EmployeeDto dtoEmp =EmployeeMapper.maptoEmployeeDto(emp);
         todoList.add(dtoEmp);
 }
     return todoList;

    }

    @Override
    public EmployeeDto updatedEmp(Long employeeId, EmployeeDto employeeDto)
    {
        Employee employee=employeeRepostitory.findById(employeeId)
                .orElseThrow(()->new ResourceNotFoundExpection("Employee is not found as per give id"));
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
      Department department= departmentRepository.findById(employeeDto.getDepartmentId())
               .orElseThrow(()-> new ResourceNotFoundExpection("this id is not exist in the db"));
       employee.setDepartment(department);
        //Employee savedEmployee =employeeRepostitory.save(employee);
       Employee emp= employeeRepostitory.save(employee);
       return EmployeeMapper.maptoEmployeeDto(emp);



    }

    @Override
    public void deleteEmp(Long empId)
    {
        employeeRepostitory.deleteById(empId);
        System.out.println("Employee details has been deleted sucessufully"+ empId);

    }
}



