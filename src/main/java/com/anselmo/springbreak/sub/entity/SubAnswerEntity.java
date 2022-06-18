package com.anselmo.springbreak.sub.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class SubAnswerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String context;

    private LocalDateTime createDate;

    @ManyToOne
    private SubQuestionEntity question;
}
