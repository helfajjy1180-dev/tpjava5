package com.exemple;

public class Zoo {
	private Animal[] animaux;
    private int nbAnimaux;

    public Zoo() {
        this.animaux   = new Animal[5];
        this.nbAnimaux = 0;
    }

    public void ajouterAnimal(Animal a) {
        if (nbAnimaux == animaux.length) {
            Animal[] tmp = new Animal[animaux.length * 2];
            System.arraycopy(animaux, 0, tmp, 0, animaux.length);
            animaux = tmp;
        }
        animaux[nbAnimaux++] = a;
    }

    public void afficherTous() {
        System.out.println("Le zoo contient " + nbAnimaux + " animaux :");
        for (int i = 0; i < nbAnimaux; i++) {
            System.out.println("  - " + animaux[i]);
        } }
  public void supprimerAnimal(int id) {
    for (int i = 0; i < nbAnimaux; i++) {
        if (animaux[i].getId() == id) {

            for (int j = i; j < nbAnimaux - 1; j++) {
                animaux[j] = animaux[j + 1];
            }

            animaux[nbAnimaux - 1] = null;
            nbAnimaux--;

            System.out.println("Animal supprimé avec succès.");
            return;
        }
    }

    System.out.println("Aucun animal trouvé avec cet ID.");
}

     
}

