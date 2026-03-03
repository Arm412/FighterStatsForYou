package com.fighterstats.controller;

import com.fighterstats.model.FightDetails;
import com.fighterstats.model.FightResults;
import com.fighterstats.model.FightStats;
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

  @GetMapping("/results/all")
  public List<FightResults> getAllFightResults() {
    return fightService.getAllFightResults();
  }

  @GetMapping("/results/all/{id}")
  public FightResults getFightResultsWithId(@PathVariable Long id) {
    return fightService.getFightResultsWithId(id);
  }

  @GetMapping("/stats/all/")
  public List<FightStats> getAllFightStats() {
    return fightService.getAllFightStats();
  }

  @GetMapping("/stats/{fightId}/{fighterId}")
  public List<FightStats> getFightStatsWithId(@PathVariable Long fightId, @PathVariable Long fighterId) {
    return fightService.getFightStatsByFightAndFighter(fightId, fighterId);
  }

  @GetMapping("/stats/{fightId}")
  public List<FightStats> getFightStatsWithId(@PathVariable Long fightId) {
    return fightService.getFightStatsByFight(fightId);
  }
}
