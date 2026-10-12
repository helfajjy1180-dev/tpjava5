package entities;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Donner la capacite de la bibliotheque : ");
        int n = sc.nextInt();
        sc.nextLine();

        Bibliotheque b = new Bibliotheque(n);

        b.ajouter(new Roman("Le Petit Prince",
                "Antoine de Saint-Exupery", 96, 50.0));

        b.ajouter(new Manuel("Java pour debutants",
                "Ahmed", 200, "Debutant"));

        int choix;

        do {
            System.out.println("\n===== MENU BIBLIOTHEQUE =====");
            System.out.println("1. Ajouter un document");
            System.out.println("2. Afficher les documents");
            System.out.println("3. Supprimer un document");
            System.out.println("4. Rechercher un document");
            System.out.println("5. Afficher les auteurs");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");

            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {
                case 1:
                    System.out.println("1. Livre");
                    System.out.println("2. Roman");
                    System.out.println("3. Manuel");
                    System.out.println("4. Revue");
                    System.out.println("5. Dictionnaire");
                    System.out.print("Type : ");

                    int type = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Titre : ");
                    String titre = sc.nextLine();

                    Document doc = null;

                    if (type == 1 || type == 2 || type == 3) {
                        System.out.print("Auteur : ");
                        String auteur = sc.nextLine();

                        System.out.print("Nombre de pages : ");
                        int pages = sc.nextInt();
                        sc.nextLine();

                        if (type == 1) {
                            doc = new Livre(titre, auteur, pages);
                        } else if (type == 2) {
                            System.out.print("Prix : ");
                            double prix = sc.nextDouble();
                            sc.nextLine();

                            doc = new Roman(titre, auteur, pages, prix);
                        } else {
                            System.out.print("Niveau : ");
                            String niveau = sc.nextLine();

                            doc = new Manuel(titre, auteur, pages, niveau);
                        }

                    } else if (type == 4) {
                        System.out.print("Mois : ");
                        String mois = sc.nextLine();

                        System.out.print("Annee : ");
                        int annee = sc.nextInt();
                        sc.nextLine();

                        doc = new Revue(titre, mois, annee);

                    } else if (type == 5) {
                        System.out.print("Langue : ");
                        String langue = sc.nextLine();

                        doc = new Dictionnaire(titre, langue);

                    } else {
                        System.out.println("Type invalide.");
                        break;
                    }

                    if (b.ajouter(doc)) {
                        System.out.println("Document ajoute avec succes.");
                    } else {
                        System.out.println("Echec : bibliotheque pleine.");
                    }
                    break;

                case 2:
                    b.afficherDocuments();
                    break;

                case 3:
                    System.out.print("Numero du document a supprimer : ");
                    int numSup = sc.nextInt();
                    sc.nextLine();

                    Document aSupprimer = b.document(numSup);

                    if (b.supprimer(aSupprimer)) {
                        System.out.println("Document supprime.");
                    } else {
                        System.out.println("Document introuvable.");
                    }
                    break;

                case 4:
                    System.out.print("Numero du document : ");
                    int num = sc.nextInt();
                    sc.nextLine();

                    Document recherche = b.document(num);

                    if (recherche != null) {
                        System.out.println(recherche);
                    } else {
                        System.out.println("Document introuvable.");
                    }
                    break;

                case 5:
                    b.afficherAuteurs();
                    break;

                case 0:
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide.");
            }

        } while (choix != 0);

        sc.close();
    }
}


