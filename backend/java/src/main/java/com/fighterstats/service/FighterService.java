package com.fighterstats.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fighterstats.model.FighterDetails;
import com.fighterstats.repo.FighterRepository;

@Service
public class FighterService {

  @Autowired
  FighterRepository fighterRepository;

  public FighterService(FighterRepository fighterRepository) {
    this.fighterRepository = fighterRepository;
  }

  public FighterDetails getFighterById(Long id) {
    return fighterRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Fighter not found with id " + id));
  }

  public List<FighterDetails> getAllFighters() {
    return fighterRepository.findAll();
  }
}
