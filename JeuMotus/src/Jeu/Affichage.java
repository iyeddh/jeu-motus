package Jeu;

public interface Affichage {
	public static void configMode() {
		System.out.println("                                                      ______  __          \r\n"
				+ "                                                     /      \\/  |         \r\n"
				+ "                           _______  ______  _______ /$$$$$$  $$/  ______  \r\n"
				+ "                          /       |/      \\/       \\$$ |_ $$//  |/      \\ \r\n"
				+ "                         /$$$$$$$//$$$$$$  $$$$$$$  $$   |   $$ /$$$$$$  |\r\n"
				+ "                         $$ |     $$ |  $$ $$ |  $$ $$$$/    $$ $$ |  $$ |\r\n"
				+ "                         $$ \\_____$$ \\__$$ $$ |  $$ $$ |     $$ $$ \\__$$ |\r\n"
				+ "                         $$       $$    $$/$$ |  $$ $$ |     $$ $$    $$ |\r\n"
				+ "                          $$$$$$$/ $$$$$$/ $$/   $$/$$/      $$/ $$$$$$$ |\r\n"
				+ "                                                                /  \\__$$ |\r\n"
				+ "                                                                $$    $$/ \r\n"
				+ "                                                                 $$$$$$/  ");
		System.out.println();
		System.out.println();
	}
	public static void menuConfig() {
		System.out.println("*******************************************************************************************************");
		System.out.println("*******************************************************************************************************");
		System.out.println("**                                                                                                   **");
		System.out.println("**                                 MENU DU CHOIX :                                                   **");
		System.out.println("**                                                                                                   **");
		System.out.println("**                         Taper 'A' pour ajouter un mot                                             **");
		System.out.println("**                                                                                                   **");
		System.out.println("**                         Taper 'C' pour chercher un mot au dictionnaire                            **");
		System.out.println("**                                                                                                   **");
		System.out.println("**                         Taper 'S' pour suprimer un mot                                            **");
		System.out.println("**                                                                                                   **");
		System.out.println("**                         Taper 'P' pour afficher les mots dans le dictionnaire                     **");
		System.out.println("**                                                                                                   **");
		System.out.println("**                         Taper 'D' pour remplacer les mots dans le dictionnaire                    **");
		System.out.println("**                                                                                                   **");
		System.out.println("**                         Taper 'E' pour sortir du mode configuration                               **");
		System.out.println("**                                                                                                   **");
		System.out.println("**                                                                                                   **");
		System.out.println("*******************************************************************************************************");
		System.out.println("*******************************************************************************************************");
		System.out.println();
		System.out.println();
	}
	public static void jeuMode() {

		System.out.println("                                                      \r\n"
				+ "                                                       \r\n"
				+ "                                  __  ______  __    __ \r\n"
				+ "                                 /  |/      \\/  |  /  |\r\n"
				+ "                                 $$//$$$$$$  $$ |  $$ |\r\n"
				+ "                                 /  $$    $$ $$ |  $$ |\r\n"
				+ "                                 $$ $$$$$$$$/$$ \\__$$ |\r\n"
				+ "                                 $$ $$       $$    $$/ \r\n"
				+ "                            __   $$ |$$$$$$$/ $$$$$$/  \r\n"
				+ "                           /  \\__$$ |                  \r\n"
				+ "                           $$    $$/                   \r\n"
				+ "                            $$$$$$/                    ");
	}
	public static void menuJeu() {
		System.out.println("*******************************************************************************************************");
		System.out.println("*******************************************************************************************************");
		System.out.println("**                                                                                                   **");
		System.out.println("**                                 MENU DU CHOIX :                                                   **");
		System.out.println("**                                                                                                   **");
		System.out.println("**                         Taper 'J' pour faire un essai                                             **");
		System.out.println("**                                                                                                   **");
		System.out.println("**                         Taper 'E' pour sortir du mode configuration                               **");
		System.out.println("**                                                                                                   **");
		System.out.println("**                                                                                                   **");
		System.out.println("*******************************************************************************************************");
		System.out.println("*******************************************************************************************************");
		System.out.println();
		System.out.println();
	}
	public static void afficheArray(java.util.ArrayList<String> D) {
		System.out.println("*******************************************************************************************************");
		System.out.println("*******************************************************************************************************");
		System.out.println("**                                                                                                   **");
		System.out.println("**                                      il y a "+D.size()+" mots                                                **");
		for (int i = 0; i < D.size(); i++) {
			System.out.println("**                                      -"+D.get(i)+"                                                      **");
		}
		System.out.println("**                                                                                                   **");
		System.out.println("*******************************************************************************************************");
		System.out.println("*******************************************************************************************************");
		System.out.println();
		System.out.println();
	}
}
