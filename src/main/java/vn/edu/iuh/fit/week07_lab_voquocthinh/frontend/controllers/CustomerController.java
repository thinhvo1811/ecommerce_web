package vn.edu.iuh.fit.week07_lab_voquocthinh.frontend.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.Customer;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.Product;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.User;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.repositories.CustomerRepository;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.services.CustomerService;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.services.ProductService;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;

    @GetMapping("/customer/my-account/{username}")
    public ModelAndView showMyAccount(@PathVariable("username") String username,
                                      HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        Customer customer = customerService.findByUserUsername(username);
        List<Product> products = productService.findByStatusIsNotTerminatedNotPaging();
        modelAndView.addObject("products", products);
        modelAndView.addObject("customer", customer);
        User user = (User) session.getAttribute("customerSession");;
        modelAndView.addObject("customerSession", user);
        modelAndView.setViewName("client/customer-info");
        return modelAndView;
    }

    @PostMapping("/customer/update/{id}")
    public ModelAndView update(@PathVariable("id") Long id,
                                      @ModelAttribute("customer") Customer customer){
        ModelAndView modelAndView = new ModelAndView();
        Customer customer1 = customerRepository.findById(id).get();
        customer1.setName(customer.getName());
        customer1.setEmail(customer.getEmail());
        customer1.setPhone(customer.getPhone());
        customer1.setAddress(customer.getAddress());
        customerRepository.save(customer1);
        modelAndView.setViewName("redirect:/customer/my-account/"+customer1.getUser().getUsername());
        return modelAndView;
    }
}
