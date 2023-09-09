package com.champ.domain;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class ChampService {
    
    @Autowired
    private ChampRepository repository;

    public Iterable<Champ> getChamps(){
        return repository.findAll();
    }

    public Optional<Champ> getChampById(Long id){
        return repository.findById(id);
    }

    public Champ addChamp(Champ champ){
        Assert.isNull(champ.getId(), "Registro não encontrado");
        return repository.save(champ);
    }
}
