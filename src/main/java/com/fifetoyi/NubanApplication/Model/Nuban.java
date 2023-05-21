package com.fifetoyi.NubanApplication.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "nuban")
public class Nuban {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bankCode;
    private int serial;
    private String nuban;

    public Nuban(Long id, String bankCode, int serial, String nuban) {
        this.id = id;
        this.bankCode = bankCode;
        this.serial = serial;
        this.nuban = nuban;
    }

    public Nuban() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public String getNuban() {
        return nuban;
    }

    public void setNuban(String nuban) {
        this.nuban = nuban;
    }
}
