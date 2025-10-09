package com.fighterstats.controller;

import com.fighterstats.model.EventDetails;
import com.fighterstats.service.EventService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {
  private final EventService eventService;

  public EventController(EventService eventService) {
    this.eventService = eventService;
  }

  @GetMapping("/all")
  public List<EventDetails> getAll() {
    return eventService.getAllEvents();
  }

  @GetMapping("/{id}")
  public EventDetails getEventWithId(@PathVariable Long id) {
    return eventService.getEventById(id);
  }
}
