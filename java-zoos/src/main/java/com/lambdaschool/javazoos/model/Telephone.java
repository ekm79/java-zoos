package com.lambdaschool.javazoos.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Telephone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long phoneid;

    private String phonetype;
    private String phonenumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "zooid")
    @JsonIgnoreProperties("telephones")
    private Zoo zooid;

    public Telephone() {
    }

    public long getPhoneid() {
        return phoneid;
    }

    public void setPhoneid(long phoneid) {
        this.phoneid = phoneid;
    }

    public String getPhonetype() {
        return phonetype;
    }

    public void setPhonetype(String phonetype) {
        this.phonetype = phonetype;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Zoo getZooid() {
        return zooid;
    }

    public void setZooid(Zoo zooid) {
        this.zooid = zooid;
    }
}
