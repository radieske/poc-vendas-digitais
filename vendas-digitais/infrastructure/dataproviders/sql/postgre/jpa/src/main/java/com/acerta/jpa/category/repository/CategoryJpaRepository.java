package com.acerta.jpa.category.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.acerta.domain.category.CategoryDomain;
import com.acerta.domain.category.gateway.CategoryDomainGateway;
import com.acerta.jpa.category.CategoryJpaMapper;
import com.acerta.jpa.category.CategoryJpaModel;

public class CategoryJpaRepository implements CategoryDomainGateway {
    private final EntityManager entityManager;

    public CategoryJpaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
      }
    
    @Override
    public String create(CategoryDomain categoryDomain){
        CategoryJpaModel categoryJpaModel = CategoryJpaMapper.fromDomain(categoryDomain);

        entityManager.persist(categoryJpaModel);

        return categoryJpaModel.getId();
    }

    @Override
    public String update(CategoryDomain categoryDomain){
        CategoryJpaModel categoryJpaModel = CategoryJpaMapper.fromDomain(categoryDomain);

        entityManager.merge(categoryJpaModel);

        return categoryJpaModel.getId();
    }

    @Override
    public CategoryDomain getById(String id){
        CategoryJpaModel categoryJpaModel = entityManager.find(CategoryJpaModel.class, id);

        return CategoryJpaMapper.toDomain(categoryJpaModel);
    }
    
    @Override
    public List<CategoryDomain> getAll(){
        List<CategoryJpaModel> categoryJpaModelList = entityManager.createQuery("SELECT c FROM CategoryJpaModel c", CategoryJpaModel.class).getResultList();

        return CategoryJpaMapper.toDomain(categoryJpaModelList);
    } 
}
