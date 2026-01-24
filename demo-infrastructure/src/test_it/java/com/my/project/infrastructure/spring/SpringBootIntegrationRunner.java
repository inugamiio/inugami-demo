package com.my.project.infrastructure.spring;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

/**
 * @since 2025-12-28
 */
@ActiveProfiles("test")

@ContextConfiguration(
        initializers = {
                WireMockBootInitializer.class
        })
@SpringBootTest(classes={SpringBootITConfiguration.class})
public class SpringBootIntegrationRunner {

}
