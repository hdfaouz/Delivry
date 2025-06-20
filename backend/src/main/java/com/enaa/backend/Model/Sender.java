package com.enaa.backend.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Sender extends User{

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Demande> request = new ArrayList<>();

    public List<Demande> getRequest() {
        return request;
    }

    public void setRequest(List<Demande> request) {
        this.request = request;
    }
}
