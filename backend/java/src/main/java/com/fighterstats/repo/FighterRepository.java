package com.fighterstats.repo;

import com.fighterstats.model.FighterDetails;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FighterRepository extends JpaRepository<FighterDetails, Long> {
  @Query("SELECT f FROM FighterDetails f WHERE LOWER(f.first) LIKE CONCAT('%', :name, '%') OR LOWER(f.nickname) LIKE CONCAT('%', :name, '%') OR LOWER(f.last) LIKE CONCAT('%', :name, '%')")
  List<FighterDetails> findByString(@Param("name") String name);
}
