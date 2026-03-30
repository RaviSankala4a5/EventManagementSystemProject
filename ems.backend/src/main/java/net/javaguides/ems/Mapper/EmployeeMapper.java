package net.javaguides.ems.Mapper;

import net.javaguides.ems.Entity.Employee;
import net.javaguides.ems.dto.EmployeeDto;

public class EmployeeMapper
{
    public  static EmployeeDto maptoEmployeeDto( Employee employee)
    {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
              employee.getDepartment().getId());
    }

    public static Employee maptoEmployee(EmployeeDto employeeDto)
    {
     Employee employee=new Employee();
     employee.setId(employeeDto.getId());
     employee.setFirstName(employeeDto.getFirstName());
     employee.setLastName(employeeDto.getLastName());
     employee.setEmail(employeeDto.getEmail());
     //employee.setDepartment(employeeDto.getDepartmentId());
    return  employee;
    }
}
