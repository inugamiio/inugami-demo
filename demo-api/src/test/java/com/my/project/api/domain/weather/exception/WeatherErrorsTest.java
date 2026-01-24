package com.my.project.api.domain.weather.exception;

import io.inugami.commons.test.UnitTestHelper;
import org.junit.jupiter.api.Test;

class WeatherErrorsTest {
    @Test
    void assertWeatherErrors() {
        UnitTestHelper.assertErrorCodeUnique(WeatherErrors.values());
        UnitTestHelper.assertErrorCode("api/domain/weather/exception/assertWeatherErrors.json",
                                       WeatherErrors.values());
    }
}