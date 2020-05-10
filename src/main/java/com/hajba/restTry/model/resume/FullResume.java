package com.hajba.restTry.model.resume;

import com.hajba.restTry.model.users.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "FullResume")
@Setter
@Getter
@EqualsAndHashCode
public class FullResume {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private User author;

    @Column
    private String name;
    @Column
    private String sName;
    @Column
    private String fName;
    @Column
    private String phone;
    @Column
    private String skype;
    @Column
    private String univercity;
    @Column
    private boolean graduated;
    @Column
    private int course;


    @Column
    private String javaCnowlage;
    @Column
    private String otherLanguageCnowlage;
    @Column
    private String sqlCnowlage;
    @Column
    private String otherLanguage;
    @Column
    private String devExpirience;


    @Column
    private String yourFailures;
    @Column
    private String aboutYourself;
    @Column
    private String yourSuccess;
    @Column
    private String yourActivity;
    @Column
    private String yourHobby;
    @Column
    private String aditionalInfo;
    @Column
    private String tellAboutYou;
    @Column
    private String experience;
}
