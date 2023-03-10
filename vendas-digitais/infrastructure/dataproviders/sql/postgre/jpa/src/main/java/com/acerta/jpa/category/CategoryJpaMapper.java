package com.acerta.jpa.category;

import java.util.ArrayList;
import java.util.List;

import com.acerta.domain.category.CategoryDomain;

public class CategoryJpaMapper {
    public static CategoryJpaModel fromDomain(CategoryDomain categoryDomain) {
        CategoryJpaModel categoryJpaModel = new CategoryJpaModel();

        categoryJpaModel.setId(categoryDomain.getId());
        categoryJpaModel.setName(categoryDomain.getName());
        categoryJpaModel.setCreatedAt(categoryDomain.getCreatedAt());
        categoryJpaModel.setUpdatedAt(categoryDomain.getUpdatedAt());

        return categoryJpaModel;
    }

    public static CategoryDomain toDomain(CategoryJpaModel categoryJpaModel) {
        CategoryDomain categoryDomain = CategoryDomain.with(
            categoryJpaModel.getId(),
            categoryJpaModel.getName(),
            categoryJpaModel.getCreatedAt(),
            categoryJpaModel.getUpdatedAt()
        );

        return categoryDomain;
    }

    public static List<CategoryDomain> toDomain(List<CategoryJpaModel> categoryJpaModelList) {
        List<CategoryDomain> categoryDomainList = new ArrayList<CategoryDomain>();

        for (CategoryJpaModel categoryJpaModel : categoryJpaModelList) {
            CategoryDomain categoryDomain = CategoryJpaMapper.toDomain(categoryJpaModel);

            categoryDomainList.add(categoryDomain);
        }

        return categoryDomainList;
    }
}
