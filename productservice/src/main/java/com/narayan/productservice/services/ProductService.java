package com.narayan.productservice.services;
import com.narayan.productservice.dtos.GenericProductDto;
import com.narayan.productservice.exceptions.NotFoundException;

import java.util.List;

public interface ProductService {
    public GenericProductDto getProductById(Long id);
    public GenericProductDto createProduct(GenericProductDto genericProductDto);

    public GenericProductDto updateProductById(Long id,GenericProductDto genericProductDto);
    public List<GenericProductDto> getAllProducts();
    public  GenericProductDto deleteProduct(Long id) throws NotFoundException;
}
