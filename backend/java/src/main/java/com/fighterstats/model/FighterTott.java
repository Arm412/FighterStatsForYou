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
@Table(name = "ufc_fighter_tott")
public class FighterTott {
  @Id
  @Column(name = "fighter_id")
  private Long id;

  @Column(name = "height")
  private String height;

  @Column(name = "weight")
  private String weight;

  @Column(name = "reach")
  private String reach;

  @Column(name = "stance")
  private String stance;

  @Column(name = "birthDate")
  private String birthDateString;

  @Column(name = "url")
  private String url;
}
