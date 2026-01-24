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
package com.my.project.api.domain.weather.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @since 2026-01-24
 */
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class WeatherConditionDTO implements Serializable {
    private String code;
    private String label;
    private String icon;

    @ToString.Include
    private double        temperature;
    private double        windspeed;
    @ToString.Include
    private int           weathercode;
    @ToString.Include
    @EqualsAndHashCode.Include
    private LocalDateTime time;
    @EqualsAndHashCode.Include
    private double        latitude;
    @EqualsAndHashCode.Include
    private double        longitude;
    private double        elevation;
}
