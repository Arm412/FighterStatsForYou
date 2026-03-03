package com.fighterstats.repo;

import com.fighterstats.model.EventDetails;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventDetails, Long> {
}
