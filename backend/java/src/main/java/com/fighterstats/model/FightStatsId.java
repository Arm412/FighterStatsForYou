package com.fighterstats.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class FightStatsId implements Serializable {

  @Column(name = "fight_id")
  private Long fightId;

  @Column(name = "fighter_id")
  private Long fighterId;
}
