package net.javaguides.ems.Mapper;

import net.javaguides.ems.Entity.Department;
import net.javaguides.ems.dto.DepartmentDto;

public class DepartmentMapper
{
    public static DepartmentDto maptoDepartmentDto(Department department)
    {
        return new DepartmentDto(department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription());

    }
    public static  Department maptoDepartment(DepartmentDto departmentDto)
    {
        return new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription());

    }

}
