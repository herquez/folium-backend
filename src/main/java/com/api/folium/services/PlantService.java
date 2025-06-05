package com.api.folium.services;

import com.api.folium.entities.Plant;

public interface PlantService {
    Iterable<Plant> findAll();

    Plant findById(Long id);

    Plant save(Plant plant);

    boolean deleteById(Long id);
}
