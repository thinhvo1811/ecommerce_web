package vn.edu.iuh.fit.week07_lab_voquocthinh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.enums.ProductStatus;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.Product;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.repositories.ProductRepository;

import java.util.List;
import java.util.Random;

@SpringBootApplication
public class Week07LabVoquocthinhApplication {
	@Autowired
	private ProductRepository productRepository;
	public static void main(String[] args) {
		SpringApplication.run(Week07LabVoquocthinhApplication.class, args);
	}

//	@Bean
	CommandLineRunner initData() {
		return args -> {
			List<Product> products = productRepository.findByNameLikeAndStatusIsNot("Giày",ProductStatus.TERMINATED);
			products.forEach(System.out::println);
		};
	}
}
