package com.my.project.infrastructure.webservice.openmeteo.dao;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.my.project.api.domain.weather.dto.SwissCities;
import com.my.project.infrastructure.spring.SpringBootIntegrationRunner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.inugami.commons.test.UnitTestHelper.assertText;

class WeatherDAOIT extends SpringBootIntegrationRunner {
    //==================================================================================================================
    // ATTRIBUTES
    //==================================================================================================================
    @Autowired
    private WeatherDAO     weatherDAO;
    @Autowired
    private WireMockServer wireMockServer;

    //==================================================================================================================
    // READ
    //==================================================================================================================
    @Test
    void getWeather_nominal() {
        final String response = """
                {
                  "latitude": 46.28,
                  "longitude": 6.1599994,
                  "generationtime_ms": 0.05543231964111328,
                  "utc_offset_seconds": 0,
                  "timezone": "GMT",
                  "timezone_abbreviation": "GMT",
                  "elevation": 387.0,
                  "current_weather_units": {
                      "time": "iso8601",
                      "interval": "seconds",
                      "temperature": "°C",
                      "windspeed": "km/h",
                      "winddirection": "°",
                      "is_day": "",
                      "weathercode": "wmo code"
                  },
                  "current_weather": {
                      "time": "2026-01-24T06:15",
                      "interval": 900,
                      "temperature": 2.1,
                      "windspeed": 8.6,
                      "winddirection": 15,
                      "is_day": 0,
                      "weathercode": 3
                  }
              }
                """;
        wireMockServer.stubFor(get(urlPathEqualTo("/v1/forecast"))
                                       .willReturn(aResponse()
                                                           .withStatus(200)
                                                           .withHeader("Content-Type", "application/json")
                                                           .withBody(response)));

        assertText(weatherDAO.getWeather(SwissCities.VERSOIX),
                   """
                           {
                             "code" : "OVERCAST",
                             "elevation" : 387.0,
                             "icon" : "cloudy-dense",
                             "label" : "Overcast",
                             "latitude" : 46.28,
                             "longitude" : 6.1599994,
                             "temperature" : 2.1,
                             "time" : "2026-01-24T06:15:00",
                             "weathercode" : 3,
                             "windspeed" : 8.6
                           }
                           """);
    }

}