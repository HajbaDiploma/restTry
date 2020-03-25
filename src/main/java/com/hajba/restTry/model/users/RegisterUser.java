package com.hajba.restTry.model.users;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "RegisterUser")
public class RegisterUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;
    @Column
    private String sName;
    @Column
    private String fName;

    @Column
    private String phoneNumber; //TODO number
    @Column
    private String skypeLogin;
    @Column
    private String otherSocialNet;

    public RegisterUser(String name, String sName, String fName, String phoneNumber, String skypeLogin, String otherSocialNet) {
        this.name = name;
        this.sName = sName;
        this.fName = fName;
        this.phoneNumber = phoneNumber;
        this.skypeLogin = skypeLogin;
        this.otherSocialNet = otherSocialNet;
    }

    public RegisterUser() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSkypeLogin() {
        return skypeLogin;
    }

    public void setSkypeLogin(String skypeLogin) {
        this.skypeLogin = skypeLogin;
    }

    public String getOtherSocialNet() {
        return otherSocialNet;
    }

    public void setOtherSocialNet(String otherSocialNet) {
        this.otherSocialNet = otherSocialNet;
    }
}
