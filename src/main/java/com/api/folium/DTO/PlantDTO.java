package com.api.folium.DTO;

import com.api.folium.enums.*;

public class PlantDTO {
    private Long id;
    private String commonName;
    private String[] otherNames;
    private String plantType;
    private String plantCycle;
    private String wateringFrequency;
    private Double wateringValueMax;
    private Double wateringValueMin;
    private WateringUnit wateringUnit;
    private String[] leavesColor;
    private Boolean flowers;
    private String flowerSeason;
    private Boolean fruits;
    private String fruitingSeason;
    private String harvestMethod;
    private String growthRate;
    private String maintenanceLevel;
    private Boolean medical;
    private Boolean poisonousToHumans;
    private Boolean poisonousToPets;
    private Boolean cuisine;
    private Boolean indoor;
    private String careLevel;
    private String[] propagationMethods;
    private String[] sunlightRequirements;
}
