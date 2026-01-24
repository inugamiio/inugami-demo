package com.my.project.interfaces.core.domain.weather;

import com.my.project.api.domain.weather.IWeatherService;
import com.my.project.api.domain.weather.dto.WeatherConditionDTO;
import com.my.project.interfaces.api.domain.weather.WeatherRestClient;
import com.my.project.interfaces.core.domain.weather.mapper.WeatherRestMapperConfiguration;
import io.inugami.commons.test.UnitTestData;
import io.inugami.commons.test.mock.MockContext;
import io.inugami.commons.test.mock.MockGenerator;
import io.inugami.commons.test.mock.MockOpenApiContext;
import io.inugami.framework.interfaces.exceptions.ErrorCode;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.my.project.api.domain.weather.exception.WeatherErrors.*;
import static io.inugami.commons.test.UnitTestHelper.assertText;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherRestControllerTest {
    //==================================================================================================================
    // ATTRIBUTES
    //==================================================================================================================
    private static final String          BASE_FOLDER = "interfaces/api/domain/weather/weatherRestClient/";
    private static final String          GET_BY_CITY = BASE_FOLDER + "getByCity";
    public static final  String          BASE_PATH   = "ws/weather";
    public static final  String          VERSOIX     = "versoix";
    @Mock
    private              IWeatherService weatherService;

    @AfterAll
    public static void generateOpenApi() {
        MockGenerator.generateOpenApiDocumentation(MockOpenApiContext.builder()
                                                                     .restClientClass(WeatherRestClient.class)
                                                                     .folders(List.of(GET_BY_CITY))
                                                                     .build());
    }

    //==================================================================================================================
    // READ
    //==================================================================================================================
    @Test
    void getByCity_nominal() {
        when(weatherService.getWeather(any())).thenReturn(buildWeatherConditionDTO());
        final var response = controller().getByCity(VERSOIX);
        assertText(response, """
                {
                  "code" : "OVERCAST",
                  "elevation" : 387.0,
                  "icon" : "cloudy-dense",
                  "label" : "cloudy-dense",
                  "latitude" : 46.28,
                  "longitude" : 6.1599994,
                  "temperature" : 2.1,
                  "time" : "2023-06-01T12:00:00",
                  "weathercode" : 3,
                  "windspeed" : 8.6
                }
                """);


        MockGenerator.generate(MockContext.builder()
                                          .folder(GET_BY_CITY)
                                          .get(BASE_PATH + "/{city}")
                                          .addRequestParam("city", VERSOIX)
                                          .addRequestHeaderTracking()
                                          .addResponseHeaderTracking()
                                          .statusSuccess()
                                          .responsePayload(response)
                                          .build());

        final List<ErrorCode> errors = List.of(READ_CITY_REQUIRED,
                                               READ_UNKNOWN_CITY,
                                               READ_WEATHER_NOT_FOUND);

        for (ErrorCode error : errors) {
            MockGenerator.generate(MockContext.builder()
                                              .folder(GET_BY_CITY)
                                              .get(BASE_PATH + "/{city}")
                                              .addRequestParam("city", VERSOIX)
                                              .addRequestHeaderTracking()
                                              .addResponseHeaderTracking()
                                              .statusSuccess()
                                              .errorCode(error)
                                              .build());
        }
    }

    //==================================================================================================================
    // TOOLS
    //==================================================================================================================
    private WeatherRestController controller() {
        return WeatherRestController.builder()
                                    .service(weatherService)
                                    .weatherConditionAPIMapper(new WeatherRestMapperConfiguration().weatherConditionAPIMapper())
                                    .build();
    }

    private WeatherConditionDTO buildWeatherConditionDTO() {
        return WeatherConditionDTO.builder()
                                  .code("OVERCAST")
                                  .elevation(387.0)
                                  .icon("cloudy-dense")
                                  .label("cloudy-dense")
                                  .latitude(46.28)
                                  .longitude(6.1599994)
                                  .temperature(2.1)
                                  .time(UnitTestData.DATE_TIME)
                                  .weathercode(3)
                                  .windspeed(8.6)
                                  .build();
    }
}