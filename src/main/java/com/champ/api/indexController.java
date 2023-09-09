package com.champ.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/champ/{id}")
    public Optional<Champ> showChamp(@PathVariable Long id){
        return service.getChampById(id);
    }

    @PostMapping
    public String addChamp(@RequestBody Champ champ){
        service.addChamp(champ);
        return "Campeão Adicionado";
    }

    @PutMapping("/champ/{id}")
    public String editChamp(@RequestBody Champ champ, @PathVariable Long id){
        service.updateChamp(champ, id);
        return "Champ Editado";
    }

    @DeleteMapping("/champ/{id}")
    public String deleteChamp(@PathVariable Long id){
        service.deleteChamp(id);
        return "Champ Deletado";
    }
}
