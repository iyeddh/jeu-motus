package Jeu;
import java.util.Scanner;
import java.util.Random;
public class TestMotus {
	public static void clearConsole() {
	    try {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows")) {
	            // Pour Windows
	            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
	            pb.inheritIO().start().waitFor();
	        } else {
	            // Pour Linux et macOS
	            System.out.print("\033[H\033[2J");
	            System.out.flush();
	        }
	    } catch (Exception e) {
	        // Gérer les exceptions si nécessaire
	        e.printStackTrace();
	    }
	}

	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("tu doit avoir deux argument passer au ligne du commande");
		}else {
			Scanner scanner = new Scanner(new
					TestMotus().getClass().getClassLoader().getResourceAsStream("d"+Integer.parseInt(
					args[1])+".txt"));
			WordList conf = new WordList(Integer.parseInt(args[1]),scanner);
			Random random = new Random();
			Game jeu = new Game(conf.getDictionnaire().get(random.nextInt(conf.getNbMots())));
			clearConsole();
			while(!args[0].equals("E")) {
				switch (args[0]) {
				case "config": {
					Affichage.configMode();
					Scanner s = new Scanner(System.in);
					String y= "";
					while(y != "E") {
						Affichage.menuConfig();
						y= s.next();
						y=y.toUpperCase();
						clearConsole();
						switch (y) {
						case "A": {
							conf.ajoutMot(TaperMot.input(Integer.parseInt(args[1])));
							break;
						}
						case "C":{
							conf.rechercheMot(TaperMot.input(Integer.parseInt(args[1])));
							break;
						}
						case "S":{
							conf.supprimeMot(TaperMot.input(Integer.parseInt(args[1])));
							break;
						}
						case "P":{
							conf.afficher();
							break;
						}
						case "D":{
							System.out.println("*************************************** donner le nouveau taille des mots 4 - 10 *****************************");
							args[1] = Integer.toString(TaperMot.intinput());
							while(Integer.parseInt(args[1])<4 || Integer.parseInt(args[1]) >10 ) {
								System.out.println("le nombre doit etre entre 4 et 10");
								args[1] = Integer.toString(TaperMot.intinput());
							}
							
							scanner = new Scanner(new
									TestMotus().getClass().getClassLoader().getResourceAsStream("d"+Integer.parseInt(
									args[1])+".txt"));
							conf.setTailleMot(Integer.parseInt(args[1]));
							conf.remplir(scanner);
							clearConsole();							
							break;
						}
						case "E":{
							System.out.println("*******************************************************************************************************");
							System.out.println("*******************************************************************************************************");
							System.out.println("**                                                                                                   **");
							System.out.println("**              taper 'jeu' pour aceder au mode du jeu                                               **");
							System.out.println("**                                                                                                   **");
							System.out.println("**              pour quitter l'aplication taper une commande quelconque                              **");
							System.out.println("**                                                                                                   **");
							System.out.println("*******************************************************************************************************");
							System.out.println("*******************************************************************************************************");
							args[0]=s.next();
							if(!args[0].equals("jeu")) {
								args[0] = "E";
								System.out.println("                                                                 $$\\           \r\n"
										+ "                                                                 \\__|          \r\n"
										+ " $$$$$$\\  $$\\   $$\\        $$$$$$\\   $$$$$$\\$$\\    $$\\  $$$$$$\\  $$\\  $$$$$$\\  \r\n"
										+ " \\____$$\\ $$ |  $$ |      $$  __$$\\ $$  __$$\\$$\\  $$  |$$  __$$\\ $$ |$$  __$$\\ \r\n"
										+ " $$$$$$$ |$$ |  $$ |      $$ |  \\__|$$$$$$$$ \\$$\\$$  / $$ /  $$ |$$ |$$ |  \\__|\r\n"
										+ "$$  __$$ |$$ |  $$ |      $$ |      $$   ____|\\$$$  /  $$ |  $$ |$$ |$$ |      \r\n"
										+ "\\$$$$$$$ |\\$$$$$$  |      $$ |      \\$$$$$$$\\  \\$  /   \\$$$$$$  |$$ |$$ |      \r\n"
										+ " \\_______| \\______/       \\__|       \\_______|  \\_/     \\______/ \\__|\\__|      \r\n"
										+ "                                                                               \r\n"
										+ "                                                                               \r\n"
										+ "                                                                               ");
							}
							else {
								args[0] = "jeu";
							}
							y="E";
							break;
						}
						default:
							System.out.println("unexpected value");;
						}
					}
					break;
				}
				case "jeu":{
					Affichage.jeuMode();
					Scanner gameScanner = new Scanner (System.in);
					String x="";
					while(!x.equals("E")) {
						Affichage.menuJeu();
						x= gameScanner.next();
						x=x.toUpperCase();
						clearConsole();
						switch (x) {
						case "J": {
							System.out.println("******************************************* donner le nombre des essais de 1 - 10 ******************************");
							Game.nbEssais=TaperMot.intinput();
							while(Game.nbEssais<1 || Game.nbEssais> 10) {
								System.out.println("le nombre doit etre entre 1 et 10");
								Game.nbEssais=TaperMot.intinput();
							}
							jeu.setNbEssaisRestants(Game.nbEssais);
							jeu.setMotCache(conf.getDictionnaire().get(random.nextInt(conf.getNbMots())));
							jeu.testMot();
							break;
						}
						case "E" :{
							System.out.println("*******************************************************************************************************");
							System.out.println("*******************************************************************************************************");
							System.out.println("**                                                                                                   **");
							System.out.println("**              taper 'config' pour aceder au mode du configuration                                  **");
							System.out.println("**                                                                                                   **");
							System.out.println("**              pour quitter l'aplication taper une commande quelconque                              **");
							System.out.println("**                                                                                                   **");
							System.out.println("*******************************************************************************************************");
							System.out.println("*******************************************************************************************************");
							args[0]=gameScanner.next();
							if(!args[0].equals("config")) {
								args[0] = "E";
								System.out.println("                                                                 $$\\           \r\n"
										+ "                                                                 \\__|          \r\n"
										+ " $$$$$$\\  $$\\   $$\\        $$$$$$\\   $$$$$$\\$$\\    $$\\  $$$$$$\\  $$\\  $$$$$$\\  \r\n"
										+ " \\____$$\\ $$ |  $$ |      $$  __$$\\ $$  __$$\\$$\\  $$  |$$  __$$\\ $$ |$$  __$$\\ \r\n"
										+ " $$$$$$$ |$$ |  $$ |      $$ |  \\__|$$$$$$$$ \\$$\\$$  / $$ /  $$ |$$ |$$ |  \\__|\r\n"
										+ "$$  __$$ |$$ |  $$ |      $$ |      $$   ____|\\$$$  /  $$ |  $$ |$$ |$$ |      \r\n"
										+ "\\$$$$$$$ |\\$$$$$$  |      $$ |      \\$$$$$$$\\  \\$  /   \\$$$$$$  |$$ |$$ |      \r\n"
										+ " \\_______| \\______/       \\__|       \\_______|  \\_/     \\______/ \\__|\\__|      \r\n"
										+ "                                                                               \r\n"
										+ "                                                                               \r\n"
										+ "                                                                               ");
							}
							else {
								args[0] = "config";
							}
							x="E";
							break;
						}
						default:
							System.out.println("unexpected value");
						}
						
					}
					break;
				}
				case "E":{
					break;
				}
				default:{
					System.out.println("le valeur donner n'est pas valable le programme va sortie automatiquement");
					args[0]="E";
					break;
					}
				}
			}
		}

	}

}