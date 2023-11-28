package vn.edu.iuh.fit.week07_lab_voquocthinh.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.enums.EmployeeStatus;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Employee findByUserUsernameAndStatusIsNot(String username, EmployeeStatus status);

    List<Employee> findByStatusIsNot(EmployeeStatus status);
}
