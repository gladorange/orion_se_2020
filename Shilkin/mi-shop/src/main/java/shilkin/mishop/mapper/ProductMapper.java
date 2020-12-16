package shilkin.mishop.mapper;

import org.springframework.stereotype.Component;
import shilkin.mishop.dto.ProductDTO;
import shilkin.mishop.model.Category;
import shilkin.mishop.model.Product;

@Component
public class ProductMapper {
    public ProductDTO toProductDTO(Product product) {
        if (product == null) {
            return null;
        }
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        if (product.getCategory() != null) {
            dto.setCategoryId(product.getCategory().getId());
        }
        dto.setPrice(product.getPrice());
        dto.setProductCount(product.getProductCount());
        return dto;
    }

    public Product toProduct(ProductDTO productDTO) {
        if (productDTO == null) {
            return null;
        }
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        if (productDTO.getCategoryId() != null) {
            Category category = new Category();
            category.setId(productDTO.getCategoryId());
            product.setCategory(category);
        }
        product.setPrice(productDTO.getPrice());
        product.setProductCount(productDTO.getProductCount());
        return product;
    }
}
