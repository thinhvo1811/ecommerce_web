package vn.edu.iuh.fit.week07_lab_voquocthinh.frontend.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.Customer;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.Order;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.Product;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.User;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.repositories.OrderRepository;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.services.CustomerService;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.services.OrderService;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.services.ProductService;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderService orderService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;

    @GetMapping("/customer/my-order")
    public ModelAndView showMyOrder(
            HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) session.getAttribute("customerSession");;
        modelAndView.addObject("customerSession", user);
        Customer customer = customerService.findByUserUsername(user.getUsername());
        List<Order> orders = orderService.findByCustomer(customer);
        List<Product> products = productService.findByStatusIsNotTerminatedNotPaging();
        modelAndView.addObject("products", products);
        modelAndView.addObject("orders", orders);

        modelAndView.setViewName("client/orders");
        return modelAndView;
    }
}
