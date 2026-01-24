package com.my.project.infrastructure.spring;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.inugami.framework.commons.spring.configuration.Inugami;
import jakarta.annotation.PreDestroy;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @since 2025-12-28
 */
@ComponentScan({
        Inugami.BASE_PACKAGE,
        "com.my.project.infrastructure"
})
@SpringBootApplication
public class SpringBootITConfiguration {
    @PreDestroy
    public void shutdown(){
        final var wireMockServer = WireMockBootInitializer.SERVER.get();
        if(wireMockServer!=null){
            wireMockServer.shutdown();
        }
    }

    @Bean
    public WireMockServer wireMockServer(){
        return WireMockBootInitializer.SERVER.get();
    }
}
