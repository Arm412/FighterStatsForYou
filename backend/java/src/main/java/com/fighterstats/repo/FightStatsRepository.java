package com.fighterstats.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fighterstats.model.FightStats;
import com.fighterstats.model.FightStatsId;

public interface FightStatsRepository extends JpaRepository<FightStats, FightStatsId> {

  @Query("SELECT f FROM FightStats f WHERE f.id.fightId = :fightId AND f.id.fighterId = :fighterId")
  List<FightStats> findByFightIdAndFighterId(@Param("fightId") Long fightId,
      @Param("fighterId") Long fighterId);

  @Query("SELECT f FROM FightStats f WHERE f.id.fightId = :fightId")
  List<FightStats> findByFightId(@Param("fightId") Long fightId);
}
