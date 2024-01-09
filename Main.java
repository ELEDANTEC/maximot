package fr.eni.maximot;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class JeuDeLettres {

    public static void main(String[] args) {
        // Étape 1: Créer un tableau de noms d'animaux
        String[] nomsAnimaux = {"lion", "éléphant", "girafe", "tigre", "panda", "koala", "singe", "hibou", "renard", "tortue"};

        // Étape 2: Choisir un mot au hasard
        String motChoisi = choisirMotAleatoire(nomsAnimaux);

        // Étape 3: Mélanger les lettres du mot choisi
        String motMelange = melangerLettres(motChoisi);

        // Étape 4: Afficher le tirage au joueur
        System.out.println("Tirage : " + motMelange);

        // Étape 5: Le joueur saisit sa proposition
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisissez votre proposition : ");
        String proposition = scanner.nextLine();

        // Étape 6: Vérifier la proposition
        if (verifierProposition(proposition, motChoisi)) {
            System.out.println("Bravo ! Vous avez trouvé le mot : " + motChoisi);
        } else {
            System.out.println("Dommage, la réponse était : " + motChoisi);
        }
    }

    private static String choisirMotAleatoire(String[] mots) {
        Random random = new Random();
        int indexMot = random.nextInt(mots.length);
        return mots[indexMot];
    }

    private static String melangerLettres(String mot) {
        char[] lettres = mot.toCharArray();
        Random random = new Random();
        for (int i = 0; i < lettres.length; i++) {
            int indexAleatoire = random.nextInt(lettres.length);
            char temp = lettres[i];
            lettres[i] = lettres[indexAleatoire];
            lettres[indexAleatoire] = temp;
        }
        return new String(lettres);
    }

    private static boolean verifierProposition(String proposition, String motChoisi) {
        // Vérifier si toutes les lettres de la proposition sont présentes dans le mot choisi
        for (char lettre : proposition.toCharArray()) {
            if (motChoisi.indexOf(lettre) == -1) {
                return false;
            }
        }
        // Vérifier si la proposition est égale au mot choisi
        return proposition.equals(motChoisi);
    }
}
