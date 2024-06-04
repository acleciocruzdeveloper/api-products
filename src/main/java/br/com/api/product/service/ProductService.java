package br.com.api.product.service;

import br.com.api.product.dto.ProductDTO;
import br.com.api.product.model.Product;
import br.com.api.product.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductDTO::converter)
                .collect(Collectors.toList());
    }

    public List<ProductDTO> getProductByCategoryId(Long categoryId) {
        return productRepository.getProductByCategory(categoryId)
                .stream()
                .map(ProductDTO::converter)
                .collect(Collectors.toList());
    }

    public ProductDTO findByProductIdentifier(String productIdentifier) {
        try {
            Product byProductIdentifier = productRepository.findByProductIdentifier(productIdentifier);
            return ProductDTO.converter(byProductIdentifier);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public ProductDTO save(ProductDTO productDTO) {
        Product product = productRepository.save(Product.converter(productDTO));
        return ProductDTO.converter(product);
    }

    public void delete(long productId) throws BadRequestException {
        var product = productRepository.findById(productId);
        product.ifPresent(productRepository::delete);
        }
}
