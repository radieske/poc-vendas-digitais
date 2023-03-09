package com.acerta.category.create;

public class CreateCategoryCommand {
    private String name;


    private CreateCategoryCommand(String name) {
        this.name = name;
    }

    public CreateCategoryCommand with(String name) {
        return new CreateCategoryCommand(name);
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
