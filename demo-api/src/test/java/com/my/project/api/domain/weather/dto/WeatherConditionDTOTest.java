package com.my.project.api.domain.weather.dto;

import io.inugami.commons.test.UnitTestData;
import io.inugami.commons.test.dto.AssertDtoContext;
import org.junit.jupiter.api.Test;

import static io.inugami.commons.test.UnitTestHelper.assertDto;
import static org.assertj.core.api.Assertions.assertThat;

class WeatherConditionDTOTest {

    public static final int UNDEFINED = -1;

    @Test
    void weatherConditionDTO() {
        assertDto(AssertDtoContext.<WeatherConditionDTO>builder()
                                  .objectClass(WeatherConditionDTO.class)
                                  .cloneFunction(i -> i.toBuilder().build())
                                  .noArgConstructor(WeatherConditionDTO::new)
                                  .fullArgConstructor(this::buildValue)
                                  .fullArgConstructorRefPath("api/domain/weather/dto/weatherConditionDTO/model.json")
                                  .getterRefPath("api/domain/weather/dto/weatherConditionDTO/getter.json")
                                  .toStringRefPath("api/domain/weather/dto/weatherConditionDTO/toString.txt")
                                  .noEqualsFunction(this::notEquals)
                                  .checkSetters(true)
                                  .build());
    }

    private void notEquals(final WeatherConditionDTO instance) {
        assertThat(instance).isNotEqualTo(null);
        assertThat(instance).isNotEqualTo(instance.toBuilder());
        //
        assertThat(instance).isNotEqualTo(instance.toBuilder().time(null).build());
        assertThat(instance.toBuilder().time(null).build()).isNotEqualTo(instance);
        assertThat(instance).isNotEqualTo(instance.toBuilder().time(UnitTestData.DATE_TIME.minusHours(5)).build());
        assertThat(instance.toBuilder().time(UnitTestData.DATE_TIME.minusHours(5)).build()).isNotEqualTo(instance);
        assertThat(instance.hashCode()).isNotEqualTo(instance.toBuilder().time(null).build().hashCode());
        assertThat(instance.hashCode()).isNotEqualTo(instance.toBuilder()
                                                             .time(UnitTestData.DATE_TIME.minusHours(5))
                                                             .build()
                                                             .hashCode());
        //
        assertThat(instance).isNotEqualTo(instance.toBuilder().latitude(UNDEFINED).build());
        assertThat(instance.toBuilder().latitude(UNDEFINED).build()).isNotEqualTo(instance);
        assertThat(instance.hashCode()).isNotEqualTo(instance.toBuilder()
                                                             .latitude(UNDEFINED)
                                                             .build()
                                                             .hashCode());
        //
        assertThat(instance).isNotEqualTo(instance.toBuilder().longitude(UNDEFINED).build());
        assertThat(instance.toBuilder().longitude(UNDEFINED).build()).isNotEqualTo(instance);
        assertThat(instance.hashCode()).isNotEqualTo(instance.toBuilder()
                                                             .longitude(UNDEFINED)
                                                             .build()
                                                             .hashCode());
    }

    private WeatherConditionDTO buildValue() {
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
                                  .build()
                                  .toBuilder()
                                  .build();
    }
}