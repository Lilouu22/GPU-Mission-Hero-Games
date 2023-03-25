//Nom : Lisa Pamela Valente
//Matricule : 20180163
// TP1 : Création d'un jeu de la Guilde des programmeurs unis
//Date : 3 mars 2023

package ca.udem.ift1025.tp1.corrige;

public abstract class Hero {
    private String nom;
    private int categorie;
    private double pointDeVie;
    private double maxPointDeVie;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCategorie() {
        return categorie;
    }

    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }

    public double getPointDeVie() {
        return pointDeVie;
    }

    public void setPointDeVie(double pointDeVie) {
        this.pointDeVie = pointDeVie;
    }

    public abstract double getMaxPointDeVie();
    public abstract void setMaxPointDeVie(double pointDeVie);

    public abstract void retraitPointDeVie(double pointDeVie);
    public abstract void ajoutPointDeVie(double gainDeVie);
    public abstract void ajoutMaxPointDeVie(double gainDeMaxVie);
}
