package com.my.project.interfaces.core.domain.weather.mapper;

import com.my.project.interfaces.core.domain.user.mapper.UserAPIMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @since 2025-12-29
 */
@Configuration
public class WeatherRestMapperConfiguration {
    @Bean
    public WeatherConditionAPIMapper weatherConditionAPIMapper() {
        return Mappers.getMapper(WeatherConditionAPIMapper.class);
    }
}
