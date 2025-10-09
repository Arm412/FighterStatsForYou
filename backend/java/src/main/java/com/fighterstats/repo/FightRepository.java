package com.fighterstats.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fighterstats.model.FightDetails;

public interface FightRepository extends JpaRepository<FightDetails, Long> {
}
