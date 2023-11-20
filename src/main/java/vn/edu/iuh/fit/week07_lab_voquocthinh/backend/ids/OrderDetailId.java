package vn.edu.iuh.fit.week07_lab_voquocthinh.backend.ids;

import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.Order;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.Product;

import java.io.Serializable;

public class OrderDetailId implements Serializable {
    private Order order;
    private Product product;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
