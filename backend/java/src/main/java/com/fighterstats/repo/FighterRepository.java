package com.fighterstats.repo;

import com.fighterstats.model.Fighter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FighterRepository extends JpaRepository<Fighter, Long> {
}
