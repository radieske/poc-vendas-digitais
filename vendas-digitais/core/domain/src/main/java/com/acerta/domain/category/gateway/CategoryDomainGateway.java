package com.acerta.domain.category.gateway;

import java.util.List;

import com.acerta.domain.category.CategoryDomain;

public interface CategoryDomainGateway {
    public String create(CategoryDomain categoryDomain);

    public String update(CategoryDomain categoryDomain);

    public CategoryDomain getById(String id);
    
    public List<CategoryDomain> getAll();
    
}
