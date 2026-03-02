package com.fighterstats.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fighterstats.model.FightDetails;
import com.fighterstats.model.FightResults;
import com.fighterstats.model.FightStats;
import com.fighterstats.repo.FightRepository;
import com.fighterstats.repo.FightResultsRepository;
import com.fighterstats.repo.FightStatsRepository;

@Service
public class FightService {

  @Autowired
  FightRepository fightRepository;

  @Autowired
  FightResultsRepository fightResultsRepository;

  @Autowired
  FightStatsRepository fightStatsRepository;

  public FightService(FightRepository fightRepository) {
    this.fightRepository = fightRepository;
  }

  public FightDetails getFightById(Long id) {
    return fightRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Fight not found with id " + id));
  }

  public List<FightDetails> getAllFights() {
    return fightRepository.findAll();
  }

  public List<FightResults> getAllFightResults() {
    return fightResultsRepository.findAll();
  }

  public FightResults getFightResultsWithId(Long id) {
    return fightResultsRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Fight results not found with id " + id));
  }

  public List<FightStats> getAllFightStats() {
    return fightStatsRepository.findAll();
  }

  public List<FightStats> getFightStatsByFightAndFighter(Long fightId, Long fighterId) {
    List<FightStats> results = fightStatsRepository.findByFightIdAndFighterId(fightId, fighterId);
    if (results == null || results.isEmpty()) {
      throw new RuntimeException(
          "Fight stats not found with fight id " + fightId + " and fighter id " + fighterId);
    }
    return results;
  }

  public List<FightStats> getFightStatsByFight(Long fightId) {
    List<FightStats> results = fightStatsRepository.findByFightId(fightId);
    if (results == null || results.isEmpty()) {
      throw new RuntimeException(
          "Fight stats not found with fight id " + fightId);
    }
    return results;
  }
}
