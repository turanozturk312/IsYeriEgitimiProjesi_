package com.isyeri.modules.survey.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "anket_sorular")
@Getter
@Setter
public class Soru {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "question_number")
    private int questionNumber;
    private String soru;
    private String tip;

    @ManyToOne
    @JoinColumn(name = "anket_id")
    private Anket anket;

    private String secenekler;

}
