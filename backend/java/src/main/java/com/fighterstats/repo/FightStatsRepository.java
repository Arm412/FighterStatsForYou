package com.fighterstats.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fighterstats.model.FightStats;
import com.fighterstats.model.FightStatsId;

public interface FightStatsRepository extends JpaRepository<FightStats, FightStatsId> {

}
