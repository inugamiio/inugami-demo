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
package com.my.project.core.domain.weather;

import com.my.project.api.domain.weather.IWeatherDAO;
import com.my.project.api.domain.weather.IWeatherService;
import com.my.project.api.domain.weather.dto.SwissCities;
import com.my.project.api.domain.weather.dto.WeatherConditionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.my.project.api.domain.weather.exception.WeatherErrors.*;
import static io.inugami.framework.interfaces.exceptions.Asserts.assertNotEquals;
import static io.inugami.framework.interfaces.exceptions.Asserts.assertNotNull;

/**
 * @since 2026-01-24
 */
@Service
@RequiredArgsConstructor
public class WeatherService implements IWeatherService {
    //==================================================================================================================
    // ATTRIBUTES
    //==================================================================================================================
    private final IWeatherDAO weatherDAO;

    //==================================================================================================================
    // READ
    //==================================================================================================================
    @Override
    public WeatherConditionDTO getWeather(final SwissCities city) {
        assertNotNull(READ_CITY_REQUIRED, city);
        assertNotEquals(READ_UNKNOWN_CITY, SwissCities.UNDEFINED.name(), city.name());
        final var result = weatherDAO.getWeather(city);
        assertNotNull(READ_WEATHER_NOT_FOUND, result);
        return result;
    }
}
