package com.api.folium.enums;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class SeasonTest {
    @ParameterizedTest
    @CsvSource({
            "HOURS, HOURS",
            "DAYS, DAYS",
            "WEEKS, WEEKS"
    })
    void testFromValue(String input, WateringUnit expected) {
        assertThat(expected).isEqualTo(WateringUnit.valueOf(input));
    }

    @Test
    void testEnumMatchedDatabaseDefinition() {
        String[] expectedDBValues = {"HOURS", "DAYS", "WEEKS"};
        WateringUnit[] enumValues = WateringUnit.values();

        assertThat(expectedDBValues.length).isEqualTo(enumValues.length);
        for(int i = 0; i < expectedDBValues.length; i++) {
            assertThat(expectedDBValues[i]).isEqualTo(enumValues[i].name());
        }
    }
}
