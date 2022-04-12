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
}
