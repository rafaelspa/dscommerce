package com.devsuperior.dscommerce.services;

import com.devsuperior.dscommerce.dto.ProductDto;
import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public ProductDto findById(Long id) {
        Product product = productRepository.findById(id).get();
        return new ProductDto(product);
    }

    @Transactional(readOnly = true)
    public Page<ProductDto> findAll(Pageable pageable) {
        Page<Product> result = productRepository.findAll(pageable);
        return result.map(ProductDto::new);
    }

    @Transactional
    public ProductDto insert(ProductDto productDto) {

        Product entity = new Product();
        entity.setName(productDto.getName());
        entity.setDescription(productDto.getDescription());
        entity.setImgUrl(productDto.getImgUrl());
        entity.setPrice(productDto.getPrice());

        entity = productRepository.save(entity);

        return new ProductDto(entity);
    }
}
