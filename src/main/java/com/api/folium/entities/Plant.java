package com.api.folium.entities;

import com.api.folium.enums.*;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String commonName;

    @Column
    private String[] otherNames;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PlantType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PlantCycle cycle;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WateringFrequency watering;

    private Double wateringValueMax;
    private Double wateringValueMin;

    @Enumerated(EnumType.STRING)
    private WateringUnit wateringUnit;

    @Enumerated(EnumType.STRING)
    @Column(name = "leaves_color")
    @JdbcTypeCode(SqlTypes.JSON)
    private LeafColor[] leavesColor;

    @Column(nullable = false)
    private Boolean flowers;

    @Enumerated(EnumType.STRING)
    private Season flowerSeason;

    @Column(nullable = false)
    private Boolean fruits;

    @Enumerated(EnumType.STRING)
    private Season fruitingSeason;

    @Enumerated(EnumType.STRING)
    private HarvestMethodType harvestMethod;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GrowthRate growthRate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MaintenanceLevel maintenance;

    @Column(nullable = false)
    private Boolean medical;

    @Column(nullable = false)
    private Boolean poisonousToHumans;

    @Column(nullable = false)
    private Boolean poisonousToPets;

    @Column(nullable = false)
    private Boolean cuisine;

    @Column(nullable = false)
    private Boolean indoor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CareLevel careLevel;

    @ManyToMany
    @JoinTable(
            name = "plant_propagation",
            joinColumns = @JoinColumn(name = "plant_id"),
            inverseJoinColumns = @JoinColumn(name = "propagation_method_id"))
    private Set<PropagationMethod> propagationMethods;

    @ManyToMany
    @JoinTable(
            name = "plant_sunlight",
            joinColumns = @JoinColumn(name = "plant_id"),
            inverseJoinColumns = @JoinColumn(name = "sunlight_requirement_id"))
    private Set<SunlightRequirement> sunlightRequirements;
}
