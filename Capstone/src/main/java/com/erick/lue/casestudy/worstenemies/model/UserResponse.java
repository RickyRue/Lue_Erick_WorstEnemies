package com.erick.lue.casestudy.worstenemies.model;

import javax.persistence.*;


@Entity
@Table(name="USER_RESPONSES")
public class UserResponse {
    @Id
    @Column(name="Id", nullable=false)
    private long id;

    @ManyToOne
    @JoinColumn(name="Question_Id", nullable=false)
    private Question question;

    @ManyToOne
    @JoinColumn(name="User_Id", nullable=false)
    private User user;



    @Column(name="CHOICE")
    private boolean choseFirst;

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

    public boolean isChoseFirst() {
        return choseFirst;
    }

    public void setChoseFirst(boolean choseFirst) {
        this.choseFirst = choseFirst;
    }
}
