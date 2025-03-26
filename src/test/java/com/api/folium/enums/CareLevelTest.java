package com.api.folium.enums;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CareLevelTest {
    @ParameterizedTest
    @CsvSource({
            "HIGH, HIGH",
            "MEDIUM, MEDIUM",
            "LOW, LOW"
    })
    void testFromValue(String input, CareLevel expected) {
        assertThat(expected).isEqualTo(CareLevel.valueOf(input));
    }

    @Test
    void testEnumMatchedDatabaseDefinition() {
        String[] expectedDBValues = {"HIGH", "MEDIUM", "LOW"};
        CareLevel[] enumValues = CareLevel.values();

        assertThat(expectedDBValues.length).isEqualTo(enumValues.length);
        for(int i = 0; i < expectedDBValues.length; i++) {
            assertThat(expectedDBValues[i]).isEqualTo(enumValues[i].name());
        }
    }
}
