package com.my.project.interfaces.core.domain.weather;

import com.my.project.api.domain.weather.IWeatherService;
import com.my.project.api.domain.weather.dto.SwissCities;
import com.my.project.interfaces.api.domain.weather.WeatherRestClient;
import com.my.project.interfaces.api.domain.weather.dto.WeatherConditionAPI;
import com.my.project.interfaces.core.domain.weather.mapper.WeatherConditionAPIMapper;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * @since 2025-12-29
 */
@RequiredArgsConstructor
@Builder
@RestController
public class WeatherRestController implements WeatherRestClient {
    //==================================================================================================================
    // ATTRIBUTES
    //==================================================================================================================
    private final IWeatherService           service;
    private final WeatherConditionAPIMapper weatherConditionAPIMapper;

    //==================================================================================================================
    // READ
    //==================================================================================================================
    @Override
    public WeatherConditionAPI getByCity(final String city) {
        final var result = service.getWeather(SwissCities.fromCode(city));
        return weatherConditionAPIMapper.convertToRest(result);
    }


}
