package com.hajba.restTry.model.resume;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "HrPart")
@Setter
@Getter
public class HrPart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String tellAboutYou;
    @Column
    private String youDestenation;
    @Column
    private String experience;

}
