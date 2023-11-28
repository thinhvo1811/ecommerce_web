package vn.edu.iuh.fit.week07_lab_voquocthinh.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.Customer;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.Order;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.repositories.OrderRepository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findByCustomer(Customer customer){
        return orderRepository.findByCustomer(customer);
    }

    public List<Order> findByOrderDate(String date) {
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date newDate = null;
        try {
            newDate = df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        };

        return orderRepository.findByOrderDate(newDate);
    }

    public List<Order> findByOrderDateBetween(String fromDate, String toDate){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date newFromDate = null;
        Date newToDate = null;
        try {
            newFromDate = df.parse(fromDate);
            newToDate = df.parse(toDate);
        } catch (ParseException e) {
            e.printStackTrace();
        };

        return orderRepository.findByOrderDateBetween(newFromDate, newToDate);
    }

    public List<Order> findByEmployeeIdAndOrderDateBetween(long id, String fromDate, String toDate){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date newFromDate = null;
        Date newToDate = null;
        try {
            newFromDate = df.parse(fromDate);
            newToDate = df.parse(toDate);
        } catch (ParseException e) {
            e.printStackTrace();
        };

        return orderRepository.findByEmployeeIdAndOrderDateBetween(id, newFromDate, newToDate);
    }
}
