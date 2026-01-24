package com.my.project.infrastructure.webservice.openmeteo.mapper;

import com.my.project.api.domain.weather.dto.WeatherConditionDTO;
import com.my.project.infrastructure.webservice.openmeteo.dto.WeatherResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @since 2025-12-28
 */
@Mapper
public interface WeatherResponseDTOMapper {

    @Mapping(target = "temperature", source = "currentWeather.temperature")
    @Mapping(target = "windspeed", source = "currentWeather.windspeed")
    @Mapping(target = "weathercode", source = "currentWeather.weathercode")
    @Mapping(target="time", expression = "java(WeatherResponseDTOMapperUtils.convertTime(value))")
    @Mapping(target="code", expression = "java(WeatherResponseDTOMapperUtils.convertCode(value))")
    @Mapping(target="label", expression = "java(WeatherResponseDTOMapperUtils.convertLabel(value))")
    @Mapping(target="icon", expression = "java(WeatherResponseDTOMapperUtils.convertIcon(value))")
    WeatherConditionDTO convertToDto(final WeatherResponseDTO value);
}
