package com.api.folium.enums;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LeafColorTest {
    @ParameterizedTest
    @CsvSource({
            "DARK_GREEN, DARK_GREEN",
            "ORANGE, ORANGE",
            "YELLOW, YELLOW",
            "LIGHT_GREEN, LIGHT_GREEN",
            "PURPLE, PURPLE",
            "RED, RED",
            "VARIEGATED, VARIEGATED"
    })
    void testFromValue(String input, LeafColor expected) {
        assertThat(expected).isEqualTo(LeafColor.valueOf(input));
    }

    @Test
    void testEnumMatchedDatabaseDefinition() {
        String[] expectedDBValues = {"DARK_GREEN", "ORANGE", "YELLOW", "LIGHT_GREEN",
                "PURPLE", "RED", "VARIEGATED"};
        LeafColor[] enumValues = LeafColor.values();

        assertThat(expectedDBValues.length).isEqualTo(enumValues.length);
        for(int i = 0; i < expectedDBValues.length; i++) {
            assertThat(expectedDBValues[i]).isEqualTo(enumValues[i].name());
        }
    }
}
