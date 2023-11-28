package vn.edu.iuh.fit.week07_lab_voquocthinh.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.enums.ProductStatus;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByStatusIsNot(ProductStatus status);
    @Query("SELECT p FROM Product p WHERE p.name LIKE %:keyword% and p.status != :status")
    List<Product> findByNameLikeAndStatusIsNot(@Param("keyword")  String keyword, @Param("status") ProductStatus status);
    @Query("SELECT distinct p.manufacturer FROM Product p")
    List<String> findAllManufacturerName();
    List<Product> findByManufacturerAndStatusIsNot(String manufacturerName,ProductStatus status);
    @Query("SELECT p FROM Product p WHERE p.product_id = :id and p.status != :status")
    Product findByProduct_idAndStatusIsNot(@Param("id") long id, @Param("status") ProductStatus status);
}
