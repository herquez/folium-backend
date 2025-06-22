package com.api.folium.services;

import com.api.folium.entities.Plant;
import com.api.folium.repositories.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Transactional
public class PlantServiceImpl implements PlantService{
    private final PlantRepository plantRepository;

    @Autowired
    public PlantServiceImpl(PlantRepository plantRepository){
        this.plantRepository = plantRepository;
    }

    @Override
    public Iterable<Plant> findAll() {
        return plantRepository.findAll();
    }

    @Override
    public Plant findById(Long id) {
        return plantRepository.findById(id).orElseThrow();
    }

    @Override
    public Plant save(Plant plant) {
        return plantRepository.save(plant);
    }

    @Override
    public boolean deleteById(Long id) {
        if(plantRepository.existsById(id)) {
            plantRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("No value present");
        }
        return !plantRepository.existsById(id);
    }
}
