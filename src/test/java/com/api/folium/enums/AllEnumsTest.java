package com.api.folium.enums;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class AllEnumsTest {
    static Stream<Arguments> provideEnumClasses() {
        return Stream.of(
                Arguments.of(PlantType.class, 5),
                Arguments.of(PlantCycle.class, 3),
                Arguments.of(WateringFrequency.class, 4),
                Arguments.of(LeafColor.class, 7),
                Arguments.of(Season.class, 4),
                Arguments.of(HarvestMethodType.class, 4),
                Arguments.of(GrowthRate.class, 3),
                Arguments.of(MaintenanceLevel.class, 3),
                Arguments.of(CareLevel.class, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("provideEnumClasses")
    <T extends Enum<T>> void testEnumConstants(Class<T> enumClass, int expectedSize) {
        T[] values = enumClass.getEnumConstants();
        assertThat(expectedSize).isEqualTo(values.length);
    }
}
