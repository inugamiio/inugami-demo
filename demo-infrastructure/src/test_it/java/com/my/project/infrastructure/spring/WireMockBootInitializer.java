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
package com.my.project.infrastructure.spring;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import io.inugami.framework.api.tools.PortGenerator;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @since 2026-01-24
 */
public class WireMockBootInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    public static final int                             SERVER_PORT = PortGenerator.generateFor("wiremock.port");
    public static final AtomicReference<WireMockServer> SERVER      = new AtomicReference<>();

    @Override
    public void initialize(final ConfigurableApplicationContext applicationContext) {
        System.setProperty("wiremock.port", String.valueOf(SERVER_PORT));

        WireMockServer result = new WireMockServer(WireMockConfiguration.wireMockConfig().port(SERVER_PORT));

        SERVER.set(result);
        result.start();
    }
}
