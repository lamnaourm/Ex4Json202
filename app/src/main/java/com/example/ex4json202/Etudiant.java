package com.example.ex4json202;

import java.io.Serializable;

public class Etudiant implements Serializable {

    private String ident;
    private String nom;
    private String ville;
    private String dateNaissance;
    private double noteFR;
    private double noteHist;
    private double noteMath;
    private double notePhys;

    public Etudiant() {
    }

    public Etudiant(String ident, String nom, String ville, String dateNaissance, double noteFR, double noteHist, double noteMath, double notePhys) {
        this.ident = ident;
        this.nom = nom;
        this.ville = ville;
        this.dateNaissance = dateNaissance;
        this.noteFR = noteFR;
        this.noteHist = noteHist;
        this.noteMath = noteMath;
        this.notePhys = notePhys;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public double getNoteFR() {
        return noteFR;
    }

    public void setNoteFR(double noteFR) {
        this.noteFR = noteFR;
    }

    public double getNoteHist() {
        return noteHist;
    }

    public void setNoteHist(double noteHist) {
        this.noteHist = noteHist;
    }

    public double getNoteMath() {
        return noteMath;
    }

    public void setNoteMath(double noteMath) {
        this.noteMath = noteMath;
    }

    public double getNotePhys() {
        return notePhys;
    }

    public void setNotePhys(double notePhys) {
        this.notePhys = notePhys;
    }
}
