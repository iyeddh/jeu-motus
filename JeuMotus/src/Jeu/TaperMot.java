package Jeu;
import java.util.Scanner;
public interface TaperMot {
	private static Boolean estalphabetic(String mot) {
		for (int i = 0; i < mot.length(); i++) {
            char caractere = mot.charAt(i);
            if (!Character.isLetter(caractere)) {
                return false;
            }
        }
        return true;
	}
	
	private static boolean estdigital(String mot) {
		boolean valide = true ;
		for (char c : mot.toCharArray()) {
			if(!Character.isDigit(c)) {
				valide = false;
				break;
			}
		}
		if(valide == true && Integer.parseInt(mot) < 0) {
			return false;
		}
		return valide;
	}
	public static int intinput() {
		Scanner i = new Scanner(System.in);
		System.out.println("donner un nombre  : ");
		String S=i.next();
		while(!estdigital(S)) {
			System.out.println(" donner un nombre s'il vous plait");
			S=i.next();
		}
		return Integer.parseInt(S);
	}
	public static String input(int taille) {
		Scanner S = new Scanner(System.in);
		String mot;
		while(true) {
			System.out.println(" donner ton mot");
			mot=S.next();
			if(mot.isEmpty()==false && mot.length() == taille && TaperMot.estalphabetic(mot)== true) {
				break;
			}
			else {
				System.out.println("le mot qui tu as taper n'est pas valide");
			}
		}
		return mot.toUpperCase();
	}
}
