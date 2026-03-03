package com.fighterstats.repo;

import com.fighterstats.model.FightResults;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FightResultsRepository extends JpaRepository<FightResults, Long> {

}
