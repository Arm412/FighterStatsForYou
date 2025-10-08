package com.fighterstats.repo;

import com.fighterstats.model.FighterDetails;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FighterRepository extends JpaRepository<FighterDetails, Long> {
}
