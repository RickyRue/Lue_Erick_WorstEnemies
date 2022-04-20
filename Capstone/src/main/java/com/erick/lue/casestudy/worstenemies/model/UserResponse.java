package com.erick.lue.casestudy.worstenemies.model;

import javax.persistence.*;


@Entity
@Table(name="USER_RESPONSES")
public class UserResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Question question;

    @ManyToOne
    private User user;


    @Column(name = "CHOICE")
    private boolean choice;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
//true if left false if right
    public boolean isChoice() {
        return choice;
    }

    public void setChoice(boolean choice) {
        this.choice = choice;
    }

    public UserResponse() {
    }

    public UserResponse(Question question, User user, boolean choice) {
        this.question = question;
        this.user = user;
        this.choice = choice;
    }
}
