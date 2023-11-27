package vn.edu.iuh.fit.week07_lab_voquocthinh.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.Customer;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.Order;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.repositories.OrderRepository;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findByCustomer(Customer customer){
        return orderRepository.findByCustomer(customer);
    }
}
