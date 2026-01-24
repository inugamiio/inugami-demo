package com.my.project.interfaces.core.domain.weather.mapper;

import com.my.project.api.domain.weather.dto.WeatherConditionDTO;
import com.my.project.interfaces.api.domain.weather.dto.WeatherConditionAPI;
import org.mapstruct.Mapper;

@Mapper()
public interface WeatherConditionAPIMapper {

    WeatherConditionAPI convertToRest(final WeatherConditionDTO value);

}
