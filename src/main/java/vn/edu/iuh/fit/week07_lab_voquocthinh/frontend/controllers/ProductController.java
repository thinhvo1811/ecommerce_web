package vn.edu.iuh.fit.week07_lab_voquocthinh.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.Product;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.ProductImage;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.repositories.ProductRepository;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.services.ProductService;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;

    @GetMapping("/home")
    public ModelAndView showHomePage(){
        ModelAndView modelAndView = new ModelAndView();
        List<Product> products = productService.findByStatusIsNotTerminated();
        List<String> brands = productService.findAllManufacturerName();
        modelAndView.addObject("products", products);
        modelAndView.addObject("brands", brands);
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
