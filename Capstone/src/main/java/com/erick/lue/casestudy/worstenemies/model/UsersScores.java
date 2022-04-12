package com.erick.lue.casestudy.worstenemies.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="USERS_SCORES")
public class UsersScores {

    @Id
    @Column(name = "PAIRS")
    private long pairNumber;







    @Column (name = "ENEMY_SCORE")
    private int score;
}
