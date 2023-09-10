package com.champ.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Iterable<Champ>> showChamps(){
        return ResponseEntity.ok(service.getChamps());
    }

    @GetMapping("/champ/{id}")
    public ResponseEntity<Champ> showChamp(@PathVariable Long id){
        Optional<Champ> champ = service.getChampById(id);
        return champ
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<List<Champ>> showRoles(@PathVariable String role){
        List<Champ> champ = service.getChampByRole(role);
        return champ.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(champ);
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<Champ>> showTypes(@PathVariable String type){
        List<Champ> champ = service.getChampByType(type);
        return champ.isEmpty() ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(champ);
    }

    @PostMapping
    public ResponseEntity<String> addChamp(@RequestBody Champ champ){
        service.addChamp(champ);
        return ResponseEntity.ok("Campeão Adicionado");
    }

    @PutMapping("/champ/{id}")
    public ResponseEntity<String> editChamp(@RequestBody Champ champ, @PathVariable Long id){
        service.updateChamp(champ, id);
        return ResponseEntity.ok("Champ Editado");
    }

    @DeleteMapping("/champ/{id}")
    public ResponseEntity<String> deleteChamp(@PathVariable Long id){
        service.deleteChamp(id);
        return ResponseEntity.ok("Champ Deletado");
    }
}
