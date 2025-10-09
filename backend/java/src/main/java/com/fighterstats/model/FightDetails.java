package com.fighterstats.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@Table(name = "ufc_fight_details")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class FightDetails {

  @Id
  @Column(name = "fight_id")
  private Long id;

  @Column(name = "event_id")
  private Long eventId;

  @Column(name = "bout")
  private String bout;

  @Column(name = "url")
  private String url;

  @Column(name = "event_norm")
  private String eventNorm;

  @Column(name = "bout_norm")
  private String boutNorm;

  @Column(name = "bout_anagram")
  private String boutAnagram;
}
