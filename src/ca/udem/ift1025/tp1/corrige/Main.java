//Nom : Lisa Pamela Valente
//Matricule : 20180163
// TP1 : Création d'un jeu de la Guilde des programmeurs unis
//Date : 3 mars 2023

package ca.udem.ift1025.tp1.corrige;

import ca.udem.ift1025.tp1.corrige.guildcommands.GuildCommand;
import ca.udem.ift1025.tp1.corrige.guildcommands.GuildCommandSystem;

import java.text.DecimalFormat;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.CANADA);
        GuildCommandSystem guildCommandSystem = new GuildCommandSystem(args);

        Guilde maGuilde = makeGuilde(guildCommandSystem.actualCommand());

        DecimalFormat df = new DecimalFormat("0.0");

        while (guildCommandSystem.hasNextCommand()) {
            GuildCommand command = guildCommandSystem.nextCommand();
            switch (command.getName()) {

                case "buy-hero" -> {
                    String nomHero = command.nextString();
                    int categorieHero = command.nextInt();
                    double coutHero = command.nextDouble();
                    int coutArmure = command.nextInt();
                    double pointsDeVie = command.nextDouble();

                    //Mettre à jour ma Banque
                    maGuilde.getBanque().retraitMontant(coutHero);
                    maGuilde.getBanque().retraitArmures(coutArmure);

                    //Création d'un héro
                    Hero hero = null;

                    switch (categorieHero){
                        case 0:
                            hero = new CommonHero(nomHero,categorieHero,pointsDeVie);
                            break;
                        case 1:
                            hero = new UncommonHero(nomHero,categorieHero,pointsDeVie);
                            break;
                        case 2:
                            hero = new RareHero(nomHero,categorieHero,pointsDeVie);
                            break;
                        case 3:
                            hero = new EpicHero(nomHero,categorieHero,pointsDeVie);
                            break;
                        case 4:
                            hero = new LegendaryHero(nomHero,categorieHero,pointsDeVie);
                            break;
                        default:
                            // indique un problème dans la catégorie indiquée par utilisateur
                            System.out.println("Catégorie invalide");
                            System.exit(1);
                    }

                    //Mettre à jour ma guilde : ajout à la liste Hero
                    maGuilde.ajoutHero(hero);
                }

                case "buy-armor" ->{
                    int nbArmureAchetees = command.nextInt();
                    int prixParArmure = command.nextInt();
                    double coutTotal = nbArmureAchetees * prixParArmure;

                    // vérifier si assez d'argent en banque
                    if(maGuilde.getBanque().getMontant() < coutTotal){
                        System.out.println("Erreur : fond insuffisant");
                    }else{
                        maGuilde.getBanque().ajoutArmures(nbArmureAchetees);
                        maGuilde.getBanque().retraitMontant(coutTotal);
                    }
                }

                case "do-quest" -> {
                    Quete.commencerQuete(command, maGuilde);
                }

                case "train-hero" -> {
                    String nomHero = command.nextString();
                    boolean heroTrouve = false;

                    //trouver héros dans la liste
                    for (int i = 0; i < maGuilde.getListeHeros().size(); i++){
                        Hero heroRecherche = maGuilde.getListeHeros().get(i);
                        if(heroRecherche.getNom().equals(nomHero)){
                            heroTrouve = true;
                            double prixAmelioration = 20 * Math.log(heroRecherche.getCategorie() + 10);
                            int armureAmelioration = (int)Math.ceil(Math.log(heroRecherche.getCategorie() + 10));

                            if (maGuilde.getBanque().getMontant() >= prixAmelioration
                                    && maGuilde.getBanque().getNbArmures() >= armureAmelioration){

                                //Amelioration hero
                                heroRecherche.setMaxPointDeVie(heroRecherche.getMaxPointDeVie() * 1.5);
                                heroRecherche.setPointDeVie(heroRecherche.getMaxPointDeVie());
                                heroRecherche.setCategorie(heroRecherche.getCategorie() + 1);

                                //Mettre a jour la banque
                                maGuilde.getBanque().retraitMontant(prixAmelioration);
                                maGuilde.getBanque().retraitArmures(armureAmelioration);

                                //Ordonner la liste de héros
                                maGuilde.sortListeHero();
                            }
                            else {
                                System.out.println("Erreur: Fonds insuffisants pour amélioration.");
                            }
                            break;
                        }
                    }
                    if(heroTrouve == false) {
                        System.out.println("Erreur:Hero \"" + nomHero + "\" introuvable dans la guilde.");
                    }
                }
            }

        }

        //Imprimer sommaire de la guilde
        System.out.println("Guilde: " + df.format(maGuilde.getBanque().getMontant()) + "$ et " + maGuilde.getBanque().getNbArmures() + " armures");

        //Imprimer le sommaire des héros
        System.out.println("Héros:");
        for (Hero hero:
                maGuilde.getListeHeros()) {
            System.out.println("-" + hero.getNom() + ": niveau = " + hero.getCategorie() + ", HP = " + df.format(hero.getPointDeVie()));
        }
    }


    public static Guilde makeGuilde(GuildCommand command) {
        double montantInitial = command.nextDouble();
        int nbArmures = command.nextInt();
        return new Guilde(montantInitial, nbArmures);
    }
}