package com.alexistapia.restful.infrastructure.configuration;

import com.alexistapia.restful.domain.port.out.ProductoRepositoryPort;
import com.alexistapia.restful.infrastructure.adapter.out.persistence.ProductoJpaAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ProductoRepositoryPort productoRepositoryPort(ProductoJpaAdapter productoJpaAdapter) {
        return productoJpaAdapter;
    }
}

