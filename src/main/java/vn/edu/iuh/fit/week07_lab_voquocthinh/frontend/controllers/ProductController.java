package vn.edu.iuh.fit.week07_lab_voquocthinh.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.Product;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.ProductImage;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.repositories.ProductRepository;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.services.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;

    @GetMapping("/home")
    public String showHomePage(
            Model model,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size
    ){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);

        List<Product> products = productService.findByStatusIsNotTerminatedNotPaging();
        Page<Product> productPage = productService.findByStatusIsNotTerminated(currentPage - 1, pageSize);
        List<String> brands = productService.findAllManufacturerName();
        model.addAttribute("productPage", productPage);
        model.addAttribute("brands", brands);
        model.addAttribute("pagingType", 0);
        model.addAttribute("products", products);
        int totalPage = productPage.getTotalPages();
        if (totalPage > 0){
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "index";
    }

    @GetMapping("/home/manufacturer/{name}")
    public String showHomePageWithListProductByManufacturer(
            Model model,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size,
            @PathVariable("name") String name
    ){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);

        List<Product> products = productService.findByStatusIsNotTerminatedNotPaging();
        Page<Product> productPage = productService.findByManufacturerAndStatusIsNotTerminated(currentPage - 1, pageSize, name);
        List<String> brands = productService.findAllManufacturerName();
        model.addAttribute("productPage", productPage);
        model.addAttribute("brands", brands);
        model.addAttribute("pagingType", 1);
        model.addAttribute("name", name);
        model.addAttribute("products", products);
        int totalPage = productPage.getTotalPages();
        if (totalPage > 0){
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "index";
    }
}
