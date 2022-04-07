package com.erick.lue.casestudy.worstenemies.model;

import javax.persistence.*;

@Entity
@Table(name="QUESTIONS")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "QUESTION_TEXT")
    private String question_text;

    @Column(name = "FIRST_TEXT")
    private String first_text;

    @Column(name = "FIRST_SVG")
    private String first_svg;


    @Column(name = "SECOND_TEXT")
    private String second_text;

    @Column(name = "SECOND_SVG")
    private String second_svg;
}
