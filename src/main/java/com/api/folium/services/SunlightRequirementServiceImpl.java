package com.api.folium.services;

import com.api.folium.entities.SunlightRequirement;
import com.api.folium.repositories.SunlightRequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Transactional
public class SunlightRequirementServiceImpl implements SunlightRequirementService{
    private final SunlightRequirementRepository sunlightRequirementRepository;

    @Autowired
    public SunlightRequirementServiceImpl(SunlightRequirementRepository sunlightRequirementRepository) {
        this.sunlightRequirementRepository = sunlightRequirementRepository;
    }

    @Override
    public Iterable<SunlightRequirement> findAll() {
        return sunlightRequirementRepository.findAll();
    }

    @Override
    public SunlightRequirement findById(Long id) {
        return sunlightRequirementRepository.findById(id).orElseThrow();
    }

    @Override
    public SunlightRequirement save(SunlightRequirement sunlightRequirement) {
        return sunlightRequirementRepository.save(sunlightRequirement);
    }

    @Override
    public boolean deleteById(Long id) {
        if(sunlightRequirementRepository.existsById(id)) {
            sunlightRequirementRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("No value present");
        }
        return !sunlightRequirementRepository.existsById(id);
    }
}
