package com.hajba.restTry.model.resume.lishnee;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

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

    private String about;

    private String skills;

    private String howAreU;
    private String benefits;
private boolean isRecomended;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEnglishLevel() {
        return englishLevel;
    }

    public void setEnglishLevel(String englishLevel) {
        this.englishLevel = englishLevel;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getHowAreU() {
        return howAreU;
    }

    public void setHowAreU(String howAreU) {
        this.howAreU = howAreU;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public void setRecomended(boolean recomended) {
        isRecomended = recomended;
    }

    public boolean isRecomended() {
        return isRecomended;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneralPart that = (GeneralPart) o;
        return id == that.id &&
                Objects.equals(englishLevel, that.englishLevel) &&
                Objects.equals(about, that.about) &&
                Objects.equals(skills, that.skills) &&
                Objects.equals(howAreU, that.howAreU) &&
                Objects.equals(benefits, that.benefits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, englishLevel, about, skills, howAreU, benefits);
    }
}
