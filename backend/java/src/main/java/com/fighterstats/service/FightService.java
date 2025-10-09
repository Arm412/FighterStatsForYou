package com.fighterstats.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fighterstats.model.FightDetails;
import com.fighterstats.repo.FightRepository;

@Service
public class FightService {

  @Autowired
  FightRepository fightRepository;

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
}
