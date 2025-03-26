package com.api.folium.enums;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PlantTypeTest {
    @ParameterizedTest
    @CsvSource({
            "LIANA, LIANA",
            "SUBSHRUB,SUBSHRUB",
            "SHRUB, SHRUB",
            "TREE, TREE",
            "PARASITE, PARASITE"
    })
    void testFromValue(String input, PlantType expected) {
        assertThat(expected).isEqualTo(PlantType.valueOf(input));
    }

    @Test
    void testEnumMatchedDatabaseDefinition() {
        String[] expectedDBValues = {"LIANA", "SUBSHRUB", "SHRUB", "TREE", "PARASITE"};
        PlantType[] enumValues = PlantType.values();

        assertThat(expectedDBValues.length).isEqualTo(enumValues.length);
        for(int i = 0; i < expectedDBValues.length; i++) {
            assertThat(expectedDBValues[i]).isEqualTo(enumValues[i].name());
        }
    }
}
