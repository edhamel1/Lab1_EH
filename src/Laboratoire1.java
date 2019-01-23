import java.util.Random;
import java.util.Scanner;

public class Laboratoire1 {

    public static void main(String[] args) {

        Scanner clavier = new Scanner(System.in);
        System.out.println("Bonjour, bienvenue dans le jeu de l'allumettes!" +
                "\n Joueur 1, Entrez votre pseudo.");
        String pseud1 = clavier.next();
        System.out.println("Joueur 2, Entrez votre pseudo");
        String pseud2 = clavier.next();

        boolean jeu = false;
        boolean Statut = false;
        String compilGame1 = "";
        String compilGame2 = "";

        while (!jeu){

            Random rand = new Random();
            int nbAllumette = rand.nextInt(80) + 20;
            System.out.println("Il reste " + nbAllumette + " allumettes.");

            for (int i = 0; i <= nbAllumette; i++){

                if (!Statut){

                    System.out.println(pseud1 + " combien d'allumettes souhaitez-vous enlever? (1 à 3)");
                    int nbEnlever1 = clavier.nextInt();

                    if (nbEnlever1 > 3 || nbEnlever1 < 1){
                        System.out.println("Veuillez entrer un nombre valide.");
                        nbEnlever1 = clavier.nextInt();
                        nbAllumette = nbAllumette - nbEnlever1;
                    }
                    else{
                        nbAllumette = nbAllumette - nbEnlever1;
                    }
                    compilGame1 += nbEnlever1 + ",";

                    if (nbAllumette == 0){
                        System.out.println(pseud2 + " vous avez gagné!");
                    }
                    else{
                        Statut = true;
                        System.out.println("Il reste " + nbAllumette + " allumettes");
                    }
                }

                else if (Statut){

                    System.out.println(pseud2 + " combien d'allumettes souhaitez-vous enlever? (1 à 3)");
                    int nbEnlever2 = clavier.nextInt();

                    if (nbEnlever2 < 3){
                        System.out.println("Veuilez entrer un nombre valide.");
                        nbEnlever2 = clavier.nextInt();
                        nbAllumette = nbAllumette - nbEnlever2;
                    }
                    compilGame2 += nbEnlever2 + ",";

                    if (nbAllumette == 0){
                        System.out.println(pseud1 + " vous avez gagné!");
                    }

                    else {
                        Statut = false;
                        System.out.println("Il reste " + nbAllumette + " allumettes.");
                    }
                }

                if (nbAllumette == 0){
                    System.out.println("Choix de " + pseud1 + ": " + compilGame1);
                    System.out.println("Choix de " + pseud2 + ": " + compilGame2);
                    System.out.println("Voulez-vous rejouer? 1-Oui 2-Non");
                    int choix = clavier.nextInt();

                    if (choix != 1 || choix != 2){
                        System.out.println("Entrez un choix valide.");
                        choix = clavier.nextInt();

                        if (choix == 1){
                            System.out.println("Bonne chance. :)");
                        }
                        else{
                            System.out.println("Merci d'avoir joué! :)");
                            jeu = true;
                        }
                    }

                    else if (choix == 1){
                        System.out.println("Bonne chance. :)");
                    }
                    else{
                        System.out.println("Merci d'avoir joué! :)");
                        jeu = true;
                    }
                }
            }
        }
    }
}
