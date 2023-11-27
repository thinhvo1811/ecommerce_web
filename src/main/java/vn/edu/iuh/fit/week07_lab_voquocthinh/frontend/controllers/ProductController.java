package vn.edu.iuh.fit.week07_lab_voquocthinh.frontend.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.Customer;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.Product;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.User;
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
            @RequestParam("size") Optional<Integer> size,
            HttpSession session
    ){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);

        List<Product> products = productService.findByStatusIsNotTerminatedNotPaging();
        Page<Product> productPage = productService.findByStatusIsNotTerminatedAndSortBySoldQuantity(currentPage - 1, pageSize);
        List<String> brands = productService.findAllManufacturerName();
        User user = (User) session.getAttribute("customerSession");;
        model.addAttribute("customerSession", user);
        Customer customer = new Customer();
        customer.setUser(new User());
        model.addAttribute("customer", customer);
        model.addAttribute("user", customer.getUser());
        model.addAttribute("productPage", productPage);
        model.addAttribute("brands", brands);
        model.addAttribute("byManufacturer", 0);
        model.addAttribute("sortType", 0);
        model.addAttribute("products", products);
        int totalPage = productPage.getTotalPages();
        if (totalPage > 0){
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "client/home";
    }

    @GetMapping("/home/sort-by-price-asc")
    public String showHomePageSortByPriceAsc(
            Model model,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size,
            HttpSession session
    ){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);

        List<Product> products = productService.findByStatusIsNotTerminatedNotPaging();
        Page<Product> productPage = productService.findByStatusIsNotTerminatedAndSortByPriceAsc(currentPage - 1, pageSize);
        List<String> brands = productService.findAllManufacturerName();
        User user = (User) session.getAttribute("customerSession");;
        model.addAttribute("customerSession", user);
        Customer customer = new Customer();
        customer.setUser(new User());
        model.addAttribute("customer", customer);
        model.addAttribute("user", customer.getUser());
        model.addAttribute("productPage", productPage);
        model.addAttribute("brands", brands);
        model.addAttribute("byManufacturer", 0);
        model.addAttribute("sortType", 1);
        model.addAttribute("products", products);
        int totalPage = productPage.getTotalPages();
        if (totalPage > 0){
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "client/home";
    }

    @GetMapping("/home/sort-by-price-desc")
    public String showHomePageSortByPriceDesc(
            Model model,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size,
            HttpSession session
    ){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);

        List<Product> products = productService.findByStatusIsNotTerminatedNotPaging();
        Page<Product> productPage = productService.findByStatusIsNotTerminatedAndSortByPriceDesc(currentPage - 1, pageSize);
        List<String> brands = productService.findAllManufacturerName();
        User user = (User) session.getAttribute("customerSession");;
        model.addAttribute("customerSession", user);
        Customer customer = new Customer();
        customer.setUser(new User());
        model.addAttribute("customer", customer);
        model.addAttribute("user", customer.getUser());
        model.addAttribute("productPage", productPage);
        model.addAttribute("brands", brands);
        model.addAttribute("byManufacturer", 0);
        model.addAttribute("sortType", 2);
        model.addAttribute("products", products);
        int totalPage = productPage.getTotalPages();
        if (totalPage > 0){
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "client/home";
    }

    @GetMapping("/home/manufacturer/{name}")
    public String showHomePageWithListProductByManufacturer(
            Model model,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size,
            @PathVariable("name") String name,
            HttpSession session
    ){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);

        List<Product> products = productService.findByStatusIsNotTerminatedNotPaging();
        Page<Product> productPage = productService.findByManufacturerAndStatusIsNotTerminatedAndSortBySoldQuantity(currentPage - 1, pageSize, name);
        List<String> brands = productService.findAllManufacturerName();
        User user = (User) session.getAttribute("customerSession");;
        model.addAttribute("customerSession", user);
        Customer customer = new Customer();
        customer.setUser(new User());
        model.addAttribute("customer", customer);
        model.addAttribute("user", customer.getUser());
        model.addAttribute("productPage", productPage);
        model.addAttribute("brands", brands);
        model.addAttribute("byManufacturer", 1);
        model.addAttribute("sortType", 0);
        model.addAttribute("name", name);
        model.addAttribute("products", products);
        int totalPage = productPage.getTotalPages();
        if (totalPage > 0){
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "client/home";
    }

    @GetMapping("/home/sort-by-price-asc/manufacturer/{name}")
    public String showHomePageWithListProductByManufacturerSortByPriceAsc(
            Model model,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size,
            @PathVariable("name") String name,
            HttpSession session
    ){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);

        List<Product> products = productService.findByStatusIsNotTerminatedNotPaging();
        Page<Product> productPage = productService.findByManufacturerAndStatusIsNotTerminatedAndSortByPriceAsc(currentPage - 1, pageSize, name);
        List<String> brands = productService.findAllManufacturerName();
        User user = (User) session.getAttribute("customerSession");;
        model.addAttribute("customerSession", user);
        Customer customer = new Customer();
        customer.setUser(new User());
        model.addAttribute("customer", customer);
        model.addAttribute("user", customer.getUser());
        model.addAttribute("productPage", productPage);
        model.addAttribute("brands", brands);
        model.addAttribute("byManufacturer", 1);
        model.addAttribute("sortType", 1);
        model.addAttribute("name", name);
        model.addAttribute("products", products);
        int totalPage = productPage.getTotalPages();
        if (totalPage > 0){
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "client/home";
    }

    @GetMapping("/home/sort-by-price-desc/manufacturer/{name}")
    public String showHomePageWithListProductByManufacturerSortByPriceDesc(
            Model model,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size,
            @PathVariable("name") String name,
            HttpSession session
    ){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);

        List<Product> products = productService.findByStatusIsNotTerminatedNotPaging();
        Page<Product> productPage = productService.findByManufacturerAndStatusIsNotTerminatedAndSortByPriceDesc(currentPage - 1, pageSize, name);
        List<String> brands = productService.findAllManufacturerName();
        User user = (User) session.getAttribute("customerSession");;
        model.addAttribute("customerSession", user);
        Customer customer = new Customer();
        customer.setUser(new User());
        model.addAttribute("customer", customer);
        model.addAttribute("user", customer.getUser());
        model.addAttribute("productPage", productPage);
        model.addAttribute("brands", brands);
        model.addAttribute("byManufacturer", 1);
        model.addAttribute("sortType", 2);
        model.addAttribute("name", name);
        model.addAttribute("products", products);
        int totalPage = productPage.getTotalPages();
        if (totalPage > 0){
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "client/home";
    }

    @GetMapping("/product-details/{id}")
    public ModelAndView showProductDetail(@PathVariable("id") Long id,
                                          HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        Product product = productService.findById(id);
        List<Product> products = productService.findByStatusIsNotTerminatedNotPaging();
        User user = (User) session.getAttribute("customerSession");;
        modelAndView.addObject("customerSession", user);
        Customer customer = new Customer();
        customer.setUser(new User());
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("user", customer.getUser());
        modelAndView.addObject("product", product);
        modelAndView.addObject("products", products);
        modelAndView.setViewName("client/product-details");
        return modelAndView;
    }
}
