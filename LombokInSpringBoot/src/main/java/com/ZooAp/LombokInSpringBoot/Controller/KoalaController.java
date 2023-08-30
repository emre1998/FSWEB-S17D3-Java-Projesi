package com.ZooAp.LombokInSpringBoot.Controller;

import com.ZooAp.LombokInSpringBoot.Entity.Gender;
import com.ZooAp.LombokInSpringBoot.Entity.Koala;
import com.ZooAp.LombokInSpringBoot.Exception.AnimalValidator;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("koalas")
public class KoalaController {
    private Map<Integer,Koala> koalas;

    @PostConstruct
    public void init() {
        koalas = new HashMap<>();
        koalas.put(1,new Koala(1,"Koala1",9,Gender.FEMALE,21));
    }
     @GetMapping("/")
    public List<Koala> getAll() {
        return koalas.values().stream().toList();
     }

     @GetMapping("/{id}")
    public Koala get(@PathVariable int id) {
        AnimalValidator.IsValid(id);
        return koalas.get(id);
     }
     @PostMapping("/")
    public Koala save(@RequestBody Koala koala) {
        AnimalValidator.IsValid(koala.getId());
        AnimalValidator.IsAnimalValid(koala);
        AnimalValidator.IsKoalaValid(koala);
        koalas.put(koala.getId(),koala);
        return koalas.get(koala.getId());
     }

     @PutMapping("/{id}")
    public Koala update(@PathVariable int id, @RequestBody Koala koala) {
        AnimalValidator.IsValid(koala.getId());
        AnimalValidator.IsAnimalValid(koala);
        AnimalValidator.IsKoalaValid(koala);
        koala.setId(id);
        koalas.put(id,koala);
        return koalas.get(id);
     }

     @DeleteMapping("/{id}")
    public Koala delete(@PathVariable int id) {
        AnimalValidator.IsValid(id);
        Koala koala = koalas.get(id);
        koalas.remove(id);
        return koala;
     }
}
