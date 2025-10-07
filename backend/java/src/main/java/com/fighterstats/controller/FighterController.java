package com.fighterstats.controller;

import com.fighterstats.model.Fighter;
import com.fighterstats.repo.FighterRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fighters")
public class FighterController {
    private final FighterRepository repo;

    public FighterController(FighterRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Fighter> list() { return repo.findAll(); }

    @PostMapping
    public Fighter create(@RequestBody Fighter f) { return repo.save(f); }

    @GetMapping("/{id}")
    public ResponseEntity<Fighter> get(@PathVariable Long id) {
        return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
