package com.fighterstats.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fighterstats.model.EventDetails;
import com.fighterstats.repo.EventRepository;

@Service
public class EventService {

  @Autowired
  EventRepository eventRepository;

  public EventService(EventRepository eventRepository) {
    this.eventRepository = eventRepository;
  }

  public EventDetails getEventById(Long id) {
    return eventRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Event not found with id " + id));
  }

  public List<EventDetails> getAllEvents() {
    return eventRepository.findAll();
  }
}
