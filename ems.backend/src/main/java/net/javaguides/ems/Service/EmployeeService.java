package net.javaguides.ems.Service;

import net.javaguides.ems.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService
{
 public  EmployeeDto createEmployee(EmployeeDto employeeDto);
 public  EmployeeDto getEmployee(Long employeeId);
 public List<EmployeeDto> getAllEmployee();
 public EmployeeDto updatedEmp(Long employeeId, EmployeeDto employeeDto);
 public void deleteEmp(Long empId);




}
