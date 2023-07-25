package com.acerta.rest.dto;

public class CategoryDTO {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryDTO() {
    }

    public CategoryDTO(String name) {
        this.name = name;
    }
}
