package com.champ.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChampService {
    
    @Autowired
    private ChampRepository repository;

    public Iterable<Champ> getChamps(){
        return repository.findAll();
    }
}
