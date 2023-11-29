package vn.edu.iuh.fit.week07_lab_voquocthinh.frontend.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.Product;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.repositories.ProductRepository;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.services.ProductService;
import vn.edu.iuh.fit.week07_lab_voquocthinh.frontend.dto.CartItem;

import java.util.HashMap;

@Controller
public class CartController {
    @Autowired
    private ProductService productService;

    @GetMapping("/add-cart")
    public String add2Cart(HttpSession session, @RequestParam ("id") long id,
                           @RequestParam ("quantity") int quantity) {
        Object obj = session.getAttribute("items");

        Product product = productService.findById(id);

        HashMap<Long, CartItem> cart;

        if (obj == null)
            cart = new HashMap<>();
        else
            cart = (HashMap<Long, CartItem>) obj;

        CartItem item = new CartItem(product, quantity);
        if (cart.get(product.getProduct_id()) != null)
            item.setAmount(item.getAmount() + quantity);
        cart.put(product.getProduct_id(),item);

        session.setAttribute("items", cart);

        return "redirect:/product-details/"+id;
    }

    @GetMapping("/remove-cart")
    public String add2Cart(HttpSession session, @RequestParam ("id") long id) {
        Object obj = session.getAttribute("items");

        Product product = productService.findById(id);

        HashMap<Long, CartItem> cart = (HashMap<Long, CartItem>) obj;

        cart.remove(product.getProduct_id());

        session.setAttribute("items", cart);

        return "redirect:/home";
    }
}
