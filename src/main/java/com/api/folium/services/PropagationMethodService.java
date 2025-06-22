package com.api.folium.services;

import com.api.folium.entities.PropagationMethod;

public interface PropagationMethodService {
    Iterable<PropagationMethod> findAll();

    PropagationMethod findById(Long id);

    PropagationMethod save(PropagationMethod propagationMethod);

    boolean deleteById(Long id);
}
