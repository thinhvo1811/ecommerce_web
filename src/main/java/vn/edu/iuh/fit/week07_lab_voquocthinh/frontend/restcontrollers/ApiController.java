package vn.edu.iuh.fit.week07_lab_voquocthinh.frontend.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.Order;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.Product;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.services.OrderService;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.services.ProductService;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
public class ApiController {
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;
    @GetMapping("/products-by-keyword/{keyword}")
    public List<Product> getProductsByKeyword(@PathVariable("keyword") String keyword){
        List<Product> products = productService.findByKeywordAndStatusIsNotTerminated(keyword);
        return products;
    }

    @GetMapping("/orders-by-date")
    public List<Order> getOrdersByDate(@RequestParam("date") String date){
        List<Order> orders = orderService.findByOrderDate(date);
        return orders;
    }

    @GetMapping("/orders-by-period")
    public List<Order> getOrdersByPeriod(@RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate){
        List<Order> orders = orderService.findByOrderDateBetween(fromDate,toDate);
        return orders;
    }

    @GetMapping("/orders-employee-and-by-period")
    public List<Order> getOrdersByEmployeeIdPeriod(@RequestParam("empId") long id, @RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate){
        List<Order> orders = orderService.findByEmployeeIdAndOrderDateBetween(id, fromDate,toDate);
        return orders;
    }

    @GetMapping("/products/{id}")
    public Product getProductByIdAndNotTerminated(@PathVariable("id") long id){
        Product product = productService.findByIdAndIsNotTerminated(id);
        return product;
    }
}
