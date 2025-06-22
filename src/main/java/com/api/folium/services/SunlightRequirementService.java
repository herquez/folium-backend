package com.api.folium.services;

import com.api.folium.entities.SunlightRequirement;

public interface SunlightRequirementService {
    Iterable<SunlightRequirement> findAll();

    SunlightRequirement findById(Long id);

    SunlightRequirement save(SunlightRequirement sunlightRequirement);

    boolean deleteById(Long id);
}
