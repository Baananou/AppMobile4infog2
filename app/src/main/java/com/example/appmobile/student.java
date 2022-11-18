package com.example.appmobile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class student {
    private String nom,prenom,age;
    private long tel;

    public student(String nom, String prenom, String age, long tel) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "student{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age='" + age + '\'' +
                ", tel=" + tel +
                '}';
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public long getTel() {
        return tel;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_service, container, false);
    }

}
