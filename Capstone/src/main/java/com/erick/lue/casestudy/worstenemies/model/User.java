package com.erick.lue.casestudy.worstenemies.model;


import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="USERS",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
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
        @OneToMany(mappedBy = "user")
        private Set<UserResponse> userResponses = new HashSet<>();

        @ManyToMany
        @JoinTable(name="Users_Scores",
        joinColumns = @JoinColumn(name = "user1_id"),
        inverseJoinColumns = @JoinColumn(name="user2_id") )
        private List<User> comparisons;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    public User() {
    }

    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public User(String userName, String email, String password, Collection<Role> roles) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public long getId() {return id;}

    public String getUserName() {return userName;}

    public String getEmail() {return email;}

    public String getPassword() {return password;}

    public void setId(long id) {this.id = id;}

    public void setUserName(String userName) {this.userName = userName;}

    public void setEmail(String email) {this.email = email;}

    public void setPassword(String password) {this.password = password;}

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
