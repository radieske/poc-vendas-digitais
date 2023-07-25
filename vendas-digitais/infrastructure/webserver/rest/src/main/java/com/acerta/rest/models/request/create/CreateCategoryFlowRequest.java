package com.acerta.rest.models.request.create;

public class CreateCategoryFlowRequest {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CreateCategoryFlowRequest() {
    }

    public CreateCategoryFlowRequest(String name) {
        this.name = name;
    }

    
}
