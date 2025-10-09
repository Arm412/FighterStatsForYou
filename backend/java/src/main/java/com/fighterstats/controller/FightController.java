package com.fighterstats.controller;

import com.fighterstats.model.FightDetails;
import com.fighterstats.service.FightService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fights")
public class FightController {
  private final FightService fightService;

  public FightController(FightService fightService) {
    this.fightService = fightService;
  }

  @GetMapping("/all")
  public List<FightDetails> getAll() {
    return fightService.getAllFights();
  }

  @GetMapping("/{id}")
  public FightDetails getFightWithId(@PathVariable Long id) {
    return fightService.getFightById(id);
  }
}
