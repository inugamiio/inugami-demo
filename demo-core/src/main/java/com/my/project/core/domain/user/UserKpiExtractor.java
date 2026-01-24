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
package com.my.project.core.domain.user;

import io.inugami.framework.interfaces.models.HttpVerbs;
import io.inugami.framework.interfaces.monitoring.data.RequestData;
import io.inugami.framework.interfaces.monitoring.kpi.KpiExtractorContext;
import io.inugami.framework.interfaces.monitoring.kpi.KpiExtractorSPI;
import io.inugami.framework.interfaces.monitoring.models.GenericMonitoringModelDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @since 2026-01-08
 */
@Slf4j
@Component
public class UserKpiExtractor implements KpiExtractorSPI {
    // =================================================================================================================
    // ACCEPT
    // =================================================================================================================
    @Override
    public boolean accept(final RequestData request) {
        return request.getUri().contains("/user") && HttpVerbs.POST.equals(request.getMethod());
    }

    // =================================================================================================================
    // ON BEGIN
    // =================================================================================================================

    @Override
    public List<GenericMonitoringModelDTO> extractFromRequest(final KpiExtractorContext context) {
        return List.of(GenericMonitoringModelDTO.builder()
                                                .service("demo")
                                                .subService("user_request")
                                                .value(1L)
                                                .build());
    }

    // =================================================================================================================
    // ON BEGIN
    // =================================================================================================================
    @Override
    public List<GenericMonitoringModelDTO> extractFromResponse(final KpiExtractorContext context) {
        return List.of(GenericMonitoringModelDTO.builder()
                                                .service("demo")
                                                .subService("user_response")
                                                .value(1L)
                                                .build());
    }
}
