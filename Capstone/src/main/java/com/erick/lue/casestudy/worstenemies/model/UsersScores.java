package com.erick.lue.casestudy.worstenemies.model;

import javax.persistence.*;

@Entity
@Table(name="USER_SCORES")
public class UsersScores {

    @Id
    @Column(name = "PAIRS")
    private long pairNumber;





    @Column (name = "ENEMY_SCORE")
    private int score;
}
