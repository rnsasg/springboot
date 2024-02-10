package com.narayan.productservice.services;

import com.narayan.productservice.dtos.GenericProductDto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements  ProductService{

    @Override
    public GenericProductDto getProductById(Long id) {
        return null;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return null;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        return null;
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {
        return null;
    }

    @Override
    public GenericProductDto updateProductById(Long id, GenericProductDto genericProductDto) {
        return null;
    }
}
