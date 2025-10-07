package com.fighterstats.controller;

import com.fighterstats.model.FighterResponse;
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

    @GetMapping("/all")
    public List<FighterResponse> getAll() {
        return fighterService.getAllFighters();
    }
}
