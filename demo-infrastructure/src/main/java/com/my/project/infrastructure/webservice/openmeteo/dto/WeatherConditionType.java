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
package com.my.project.infrastructure.webservice.openmeteo.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@Getter
@RequiredArgsConstructor
public enum WeatherConditionType {
    UNDEFINED(-1, "Not defined", "undefined"),
    CLEAR(0, "Clear sky", "sunny"),
    MAINLY_CLEAR(1, "Mainly clear", "cloudy-sunny"),
    PARTIALLY_CLOUDY(2, "Partly cloudy", "cloudy"),
    OVERCAST(3, "Overcast", "cloudy-dense"),
    FOG(45, "Fog", "fog"),
    RIME_FOG(48, "Depositing rime fog", "fog-ice"),
    DRIZZLE_LIGHT(51, "Light drizzle", "rain-light"),
    DRIZZLE_MODERATE(53, "Moderate drizzle", "rain"),
    DRIZZLE_DENSE(55, "Dense drizzle", "rain-heavy"),
    RAIN_SLIGHT(61, "Slight rain", "rain-light"),
    RAIN_MODERATE(63, "Moderate rain", "rain"),
    RAIN_HEAVY(65, "Heavy rain", "rain-heavy"),
    SNOW_FALL_SLIGHT(71, "Slight snow fall", "snow-light"),
    SNOW_FALL_MODERATE(73, "Moderate snow fall", "snow"),
    SNOW_FALL_HEAVY(75, "Heavy snow fall", "snow-heavy"),
    SNOW_GRAINS(77, "Snow grains", "snow-grains"),
    RAIN_SHOWERS_SLIGHT(80, "Slight rain showers", "rain-showers"),
    RAIN_SHOWERS_MODERATE(81, "Moderate rain showers", "rain-showers"),
    RAIN_SHOWERS_VIOLENT(82, "Violent rain showers", "rain-showers-heavy"),
    SNOW_SHOWERS_SLIGHT(85, "Slight snow showers", "snow-showers"),
    SNOW_SHOWERS_HEAVY(86, "Heavy snow showers", "snow-showers-heavy"),
    THUNDERSTORM(95, "Thunderstorm", "thunderstorm"),
    THUNDERSTORM_HAIL_SLIGHT(96, "Thunderstorm with slight hail", "thunderstorm-hail"),
    THUNDERSTORM_HAIL_HEAVY(99, "Thunderstorm with heavy hail", "thunderstorm-hail-heavy");

    private static final Collection<WeatherConditionType> VALUES =
            Collections.unmodifiableCollection(Arrays.asList(values()));
    private final        int                              code;
    private final        String                           label;
    private final        String                           iconKey;

    public static WeatherConditionType fromCode(int code) {
        return VALUES.stream()
                     .filter(condition -> condition.code == code)
                     .findFirst()
                     .orElse(UNDEFINED);
    }
}
