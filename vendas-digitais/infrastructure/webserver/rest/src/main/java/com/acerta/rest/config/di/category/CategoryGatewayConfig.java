package com.acerta.rest.config.di.category;




import javax.persistence.EntityManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.acerta.domain.category.gateway.CategoryDomainGateway;
import com.acerta.jpa.category.repository.CategoryJpaRepository;

@Configuration
public class CategoryGatewayConfig {
    // @Autowired
    private final EntityManager entityManager;

    public CategoryGatewayConfig(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Bean
    CategoryDomainGateway categoryDomainGateway() {
        return new CategoryJpaRepository(entityManager);
    }
}
