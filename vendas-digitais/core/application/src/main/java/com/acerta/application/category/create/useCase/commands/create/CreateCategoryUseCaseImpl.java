package com.acerta.category.create;

import com.acerta.domain.category.CategoryDomain;
import com.acerta.domain.category.gateway.CategoryDomainGateway;

public class CreateCategoryUseCaseImpl implements CreateCategoryUseCase {
    private final CategoryDomainGateway categoryGateway;

    public CreateCategoryUseCaseImpl(CategoryDomainGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    @Override
    public CreateCategoryOutput execute(CreateCategoryCommand command) {
        CategoryDomain category = CategoryDomain.create(command.getName());

        category.validate();

        categoryGateway.create(category);

        return CreateCategoryOutput.with(category.getId());
    }
}
