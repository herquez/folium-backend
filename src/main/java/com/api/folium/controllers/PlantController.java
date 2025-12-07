
package com.api.folium.controllers;

import com.api.folium.DTO.PlantDTO;
import com.api.folium.entities.Plant;
import com.api.folium.mappers.PlantMapper;
import com.api.folium.services.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/plants")
@CrossOrigin(origins = "*")
public class PlantController {

    private final PlantService plantService;
    private final PlantMapper plantMapper;

    @Autowired
    public PlantController(PlantService plantService, PlantMapper plantMapper) {
        this.plantService = plantService;
        this.plantMapper = plantMapper;
    }

    @GetMapping
    public ResponseEntity<List<PlantDTO>> getAllPlants() {
        Iterable<Plant> plants = plantService.findAll();
        List<PlantDTO> plantDTOs = StreamSupport.stream(plants.spliterator(), false)
                .map(plantMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(plantDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlantDTO> getPlantById(@PathVariable Long id) {
        try {
            Plant plant = plantService.findById(id);
            return ResponseEntity.ok(plantMapper.toDTO(plant));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<PlantDTO> createPlant(@RequestBody PlantDTO plantDTO) {
        try {
            Plant plant = plantMapper.toEntity(plantDTO);
            Plant savedPlant = plantService.save(plant);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(plantMapper.toDTO(savedPlant));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlantDTO> updatePlant(
            @PathVariable Long id,
            @RequestBody PlantDTO plantDTO) {
        try {
            Plant existingPlant = plantService.findById(id);
            Plant plantToUpdate = plantMapper.toEntity(plantDTO);
            plantToUpdate.setId(id);
            Plant updatedPlant = plantService.save(plantToUpdate);
            return ResponseEntity.ok(plantMapper.toDTO(updatedPlant));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlant(@PathVariable Long id) {
        try {
            boolean deleted = plantService.deleteById(id);
            if (deleted) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.notFound().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}