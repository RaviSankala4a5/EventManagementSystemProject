package net.javaguides.ems.Service;

import net.javaguides.ems.dto.DepartmentDto;

import java.util.List;


public interface DepartmentService
{

    public DepartmentDto createDepartment(DepartmentDto departmentDto);
     public List<DepartmentDto> getAllDepartments();
     public DepartmentDto getDepartment(Long id);
    public DepartmentDto updateDepartment(Long id, DepartmentDto departmentDto);
    public void deleteDep(Long id);
}
