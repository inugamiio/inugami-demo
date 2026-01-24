/* --------------------------------------------------------------------
 *  Inugami
 * --------------------------------------------------------------------
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 3.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.my.project.infrastructure.webservice.openmeteo.mapper;

import com.my.project.infrastructure.webservice.openmeteo.dto.WeatherConditionType;
import com.my.project.infrastructure.webservice.openmeteo.dto.WeatherResponseDTO;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @since 2026-01-24
 */
@UtilityClass
public class WeatherResponseDTOMapperUtils {

    public static LocalDateTime convertTime(final WeatherResponseDTO value) {
        if (value == null || value.getCurrentWeather() == null || value.getCurrentWeather().getTime() == null) {
            return null;
        }
        return LocalDateTime.parse(value.getCurrentWeather().getTime(), DateTimeFormatter.ISO_DATE_TIME);
    }


    public static String convertCode(final WeatherResponseDTO value) {
        return resolveType(value).name();
    }


    public static String convertLabel(final WeatherResponseDTO value) {
        return resolveType(value).getLabel();
    }

    public static String convertIcon(final WeatherResponseDTO value) {
        return resolveType(value).getIconKey();
    }

    private static WeatherConditionType resolveType(final WeatherResponseDTO value) {
        if (value == null || value.getCurrentWeather() == null) {
            return WeatherConditionType.UNDEFINED;
        }
        return WeatherConditionType.fromCode(value.getCurrentWeather().getWeathercode());
    }
}
