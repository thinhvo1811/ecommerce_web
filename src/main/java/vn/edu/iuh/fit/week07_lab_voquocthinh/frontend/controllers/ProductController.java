package vn.edu.iuh.fit.week07_lab_voquocthinh.frontend.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.enums.EmployeeStatus;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.enums.ProductStatus;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.*;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.repositories.ProductRepository;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.services.ProductService;

import java.time.LocalDateTime;
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

    @GetMapping("/admin/product-price-chart")
    public ModelAndView showProductPriceChart(
            HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) session.getAttribute("adminSession");
        modelAndView.addObject("adminSession", user);
        List<Product> products = productRepository.findByStatusIsNot(ProductStatus.TERMINATED);
        modelAndView.addObject("products", products);
        modelAndView.setViewName("admin/product-price-chart");
        return modelAndView;
    }

    @GetMapping("/admin/products")
    public String showProductList(
            Model model,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size,
            HttpSession session
    ){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);

        Page<Product> productPage = productService.findByStatusIsNotTerminatedAndSortBySoldQuantity(currentPage - 1, pageSize);
        model.addAttribute("productPage", productPage);
        User user = (User) session.getAttribute("adminSession");
        model.addAttribute("adminSession", user);
        int totalPage = productPage.getTotalPages();
        if (totalPage > 0){
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "admin/product-list-paging";
    }

    @GetMapping("/admin/delete-product/{id}")
    public String deleteProduct(
            @PathVariable("id") long id
    ){
        Product product = productRepository.findById(id).get();
        product.setStatus(ProductStatus.TERMINATED);
        productRepository.save(product);
        return "redirect:/admin/products";
    }

    @GetMapping("/admin/product-details/{id}")
    public ModelAndView showProductDetailAdmin(@PathVariable("id") Long id,
                                          HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        Product product = productService.findById(id);
        User user = (User) session.getAttribute("adminSession");
        modelAndView.addObject("adminSession", user);
        modelAndView.addObject("product", product);
        modelAndView.setViewName("admin/product-details-for-admin");
        return modelAndView;
    }

    @GetMapping("/admin/show-form-add-product")
    public ModelAndView showFormAddProduct(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        Product product = new Product();
        ProductPrice productPrice = new ProductPrice();
        User user = (User) session.getAttribute("adminSession");
        modelAndView.addObject("adminSession", user);
        modelAndView.addObject("product", product);
        modelAndView.addObject("productPrice", productPrice);
        modelAndView.setViewName("admin/add-product-form");
        return modelAndView;
    }

    @PostMapping("/admin/add-product")
    public ModelAndView addProduct(HttpSession session,
                                   @ModelAttribute("product") Product product,
                                   @ModelAttribute("productPrice") ProductPrice productPrice){
        ModelAndView modelAndView = new ModelAndView();
        product.setStatus(ProductStatus.ACTIVE);
        productPrice.setPrice_date_time(LocalDateTime.now());
        productPrice.setProduct(product);
        List<ProductPrice> productPrices = List.of(productPrice);
        product.setProductPrices(productPrices);
        productRepository.save(product);
        modelAndView.setViewName("redirect:/admin/products");
        return modelAndView;
    }

    @GetMapping("/admin/show-form-update-product/{id}")
    public ModelAndView showFormAddProduct(@PathVariable("id") long id,
                                           HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        Product product = productService.findById(id);
        ProductPrice lastProductPrice = product.getProductPrices().get(product.getProductPrices().size()-1);
        User user = (User) session.getAttribute("adminSession");
        modelAndView.addObject("adminSession", user);
        modelAndView.addObject("product", product);
        modelAndView.addObject("lastProductPrice", lastProductPrice);
        modelAndView.setViewName("admin/update-product-form");
        return modelAndView;
    }

    @PostMapping("/admin/update-product/{id}")
    public ModelAndView updateProduct(HttpSession session,
                                   @PathVariable("id") long id,
                                   @ModelAttribute("product") Product product,
                                   @ModelAttribute("lastProductPrice") ProductPrice lastProductPrice){
        ModelAndView modelAndView = new ModelAndView();
        Product product1 = productService.findById(id);
        product1.setName(product.getName());
        product1.setDescription(product.getDescription());
        product1.setManufacturer(product.getManufacturer());
        product1.setStatus(product.getStatus());
        product1.setUnit(product.getUnit());
        if(lastProductPrice.getPrice()!=product1.getProductPrices().get(product1.getProductPrices().size()-1).getPrice()){
            List<ProductPrice> productPrices = product1.getProductPrices();
            lastProductPrice.setPrice_date_time(LocalDateTime.now());
            lastProductPrice.setProduct(product1);
            productPrices.add(lastProductPrice);
            product1.setProductPrices(productPrices);
        }

        productRepository.save(product1);
        modelAndView.setViewName("redirect:/admin/products");
        return modelAndView;
    }
}
