package com.hajba.restTry.model.resume.lishnee;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "DevPart")
@Setter
@Getter
public class DevPart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String javaCnowlage;
    @Column
    private String sqlCnowlage;
    @Column
    private String otherLanguage;
}
