package com.ZooAp.LombokInSpringBoot.Controller;

import com.ZooAp.LombokInSpringBoot.Entity.Gender;
import com.ZooAp.LombokInSpringBoot.Entity.Kangaroo;
import com.ZooAp.LombokInSpringBoot.Exception.AnimalValidator;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kangaroos")
public class KangarooController {
    private Map<Integer,Kangaroo> kangaroos;

    @PostConstruct
    public void init() {
        kangaroos = new HashMap<>();
        kangaroos.put(1,new Kangaroo(1,"Kangaroo1",35,Gender.MALE,1.5,true));
    }

    @GetMapping("/")
    public List<Kangaroo> getAll() {
    return kangaroos.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Kangaroo get(@PathVariable int id) {
        AnimalValidator.IsValid(id);
        return kangaroos.get(id);
    }
    @PostMapping("/")
    public Kangaroo save(@RequestBody Kangaroo kangaroo) {
        AnimalValidator.IsValid(kangaroo.getId());
        AnimalValidator.IsAnimalValid(kangaroo);
        AnimalValidator.IsKangarooValid(kangaroo);
        kangaroos.put(kangaroo.getId(), kangaroo);
        return kangaroos.get(kangaroo.getId());
    }

    @PutMapping("/{id}")
    public Kangaroo update(@PathVariable int id,@RequestBody Kangaroo kangaroo) {
        AnimalValidator.IsValid(kangaroo.getId());
        AnimalValidator.IsAnimalValid(kangaroo);
        AnimalValidator.IsKangarooValid(kangaroo);
        kangaroo.setId(id);
        kangaroos.put(id,kangaroo);
        return kangaroos.get(id);
    }

    @DeleteMapping("/{id}")
    public Kangaroo delete(@PathVariable int id) {
        AnimalValidator.IsValid(id);
        Kangaroo kangaroo = kangaroos.get(id);
        kangaroos.remove(id);
        return kangaroo;
    }
}
