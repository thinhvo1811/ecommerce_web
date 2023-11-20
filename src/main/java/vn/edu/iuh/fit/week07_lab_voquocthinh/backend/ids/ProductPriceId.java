package vn.edu.iuh.fit.week07_lab_voquocthinh.backend.ids;

import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.Product;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ProductPriceId implements Serializable {
    private Product product;
    private LocalDateTime price_date_time;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDateTime getPrice_date_time() {
        return price_date_time;
    }

    public void setPrice_date_time(LocalDateTime price_date_time) {
        this.price_date_time = price_date_time;
    }
}
