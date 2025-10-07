package com.fighterstats.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ufc_fighter_details")
public class FighterResponse {
  @Id
  @Column(name = "fighter_id")
  private Long id;

  @Column(name = "first")
  private String first;

  @Column(name = "last")
  private String last;

  @Column(name = "nickname")
  private String nickname;

  @Column(name = "url")
  private String url;
}
