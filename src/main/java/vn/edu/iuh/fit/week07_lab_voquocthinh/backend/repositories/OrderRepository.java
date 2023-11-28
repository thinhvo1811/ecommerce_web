package vn.edu.iuh.fit.week07_lab_voquocthinh.backend.repositories;

import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.Customer;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.Order;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomer(Customer customer);

    @Query("select o from Order o where cast(o.orderDate as DATE) = :date")
    List<Order> findByOrderDate(@Param("date") Date date);
    @Query("select o from Order o where cast(o.orderDate as DATE) BETWEEN :fromDate and :toDate")
    List<Order> findByOrderDateBetween(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
    @Query("select o from Order o where o.employee.id = :id and cast(o.orderDate as DATE) BETWEEN :fromDate and :toDate")
    List<Order> findByEmployeeIdAndOrderDateBetween(@Param("id") long id, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
}
