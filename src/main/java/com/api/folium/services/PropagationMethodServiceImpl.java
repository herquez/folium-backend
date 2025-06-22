package com.api.folium.services;

import com.api.folium.entities.PropagationMethod;
import com.api.folium.repositories.PropagationMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.NoSuchElementException;

public class PropagationMethodServiceImpl implements PropagationMethodService {
    PropagationMethodRepository propagationMethodRepository;

    @Autowired
    public PropagationMethodServiceImpl(PropagationMethodRepository propagationMethodRepository) {
        this.propagationMethodRepository = propagationMethodRepository;
    }

    @Override
    public Iterable<PropagationMethod> findAll() {
        return propagationMethodRepository.findAll();
    }

    @Override
    public PropagationMethod findById(Long id) {
        return propagationMethodRepository.findById(id).orElseThrow();
    }

    @Override
    public PropagationMethod save(PropagationMethod propagationMethod) {
        return propagationMethodRepository.save(propagationMethod);
    }

    @Override
    public boolean deleteById(Long id) {
        if(propagationMethodRepository.existsById(id)) {
            propagationMethodRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("No value present");
        }
        return !propagationMethodRepository.existsById(id);
    }
}
