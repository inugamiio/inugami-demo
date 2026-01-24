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
package com.my.project.infrastructure.webservice.openmeteo;

import io.inugami.framework.interfaces.rest.PartnerConfigurationDTO;
import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @since 2026-01-24
 */
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "application.partners.openmeteo", ignoreUnknownFields = true)
public class OpenMeteoProperties {
    @Builder.Default
    private String baseUrl = "https://api.open-meteo.com";
    private String user;
    private String password;

    public PartnerConfigurationDTO toPartnerConfigurationDTO() {
        return PartnerConfigurationDTO.builder()
                                      .baseUrl(baseUrl)
                                      .user(user)
                                      .password(password)
                                      .build();
    }
}
