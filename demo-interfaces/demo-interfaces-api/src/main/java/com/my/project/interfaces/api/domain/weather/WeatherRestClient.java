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
package com.my.project.interfaces.api.domain.weather;

import com.my.project.interfaces.api.domain.weather.dto.WeatherConditionAPI;
import io.inugami.framework.interfaces.rest.GenericHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "ws/weather")
public interface WeatherRestClient {

    @GenericHeaders
    @GetMapping(path = "{city}", produces = MediaType.APPLICATION_JSON_VALUE)
    WeatherConditionAPI getByCity(@PathVariable(required = true) final String city);

}
