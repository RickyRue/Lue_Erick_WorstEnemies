package com.erick.lue.casestudy.worstenemies.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="USERS_SCORES")
public class UsersScores {

    @Id
    @Column(name = "PAIRS")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long pairNumber;

    @ManyToOne
    private User user1;

    @ManyToOne
    private User user2;




    @Column (name = "ENEMY_SCORE")
    private int score;

    public long getPairNumber() {
        return pairNumber;
    }

    public void setPairNumber(long pairNumber) {
        this.pairNumber = pairNumber;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public UsersScores() {
    }

    public UsersScores(User user1, User user2, int score) {
        this.user1 = user1;
        this.user2 = user2;
        this.score = score;
    }
}
