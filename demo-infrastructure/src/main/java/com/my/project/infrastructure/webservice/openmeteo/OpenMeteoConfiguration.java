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

import com.my.project.infrastructure.webservice.openmeteo.client.OpenMeteoWeather;
import feign.Client;
import feign.Contract;
import feign.RequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import io.inugami.framework.commons.spring.feign.FeignBuilder;
import io.inugami.framework.interfaces.rest.PartnerConfigurationDTO;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @since 2026-01-24
 */
@EnableConfigurationProperties(OpenMeteoProperties.class)
@Configuration
public class OpenMeteoConfiguration {





    @Bean
    public FeignBuilder openMeteoFeignBuilder(final Client client,
                                            final Encoder encoder,
                                            final Decoder decoder,
                                            final OpenMeteoProperties openMeteoPartnerConfiguration,
                                            final List<RequestInterceptor> interceptors,
                                            final Contract contract) {
        return FeignBuilder.builder()
                           .client(client)
                           .encoder(encoder)
                           .decoder(decoder)
                           .partnerConfiguration(openMeteoPartnerConfiguration.toPartnerConfigurationDTO())
                           .interceptors(interceptors)
                           .contract(contract)
                           .build()
                           .init();
    }
    //==================================================================================================================
    // CLIENTS
    //==================================================================================================================
    @Bean
    public OpenMeteoWeather openMeteoWeather(final FeignBuilder openMeteoFeignBuilder) {
        return openMeteoFeignBuilder.buildClient(OpenMeteoWeather.class);
    }
}
