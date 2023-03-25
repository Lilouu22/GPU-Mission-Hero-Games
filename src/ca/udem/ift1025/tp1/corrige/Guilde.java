//Nom : Lisa Pamela Valente
//Matricule : 20180163
// TP1 : Création d'un jeu de la Guilde des programmeurs unis
//Date : 3 mars 2023

package ca.udem.ift1025.tp1.corrige;
// Bank Aka inventaire

import java.util.ArrayList;
import java.util.Comparator;

public class Guilde {
    // Création de la liste d'héros
    private ArrayList<Hero> listeHeros;
    private Bank banque;

    //Constructeur poour instancier la liste
    public Guilde(double montant, int nbArmures) {
        this.listeHeros =  new ArrayList<Hero>();
        this.banque = new Bank(montant, nbArmures);

    }

    public ArrayList<Hero> getListeHeros() {
        return listeHeros;
    }

    //Méthode pour ajouter hero à liste en ordre croissant
    public void ajoutHero(Hero hero){
        listeHeros.add(hero);
        this.sortListeHero();
    }

    public Bank getBanque() {
        return banque;
    }

    public void sortListeHero(){
        listeHeros.sort(Comparator.comparing(Hero::getCategorie));
    }
}
