package com.exemple;

public class Animal {
	private static int compteur;
	private final int id;
	protected String nom;
	protected int age;
	
	public Animal(String nom, int age) {
	    this.id = ++compteur ;
		this.nom = nom;
		this.age = age;
	}
	



	public String getNom() {
		return nom;
	}

    public int getAge() {
		return age;
	}

   public int getId() {
		return id;
	}




	@Override
	public String toString() {
		return "Animal [id=" + id + ", nom=" + nom + ", age=" + age + "]";
	}
 
	
	

	
	
	
	
}
