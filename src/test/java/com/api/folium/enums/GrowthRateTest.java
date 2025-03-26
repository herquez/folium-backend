package com.api.folium.enums;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class GrowthRateTest {
    @ParameterizedTest
    @CsvSource({
            "HIGH, HIGH",
            "MEDIUM, MEDIUM",
            "LOW, LOW"
    })
    void testFromValue(String input, GrowthRate expected) {
        assertThat(expected).isEqualTo(GrowthRate.valueOf(input));
    }

    @Test
    void testEnumMatchedDatabaseDefinition() {
        String[] expectedDBValues = {"HIGH", "MEDIUM", "LOW"};
        GrowthRate[] enumValues = GrowthRate.values();

        assertThat(expectedDBValues.length).isEqualTo(enumValues.length);
        for(int i = 0; i < expectedDBValues.length; i++) {
            assertThat(expectedDBValues[i]).isEqualTo(enumValues[i].name());
        }
    }
}
