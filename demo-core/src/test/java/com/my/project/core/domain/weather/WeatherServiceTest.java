package com.my.project.core.domain.weather;

import com.my.project.api.domain.weather.IWeatherDAO;
import com.my.project.api.domain.weather.dto.SwissCities;
import com.my.project.api.domain.weather.dto.WeatherConditionDTO;
import io.inugami.commons.test.UnitTestData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static io.inugami.commons.test.UnitTestHelper.assertText;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherServiceTest {

    //==================================================================================================================
    // ATTRIBUTES
    //==================================================================================================================
    @Mock
    private IWeatherDAO    weatherDAO;
    @InjectMocks
    private WeatherService weatherService;

    //==================================================================================================================
    // READ
    //==================================================================================================================
    @Test
    void getWeather_nominal() {
        when(weatherDAO.getWeather(SwissCities.VERSOIX)).thenReturn(buildWeatherConditionDTO());
        assertText(weatherService.getWeather(SwissCities.VERSOIX),
                   """
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