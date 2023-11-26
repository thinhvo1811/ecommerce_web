package vn.edu.iuh.fit.week07_lab_voquocthinh.frontend.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.Product;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.services.ProductService;

import java.util.List;

@RestController
public class ApiController {
    @Autowired
    private ProductService productService;
    @GetMapping("/products-by-keyword/{keyword}")
    public List<Product> getProductsByKeyword(@PathVariable("keyword") String keyword){
        List<Product> products = productService.findByKeywordAndStatusIsNotTerminated(keyword);
        return products;
    }
}
