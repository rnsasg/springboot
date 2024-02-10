package com.narayan.productservice.thirdpartyclients.productservice.fakestore;


import com.narayan.productservice.models.Category;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private String image;
    private String category;
    private String description;
    private double price;
}
