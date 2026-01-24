package com.my.project.interfaces.core.domain.weather;

import com.my.project.api.domain.user.IUserService;
import com.my.project.api.domain.weather.IWeatherService;
import com.my.project.api.domain.weather.dto.SwissCities;
import com.my.project.interfaces.api.domain.user.UserRestClient;
import com.my.project.interfaces.api.domain.user.dto.UserAPI;
import com.my.project.interfaces.api.domain.user.dto.UserDTOSearchRequestAPI;
import com.my.project.interfaces.api.domain.weather.WeatherRestClient;
import com.my.project.interfaces.api.domain.weather.dto.WeatherConditionAPI;
import com.my.project.interfaces.core.domain.user.mapper.UserAPIMapper;
import com.my.project.interfaces.core.domain.weather.mapper.WeatherConditionAPIMapper;
import io.inugami.framework.interfaces.models.search.SearchResponse;
import io.inugami.framework.interfaces.models.search.SearchResponseMapperUtils;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

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
