package com.erick.lue.casestudy.worstenemies.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="QUESTIONS")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "id")
    private Set<UserResponse> userResponses = new HashSet<>();




    @Column(name = "FIRST_TEXT")
    private String first_text;

    @Column(name = "FIRST_SVG")
    private String first_svg;


    @Column(name = "SECOND_TEXT")
    private String second_text;

    @Column(name = "SECOND_SVG")
    private String second_svg;

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getFirst_text() {return first_text;}

    public void setFirst_text(String first_text) {this.first_text = first_text;}

    public String getFirst_svg() {return first_svg;}

    public void setFirst_svg(String first_svg) {this.first_svg = first_svg;}

    public String getSecond_text() {return second_text;}

    public void setSecond_text(String second_text) {this.second_text = second_text;}

    public String getSecond_svg() {return second_svg;}

    public void setSecond_svg(String second_svg) {this.second_svg = second_svg;}



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return id == question.id && Objects.equals(first_text, question.first_text) && Objects.equals(first_svg, question.first_svg) && Objects.equals(second_text, question.second_text) && Objects.equals(second_svg, question.second_svg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first_text, first_svg, second_text, second_svg);
    }
}
