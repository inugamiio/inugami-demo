package com.my.project.api.domain.weather.exception;

import io.inugami.framework.interfaces.exceptions.DefaultErrorCode;
import io.inugami.framework.interfaces.exceptions.ErrorCode;

import static io.inugami.framework.interfaces.exceptions.DefaultErrorCode.newBuilder;

public enum WeatherErrors implements ErrorCode {


    //==================================================================================================================
    // 2 - READ
    //==================================================================================================================
    READ_CITY_REQUIRED(newBuilder().errorCode("WEATHER-2_0")
                                  .message("city required")
                                  .domain(Constants.DOMAIN)
                                  .statusCode(400)
                                  .errorTypeFunctional()),
    READ_UNKNOWN_CITY(newBuilder().errorCode("WEATHER-2_1")
                                       .message("unknown city")
                                       .domain(Constants.DOMAIN)
                                       .statusCode(400)
                                       .errorTypeFunctional()),
    READ_WEATHER_NOT_FOUND(newBuilder().errorCode("WEATHER-2_2")
                                       .message("weather not found")
                                       .domain(Constants.DOMAIN)
                                       .statusCode(404)
                                       .errorTypeFunctional())

    ;


    private final ErrorCode errorCode;

    private WeatherErrors(final DefaultErrorCode.DefaultErrorCodeBuilder errorBuilder) {
        errorCode = errorBuilder.build();
    }

    @Override
    public ErrorCode getCurrentErrorCode() {
        return errorCode;
    }

    private static class Constants {
        public static final String DOMAIN = "WEATHER";
    }
}
