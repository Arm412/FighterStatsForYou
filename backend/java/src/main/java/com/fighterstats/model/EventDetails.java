package com.fighterstats.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ufc_event_details")
public class EventDetails {
  @Column(name = "event")
  private String eventString;

  @Column(name = "url")
  private String url;

  @Column(name = "date")
  private String date;

  @Column(name = "location")
  private String location;

  @Id
  @Column(name = "event_id")
  private Long eventId;

  @Column(name = "event_norm")
  private String boutNorm;
}
