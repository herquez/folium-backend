package com.api.folium.enums;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PlantCycleTest {
    @ParameterizedTest
    @CsvSource({
            "ANNUAL, ANNUAL",
            "BIENNIAL, BIENNIAL",
            "PERENNIAL, PERENNIAL"
    })
    void testFromValue(String input, PlantCycle expected) {
        assertThat(expected).isEqualTo(PlantCycle.valueOf(input));
    }

    @Test
    void testEnumMatchedDatabaseDefinition() {
        String[] expectedDBValues = {"ANNUAL", "BIENNIAL", "PERENNIAL"};
        PlantCycle[] enumValues = PlantCycle.values();

        assertThat(expectedDBValues.length).isEqualTo(enumValues.length);
        for(int i = 0; i < expectedDBValues.length; i++) {
            assertThat(expectedDBValues[i]).isEqualTo(enumValues[i].name());
        }
    }
}
