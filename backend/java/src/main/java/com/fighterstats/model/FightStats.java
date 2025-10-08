package com.fighterstats.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ufc_fight_stats")
public class FightStats {

  @EmbeddedId
  private FightStatsId id;

  @Column(name = "round")
  private String round;

  @Column(name = "kd")
  private Long kd;

  @Column(name = "sig_str_pct")
  private String sigStrPct;

  @Column(name = "td_pct")
  private String tdPct;

  @Column(name = "sub_att")
  private Long subAtt;

  @Column(name = "rev")
  private Long reversals;

  @Column(name = "ctrl")
  private String ctrl;

  @Column(name = "sig_str_landed")
  private Long sigStrLanded;

  @Column(name = "sig_str_attempted")
  private Long sigStrAttempted;

  @Column(name = "total_str_landed")
  private Long totalStrLanded;

  @Column(name = "total_str_attempted")
  private Long totalStrAttempted;

  @Column(name = "td_landed")
  private Long tdLanded;

  @Column(name = "td_attempted")
  private Long tdAttempted;

  @Column(name = "head_landed")
  private Long headLanded;

  @Column(name = "head_attempted")
  private Long headAttempted;

  @Column(name = "body_landed")
  private Long bodyLanded;

  @Column(name = "body_attempted")
  private Long bodyAttempted;

  @Column(name = "leg_landed")
  private Long legLanded;

  @Column(name = "leg_attempted")
  private Long legAttempted;

  @Column(name = "distance_landed")
  private Long distanceLanded;

  @Column(name = "distance_attempted")
  private Long distanceAttempted;

  @Column(name = "clinch_landed")
  private Long clinchLanded;

  @Column(name = "clinch_attempted")
  private Long clinchAttempted;

  @Column(name = "ground_landed")
  private Long groundLanded;

  @Column(name = "ground_attempted")
  private Long groundAttempted;
}
