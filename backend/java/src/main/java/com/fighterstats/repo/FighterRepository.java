package com.fighterstats.repo;

import com.fighterstats.model.FighterResponse;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FighterRepository extends JpaRepository<FighterResponse, Long> {
}
