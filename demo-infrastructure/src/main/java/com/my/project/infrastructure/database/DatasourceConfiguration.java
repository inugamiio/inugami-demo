package com.my.project.infrastructure.database;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @since 2025-12-28
 */
@EnableJpaRepositories(basePackages = "com.my.project.infrastructure.database")
@EntityScan(basePackages = "com.my.project.infrastructure.database")
@EnableTransactionManagement
@Configuration
public class DatasourceConfiguration {
}
