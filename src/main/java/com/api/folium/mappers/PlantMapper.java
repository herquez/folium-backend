package com.api.folium.mappers;

import com.api.folium.DTO.PlantDTO;
import com.api.folium.entities.Plant;
import com.api.folium.entities.PropagationMethod;
import com.api.folium.entities.SunlightRequirement;
import com.api.folium.enums.*;
import org.mapstruct.*;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PlantMapper {

    @Mapping(target = "plantType", source = "type")
    @Mapping(target = "plantCycle", source = "cycle")
    @Mapping(target = "wateringFrequency", source = "watering")
    @Mapping(target = "maintenanceLevel", source = "maintenance")
    @Mapping(target = "propagationMethods", source = "propagationMethods")
    @Mapping(target = "sunlightRequirements", source = "sunlightRequirements")
    PlantDTO toDTO(Plant plant);

    @Mapping(target = "type", source = "plantType")
    @Mapping(target = "cycle", source = "plantCycle")
    @Mapping(target = "watering", source = "wateringFrequency")
    @Mapping(target = "maintenance", source = "maintenanceLevel")
    @Mapping(target = "propagationMethods", source = "propagationMethods")
    @Mapping(target = "sunlightRequirements", source = "sunlightRequirements")
    Plant toEntity(PlantDTO plantDTO);

    // Enum to String conversions
    default String mapPlantType(PlantType type) {
        return type != null ? type.name() : null;
    }

    default String mapPlantCycle(PlantCycle cycle) {
        return cycle != null ? cycle.name() : null;
    }

    default String mapWateringFrequency(WateringFrequency watering) {
        return watering != null ? watering.name() : null;
    }

    default String mapSeason(Season season) {
        return season != null ? season.name() : null;
    }

    default String mapHarvestMethodType(HarvestMethodType method) {
        return method != null ? method.name() : null;
    }

    default String mapGrowthRate(GrowthRate rate) {
        return rate != null ? rate.name() : null;
    }

    default String mapMaintenanceLevel(MaintenanceLevel level) {
        return level != null ? level.name() : null;
    }

    default String mapCareLevel(CareLevel level) {
        return level != null ? level.name() : null;
    }

    default String[] mapLeafColors(LeafColor[] colors) {
        if (colors == null) return null;
        String[] result = new String[colors.length];
        for (int i = 0; i < colors.length; i++) {
            result[i] = colors[i].name();
        }
        return result;
    }

    // String to Enum conversions
    default PlantType mapStringToPlantType(String type) {
        return type != null ? PlantType.valueOf(type) : null;
    }

    default PlantCycle mapStringToPlantCycle(String cycle) {
        return cycle != null ? PlantCycle.valueOf(cycle) : null;
    }

    default WateringFrequency mapStringToWateringFrequency(String watering) {
        return watering != null ? WateringFrequency.valueOf(watering) : null;
    }

    default Season mapStringToSeason(String season) {
        return season != null ? Season.valueOf(season) : null;
    }

    default HarvestMethodType mapStringToHarvestMethodType(String method) {
        return method != null ? HarvestMethodType.valueOf(method) : null;
    }

    default GrowthRate mapStringToGrowthRate(String rate) {
        return rate != null ? GrowthRate.valueOf(rate) : null;
    }

    default MaintenanceLevel mapStringToMaintenanceLevel(String level) {
        return level != null ? MaintenanceLevel.valueOf(level) : null;
    }

    default CareLevel mapStringToCareLevel(String level) {
        return level != null ? CareLevel.valueOf(level) : null;
    }

    default LeafColor[] mapStringsToLeafColors(String[] colors) {
        if (colors == null) return null;
        LeafColor[] result = new LeafColor[colors.length];
        for (int i = 0; i < colors.length; i++) {
            result[i] = LeafColor.valueOf(colors[i]);
        }
        return result;
    }

    // Set conversions
    default String[] mapPropagationMethodsToStrings(Set<PropagationMethod> methods) {
        if (methods == null) return null;
        return methods.stream()
                .map(PropagationMethod::getMethod)
                .toArray(String[]::new);
    }

    default String[] mapSunlightRequirementsToStrings(Set<SunlightRequirement> requirements) {
        if (requirements == null) return null;
        return requirements.stream()
                .map(SunlightRequirement::getRequirement)
                .toArray(String[]::new);
    }

    default Set<PropagationMethod> mapStringsToPropagationMethods(String[] methods) {
        if (methods == null) return null;
        return java.util.Arrays.stream(methods)
                .map(method -> PropagationMethod.builder().method(method).build())
                .collect(Collectors.toSet());
    }

    default Set<SunlightRequirement> mapStringsToSunlightRequirements(String[] requirements) {
        if (requirements == null) return null;
        return java.util.Arrays.stream(requirements)
                .map(req -> SunlightRequirement.builder().requirement(req).build())
                .collect(Collectors.toSet());
    }
}