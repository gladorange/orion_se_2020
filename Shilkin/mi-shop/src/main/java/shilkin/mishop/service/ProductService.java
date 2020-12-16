package shilkin.mishop.service;

import org.springframework.stereotype.Service;
import shilkin.mishop.model.Product;
import shilkin.mishop.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findByName(String name) {
        return productRepository.findAllByName(name);
    }

    public List<Product> findProductByCategoryId(Long categoryId) {
        return productRepository.findProductByCategoryId(categoryId);
    }

}
