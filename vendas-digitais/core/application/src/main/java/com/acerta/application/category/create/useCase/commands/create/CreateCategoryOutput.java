package com.acerta.application.category.create.useCase.commands.create;

public class CreateCategoryOutput {
    private String id;

    private CreateCategoryOutput(String id) {
        this.id = id;
    }

    public static CreateCategoryOutput with(String id) {
        return new CreateCategoryOutput(id);
    }

    public String getId() {
        return this.id;
    }
}
