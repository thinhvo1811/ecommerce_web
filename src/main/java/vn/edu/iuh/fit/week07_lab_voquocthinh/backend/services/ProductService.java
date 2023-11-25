package vn.edu.iuh.fit.week07_lab_voquocthinh.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.enums.ProductStatus;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.Product;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.repositories.ProductRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> findByStatusIsNotTerminatedNotPaging(){
        return productRepository.findByStatusIsNot(ProductStatus.TERMINATED);
    }

    public List<String> findAllManufacturerName(){
        return productRepository.findAllManufacturerName();
    }

    public Page<Product> findByStatusIsNotTerminatedAndSortBySoldQuantity(int pageNo, int pageSize) {
        int startItem = pageNo * pageSize;
        List<Product> list;
        List<Product> products = productRepository.findByStatusIsNot(ProductStatus.TERMINATED);

        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o2.getSoldQuantity() - o1.getSoldQuantity();
            }
        });

        if (products.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, products.size());
            list = products.subList(startItem, toIndex);
        }

        Page<Product> productPage
                = new PageImpl<>(list, PageRequest.of(pageNo, pageSize), products.size());


        return productPage;
    }

    public Page<Product> findByStatusIsNotTerminatedAndSortByPriceAsc(int pageNo, int pageSize) {
        int startItem = pageNo * pageSize;
        List<Product> list;
        List<Product> products = productRepository.findByStatusIsNot(ProductStatus.TERMINATED);

        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) o1.getProductPrices().get(o1.getProductPrices().size()-1).getPrice() - (int) o2.getProductPrices().get(o2.getProductPrices().size()-1).getPrice();
            }
        });

        if (products.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, products.size());
            list = products.subList(startItem, toIndex);
        }

        Page<Product> productPage
                = new PageImpl<>(list, PageRequest.of(pageNo, pageSize), products.size());


        return productPage;
    }

    public Page<Product> findByStatusIsNotTerminatedAndSortByPriceDesc(int pageNo, int pageSize) {
        int startItem = pageNo * pageSize;
        List<Product> list;
        List<Product> products = productRepository.findByStatusIsNot(ProductStatus.TERMINATED);

        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) o2.getProductPrices().get(o2.getProductPrices().size()-1).getPrice() - (int) o1.getProductPrices().get(o1.getProductPrices().size()-1).getPrice();
            }
        });

        if (products.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, products.size());
            list = products.subList(startItem, toIndex);
        }

        Page<Product> productPage
                = new PageImpl<>(list, PageRequest.of(pageNo, pageSize), products.size());


        return productPage;
    }

    public Page<Product> findByManufacturerAndStatusIsNotTerminated(int pageNo, int pageSize, String manufacturerName) {
        int startItem = pageNo * pageSize;
        List<Product> list;
        List<Product> products = productRepository.findByManufacturerAndStatusIsNot(manufacturerName ,ProductStatus.TERMINATED);

        if (products.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, products.size());
            list = products.subList(startItem, toIndex);
        }

        Page<Product> productPage
                = new PageImpl<>(list, PageRequest.of(pageNo, pageSize), products.size());

        return productPage;
    }
}
