//Nom : Lisa Pamela Valente
//Matricule : 20180163
// TP1 : Création d'un jeu de la Guilde des programmeurs unis
//Date : 3 mars 2023

package ca.udem.ift1025.tp1.corrige;

public class Bank {
    private double montant;
    private int nbArmures;

    // Constructeur
    public Bank(double montant, int nbArmures) {
        this.montant = montant;
        this.nbArmures = nbArmures;
    }
    // Getters
    public double getMontant() {
        return montant;
    }

    public int getNbArmures() {
        return nbArmures;
    }

    //Méthode pour mettre à jour le montant

    public void ajoutMontant(double montantRecompense) {
        //rajout des récompenses lors de quêtes
        montant = montant + montantRecompense ;
    }

    public void retraitMontant(double cout) {
        //retrait montant lors d'achats
        montant = montant - cout ;
    }

    public void ajoutArmures(int armureRecompense) {
        //rajout des récompenses lors de quêtes
        nbArmures = nbArmures + armureRecompense ;
    }

    public void retraitArmures(int coutArmure ) {
        //retrait armures lors d'achats
        nbArmures = nbArmures - coutArmure;
    }
}
