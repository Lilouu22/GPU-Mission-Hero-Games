//Nom : Lisa Pamela Valente
//Matricule : 20180163
// TP1 : Création d'un jeu de la Guilde des programmeurs unis
//Date : 3 mars 2023

package ca.udem.ift1025.tp1.corrige;
public class LegendaryHero extends Hero {
    private String nom;
    private int categorie;
    private double pointDeVie;
    private double maxPointDeVie;


    //Constructeur
    public LegendaryHero(String nom, int categorie, double pointDeVie) {
        this.nom = nom;
        this.categorie = categorie;
        this.pointDeVie = pointDeVie;
        this.maxPointDeVie = pointDeVie;

    }

    //Getters et setters
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

    public double getMaxPointDeVie(){
        return  this.maxPointDeVie;
    }

    public void setMaxPointDeVie(double maxPointDeVie) {
        this.maxPointDeVie = maxPointDeVie;
    }

    public void retraitPointDeVie(double coutDeVie) {
        pointDeVie = pointDeVie - coutDeVie;
    }
    public void ajoutPointDeVie(double gainDeVie){
        pointDeVie = pointDeVie + gainDeVie;
    }
    public void ajoutMaxPointDeVie(double gainDeMaxVie){
        maxPointDeVie = maxPointDeVie + gainDeMaxVie;
    }
}
