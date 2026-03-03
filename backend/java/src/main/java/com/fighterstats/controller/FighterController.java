package com.fighterstats.controller;

import com.fighterstats.model.FighterDetails;
import com.fighterstats.model.FighterTott;
import com.fighterstats.service.FighterService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fighters")
public class FighterController {
    private final FighterService fighterService;

    public FighterController(FighterService fighterService) {
        this.fighterService = fighterService;
    }

    // Fighter Details Endpoints

    @GetMapping("/all")
    public List<FighterDetails> getAll() {
        return fighterService.getAllFighters();
    }

    @GetMapping("/search")
    public List<FighterDetails> getFightersByName(@RequestParam String name) {
        return fighterService.findFighterWithString(name.toLowerCase());
    }

    @GetMapping("/{id}")
    public FighterDetails getFighterWithId(@PathVariable Long id) {
        return fighterService.getFighterById(id);
    }

    // Fighter Tale Of The Tape Endpoints

    @GetMapping("/tott/all")
    public List<FighterTott> getAllTalesOfTheTape() {
        return fighterService.getAllTalesOfTheTape();
    }

    @GetMapping("/tott/{id}")
    public FighterTott getFighterTOTTWithId(@PathVariable Long id) {
        return fighterService.getFighterTOTTById(id);
    }
}
