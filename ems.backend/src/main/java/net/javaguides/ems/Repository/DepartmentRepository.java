package net.javaguides.ems.Repository;

import net.javaguides.ems.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long>
{


}
