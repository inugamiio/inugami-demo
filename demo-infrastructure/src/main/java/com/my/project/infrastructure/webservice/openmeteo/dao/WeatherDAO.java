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
package com.my.project.infrastructure.webservice.openmeteo.dao;

import com.my.project.api.domain.weather.IWeatherDAO;
import com.my.project.api.domain.weather.dto.SwissCities;
import com.my.project.api.domain.weather.dto.WeatherConditionDTO;
import com.my.project.infrastructure.webservice.openmeteo.client.OpenMeteoWeather;
import com.my.project.infrastructure.webservice.openmeteo.mapper.WeatherResponseDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @since 2026-01-24
 */
@Service
@RequiredArgsConstructor
public class WeatherDAO implements IWeatherDAO {

    //==================================================================================================================
    // ATTRIBUTES
    //==================================================================================================================
    private final OpenMeteoWeather openMeteoWeather;
    private final WeatherResponseDTOMapper weatherResponseDTOMapper;


    //==================================================================================================================
    // READ
    //==================================================================================================================

    @Override
    public WeatherConditionDTO getWeather(final SwissCities city) {
        final var resultSet = openMeteoWeather.getForecast(city.getLatitude(), city.getLongitude(), true);
        return weatherResponseDTOMapper.convertToDto(resultSet);
    }
}
