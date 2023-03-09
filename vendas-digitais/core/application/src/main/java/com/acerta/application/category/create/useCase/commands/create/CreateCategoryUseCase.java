package com.acerta.category.create;

public interface CreateCategoryUseCase {
    CreateCategoryOutput execute(CreateCategoryCommand command);
}