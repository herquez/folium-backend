package com.api.folium.enums;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class HarvestMethodTypeTest {
    @ParameterizedTest
    @CsvSource({
            "CUTTING, CUTTING",
            "PRUNING, PRUNING",
            "DIGGING, DIGGING",
            "MANUAL, MANUAL"
    })
    void testFromValue(String input, HarvestMethodType expected) {
        assertThat(expected).isEqualTo(HarvestMethodType.valueOf(input));
    }

    @Test
    void testEnumMatchedDatabaseDefinition() {
        String[] expectedDBValues = {"CUTTING", "PRUNING", "DIGGING", "MANUAL"};
        HarvestMethodType[] enumValues = HarvestMethodType.values();

        assertThat(expectedDBValues.length).isEqualTo(enumValues.length);
        for(int i = 0; i < expectedDBValues.length; i++) {
            assertThat(expectedDBValues[i]).isEqualTo(enumValues[i].name());
        }
    }
}
