package shilkin.mishop.controller;

import org.springframework.web.bind.annotation.*;
import shilkin.mishop.dto.ProductDTO;
import shilkin.mishop.mapper.ProductMapper;
import shilkin.mishop.model.Product;
import shilkin.mishop.service.ProductService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @PostMapping()
    public ProductDTO saveProduct(@RequestBody @Valid ProductDTO productDTO) {
        return productMapper.toProductDTO(productService.saveProduct(productMapper.toProduct(productDTO)));
    }

    @GetMapping("/category")
    public List<Product> findProductListByCategoryId(@RequestParam("id") Long id) {
        return productService.findProductByCategoryId(id);
    }

    @GetMapping("/product-name")
    public List<Product> findProductListByName(@RequestParam("name") String name) {
        return productService.findByName(name);
    }
}
