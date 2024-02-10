package com.narayan.productservice.models;

import java.util.Objects;


public class Category extends BaseModel {
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public Category() {
    }


    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
