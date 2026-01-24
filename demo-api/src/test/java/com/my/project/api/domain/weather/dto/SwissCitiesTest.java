package com.my.project.api.domain.weather.dto;

import io.inugami.commons.test.UnitTestHelper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SwissCitiesTest {

    @Test
    void assertEnum() {
        UnitTestHelper.assertEnum(SwissCities.class,
                                  """
                                          {
                                            "UNDEFINED" : {
                                              "latitude" : -1.0,
                                              "longitude" : -1.0
                                            },
                                            "VERSOIX" : {
                                              "latitude" : 46.2831,
                                              "longitude" : 6.1673
                                            },
                                            "GENEVE" : {
                                              "latitude" : 46.2044,
                                              "longitude" : 6.1432
                                            },
                                            "LAUSANNE" : {
                                              "latitude" : 46.5197,
                                              "longitude" : 6.6323
                                            }
                                          }
                                          """);
    }

    @Test
    void fromCode_nominal() {
        assertThat(SwissCities.fromCode("versoix")).isEqualTo(SwissCities.VERSOIX);
        assertThat(SwissCities.fromCode(null)).isEqualTo(SwissCities.UNDEFINED);
        assertThat(SwissCities.fromCode("other")).isEqualTo(SwissCities.UNDEFINED);
    }
}