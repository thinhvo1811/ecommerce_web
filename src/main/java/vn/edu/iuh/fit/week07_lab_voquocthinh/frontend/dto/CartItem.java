package vn.edu.iuh.fit.week07_lab_voquocthinh.frontend.dto;

import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.Product;

import java.io.Serializable;

public class CartItem implements Serializable {
    private Product product;
    private int amount;

    public CartItem() {
    }

    public CartItem(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "product=" + product +
                ", amount=" + amount +
                '}';
    }
}
