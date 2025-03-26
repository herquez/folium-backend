package com.api.folium.enums;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class WateringFrequencyTest {
    @ParameterizedTest
    @CsvSource({
            "FREQUENT, FREQUENT",
            "AVERAGE, AVERAGE",
            "MINIMUM, MINIMUM",
            "NONE, NONE"
    })
    void testFromValue(String input, WateringFrequency expected) {
        assertThat(expected).isEqualTo(WateringFrequency.valueOf(input));
    }

    @Test
    void testEnumMatchedDatabaseDefinition() {
        String[] expectedDBValues = {"FREQUENT", "AVERAGE", "MINIMUM", "NONE"};
        WateringFrequency[] enumValues = WateringFrequency.values();

        assertThat(expectedDBValues.length).isEqualTo(enumValues.length);
        for(int i = 0; i < expectedDBValues.length; i++) {
            assertThat(expectedDBValues[i]).isEqualTo(enumValues[i].name());
        }
    }
}
