//Nom : Lisa Pamela Valente
//Matricule : 20180163
// TP1 : Création d'un jeu de la Guilde des programmeurs unis
//Date : 3 mars 2023

package ca.udem.ift1025.tp1.corrige;

import ca.udem.ift1025.tp1.corrige.guildcommands.GuildCommand;

public class Quete {

    public static void commencerQuete(GuildCommand command, Guilde maGuilde){
        int categorieHero = command.nextInt();
        double coutPointDeVie = command.nextDouble();
        int recompenseEnArgent = command.nextInt();
        int recompenseEnArmures = command.nextInt();
        boolean herosTrouve = false;

        //Sélectionner le héros approprié pour le niveau
        for (int i = 0; i < maGuilde.getListeHeros().size(); i++) {
            Hero heroPotentiel = maGuilde.getListeHeros().get(i);
            //condition pour être envoyé en quête
            if(heroPotentiel.getCategorie() == categorieHero){
                //Calcule point de vie du héros envoyé en quête
                heroPotentiel.retraitPointDeVie(coutPointDeVie);
                herosTrouve = true;

            }else if(heroPotentiel.getCategorie() > categorieHero){
                //SI NIVEAU CORRESPOND PAS, NOUVEAU CALCUL COÛT POINT DE VIE
                double nouveauCoutVie = coutPointDeVie - (heroPotentiel.getCategorie() - categorieHero)*1.5;
                heroPotentiel.retraitPointDeVie(nouveauCoutVie);
                herosTrouve = true;
            }
            if(herosTrouve == true){
                //Vérifie si héros est mort
                if(heroPotentiel.getPointDeVie() <= 0 ) {
                    maGuilde.getListeHeros().remove(i);
                }else{
                    maGuilde.getBanque().ajoutArmures(recompenseEnArmures);
                    maGuilde.getBanque().ajoutMontant(recompenseEnArgent);
                }
                break;
            }
        }
    }
}
