package com.hajba.restTry.model.resume;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "GeneralPart")
@Setter
@Getter
public class GeneralPart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String englishLevel;
}
