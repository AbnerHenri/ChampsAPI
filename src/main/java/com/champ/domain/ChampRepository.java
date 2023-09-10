package com.champ.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ChampRepository extends CrudRepository<Champ, Long> {

    List<Champ> findByRole(String role);
    
}
