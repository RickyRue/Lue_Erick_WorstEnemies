package com.erick.lue.casestudy.worstenemies.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name="EMAIL")
    private String email;

    @Column(name="PASSWORD")
    private String password;

//    @OneToMany(targetEntity = UserResponse.class, fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
//    private List<UserResponse> userResponses = new ArrayList<>();
        @OneToMany(mappedBy = "id")
        private Set<UserResponse> userResponses = new HashSet<>();

        @ManyToMany
        @JoinTable(name="Users_Scores",
        joinColumns = @JoinColumn(name = "user1_id"),
        inverseJoinColumns = @JoinColumn(name="user2_id") )
        private List<User> comparisons;







    public long getId() {return id;}

    public String getUserName() {return userName;}

    public String getEmail() {return email;}

    public String getPassword() {return password;}

    public void setId(long id) {this.id = id;}

    public void setUserName(String userName) {this.userName = userName;}

    public void setEmail(String email) {this.email = email;}

    public void setPassword(String password) {this.password = password;}

}
