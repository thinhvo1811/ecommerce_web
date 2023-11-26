package vn.edu.iuh.fit.week07_lab_voquocthinh.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
