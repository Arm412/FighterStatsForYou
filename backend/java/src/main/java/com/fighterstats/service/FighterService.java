package com.fighterstats.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fighterstats.model.FighterDetails;
import com.fighterstats.model.FighterTott;
import com.fighterstats.repo.FighterRepository;
import com.fighterstats.repo.FighterTOTTRepository;

@Service
public class FighterService {

  @Autowired
  FighterRepository fighterRepository;

  @Autowired
  FighterTOTTRepository fighterTOTTRepository;

  public FighterService(FighterRepository fighterRepository, FighterTOTTRepository fighterTOTTRepository) {
    this.fighterRepository = fighterRepository;
    this.fighterTOTTRepository = fighterTOTTRepository;
  }

  public FighterDetails getFighterById(Long id) {
    return fighterRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Fighter not found with id " + id));
  }

  public List<FighterDetails> getAllFighters() {
    return fighterRepository.findAll();
  }

  public List<FighterDetails> findFighterWithString(String name) {
    return fighterRepository.findByString(name);
  }

  public FighterTott getFighterTOTTById(Long id) {
    return fighterTOTTRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Fighter Tale Of The Tape not found with id " + id));
  }

  public List<FighterTott> getAllTalesOfTheTape() {
    return fighterTOTTRepository.findAll();
  }
}
