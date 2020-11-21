package com.example.festival.database;

import com.orm.SugarRecord;

public class Groupe extends SugarRecord {

    String nom;
    String photo;
    String jour;
    String scene;
    String horaire;
    String description;
    String siteWeb;
    boolean estFavori;

    public Groupe(){}

    public Groupe(String nom, String photo, String jour, String scene, String horaire, String description, String siteWeb, boolean estFavori){
        this.nom = nom;
        this.photo = photo;
        this.jour = jour;
        this.scene = scene;
        this.horaire = horaire;
        this.description = description;
        this.siteWeb = siteWeb;
        this.estFavori = estFavori;
    }

    public String getNom() {
        return nom;
    }

    public String getPhoto() {
        return photo;
    }

    public String getJour() {
        return jour;
    }

    public String getScene() {
        return scene;
    }

    public String getHoraire() {
        return horaire;
    }

    public String getDescription() {
        return description;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public boolean estFavori() {
        return estFavori;
    }
}
