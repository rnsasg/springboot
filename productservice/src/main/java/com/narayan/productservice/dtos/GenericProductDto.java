package com.narayan.productservice.dtos;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GenericProductDto {
    private Long id;
    private String title;
    private String image;
    private String category;
    private String description;
    private double price;
}
