package net.javaguides.ems.Repository;

import net.javaguides.ems.Entity.Employee;
import org.aspectj.internal.lang.annotation.ajcDeclareParents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepostitory extends JpaRepository<Employee, Long>
{


}
