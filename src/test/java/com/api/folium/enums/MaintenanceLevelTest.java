package com.api.folium.enums;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MaintenanceLevelTest {
    @ParameterizedTest
    @CsvSource({
            "HIGH, HIGH",
            "MEDIUM, MEDIUM",
            "LOW, LOW"
    })
    void testFromValue(String input, MaintenanceLevel expected) {
        assertThat(expected).isEqualTo(MaintenanceLevel.valueOf(input));
    }

    @Test
    void testEnumMatchedDatabaseDefinition() {
        String[] expectedDBValues = {"HIGH", "MEDIUM", "LOW"};
        MaintenanceLevel[] enumValues = MaintenanceLevel.values();

        assertThat(expectedDBValues.length).isEqualTo(enumValues.length);
        for(int i = 0; i < expectedDBValues.length; i++) {
            assertThat(expectedDBValues[i]).isEqualTo(enumValues[i].name());
        }
    }
}
