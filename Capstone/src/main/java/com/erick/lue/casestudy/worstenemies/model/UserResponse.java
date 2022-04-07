package com.erick.lue.casestudy.worstenemies.model;

import javax.persistence.*;


@Entity
@Table(name="USER_RESPONSES")
public class UserResponse {
    @Id
    @Column(name="Id", nullable=false)
    private long id;

    @ManyToOne(targetEntity = Question.class, fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private Question question = new Question();

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private User user = new User();

    @Column(name="CHOICE")
    private boolean choseFirst;
}
