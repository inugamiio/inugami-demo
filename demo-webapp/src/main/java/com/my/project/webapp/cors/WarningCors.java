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
package com.my.project.webapp.cors;

import com.my.project.api.domain.user.exception.UserWarning;
import io.inugami.framework.interfaces.configurtation.ConfigHandler;
import io.inugami.framework.interfaces.exceptions.Warning;
import io.inugami.framework.interfaces.monitoring.core.CorsHeadersSpi;
import io.inugami.framework.interfaces.monitoring.data.RequestData;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @since 2026-01-06
 */
@Component
public class WarningCors implements CorsHeadersSpi {
    @Override
    public List<String> buildCorsHeaders(final RequestData request, final ConfigHandler<String, String> configuration) {
        return UserWarning.VALUES.stream()
                                 .map(Warning::getWarningCode)
                                 .toList();
    }
}
