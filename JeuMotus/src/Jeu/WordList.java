package Jeu;
import java.util.ArrayList;
public class WordList {
	private int tailleMot;
	private int nbMots;
	private ArrayList <String> dictionnaire = new ArrayList<String>();
	public WordList(int tailleMot,java.util.Scanner S) {
		this.tailleMot=tailleMot;
		this.nbMots=0;
		remplir(S);
	}
	public int getTailleMot() {
		return tailleMot;
	}
	public void setTailleMot(int tailleMot) {
		this.tailleMot = tailleMot;
	}
	public int getNbMots() {
		return nbMots;
	}
	public void setNbMots(int nbMots) {
		this.nbMots = nbMots;
	}
	public ArrayList<String> getDictionnaire() {
		return dictionnaire;
	}
	public void setDictionnaire(ArrayList<String> dictionnaire) {
		this.dictionnaire = dictionnaire;
	}
	private boolean MotValide(String s) {
		 if (s == null || s.isEmpty() || s.length() != tailleMot) {
	            return false;
	        }
	        for (char c : s.toCharArray()) {
	            if (!Character.isUpperCase(c) || !Character.isLetter(c)) {
	                return false;
	            }
	        }
	        return true;
	}
	public void ajoutMot(String Mot) {
		int index=0;
		if(this.dictionnaire.isEmpty()) {
			this.dictionnaire.add(Mot);
			System.out.println(" le mot est ' "+Mot+" ' est ajouter avec succes");
			this.nbMots++;
		}
		else {
			if(dictionnaire.contains(Mot)==false) {
				if(MotValide(Mot)) {
					while(index<dictionnaire.size() && dictionnaire.get(index).compareTo(Mot)<0) {
						index++;
					}
					dictionnaire.add(index, Mot);
					System.out.println(" le mot '"+Mot+"'  est ajouter avec succes");
					this.nbMots++;
					}
				else {
					System.out.println("le mot '"+Mot+"' n'est pas valide");
				}
				
			}
			else {
				System.out.println(" le mot est '"+Mot+"' n'est pas ajouter car elle existe deja");
			}
		}
	}
	public void remplir(java.util.Scanner S) {
		this.nbMots=0;
		this.dictionnaire.clear();
		while(S.hasNext()) {
			this.ajoutMot(S.nextLine());
		}
	}
	public void afficher() {
		System.out.println("la liste des mots dans le dictionnaire est :");
		Affichage.afficheArray(dictionnaire);
		}
	public int rechercheMot(String Mot) {
		if(dictionnaire.contains(Mot)) {
			System.out.println("le dictionnaire contient le mot : "+Mot );
			return this.dictionnaire.indexOf(Mot);
		}
		else {
			System.out.println(" le mot "+Mot+" n'existe pas dans le dictionnaire");
			return -1;
		}
		
	}
	public void supprimeMot(String Mot) {
		if (dictionnaire.contains(Mot)) {
			dictionnaire.remove(rechercheMot(Mot));
			System.out.println("le mot est supprimer");
			this.nbMots--;
		}
		else {
			System.out.println("le mot deja n'existe pas dans le dictionnaire ");
		}
	}
}