package com.champ.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.champ.domain.Champ;
import com.champ.domain.ChampService;

@RestController
@RequestMapping("/")
public class indexController {
    
    @Autowired
    private ChampService service;

    @GetMapping
    public Iterable<Champ> showChamps(){
        return service.getChamps();
    }
}
