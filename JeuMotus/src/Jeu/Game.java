package Jeu;
import java.util.ArrayList;
public class Game {
	public static int nbEssais;
	private int nbEssaisRestants;
	public static int nbPartGagnees=0;
	public static int nbPartPerdues=0;
	private String motCache;
	private String motTrouve;
	public int getNbEssaisRestants() {
		return nbEssaisRestants;
	}
	public void setNbEssaisRestants(int nbEssaisRestants) {
		this.nbEssaisRestants = nbEssaisRestants;
	}
	public String getMotCache() {
		return motCache;
	}
	public void setMotCache(String motCache) {
		this.motCache = motCache;
	}
	public String getMotTrouve() {
		return motTrouve;
	}
	public void setMotTrouve(String motTrouve) {
		this.motTrouve = motTrouve;
	}
	public Game(String mot) {
		this.nbEssaisRestants=nbEssais;
		this.motCache=mot;
		this.motTrouve = "";
	}
	private String compareMot(String mot) {
		String hidden="";
		for(char c : mot.toCharArray()) {
			if(mot.indexOf(c)==this.motCache.indexOf(c)) {
				hidden=hidden+c;
			}
			else {
				hidden=hidden+"*";
			}
		}
		return hidden;
		
	}
	private int verifMot(String mot) {
		int vrai=0,malplacer=0;
		for(char c : mot.toCharArray()) {
			if(this.motCache.indexOf(c) != -1) {
				if(mot.indexOf(c)== this.motCache.indexOf(c)) {
					vrai++;
				}
				else {
					malplacer++;
				}
			}
		}
		System.out.println("tu as "+vrai+" caractere juste et de place juste");
		System.out.println("tu as "+malplacer+" caractere malplacer ");
		return vrai;
	}
	public void testMot() {
		ArrayList<String> parcour = new ArrayList<String>();
		while(this.nbEssaisRestants != 0) {
			this.motTrouve=TaperMot.input(this.motCache.length());
			parcour.add(compareMot(this.motTrouve));
			if(verifMot(this.motTrouve)== this.motCache.length()) {
				break;
			}
			this.nbEssaisRestants--;
		}
		System.out.println("Mot cyble      : "+this.motCache );
		if(this.nbEssaisRestants == 0 && this.motTrouve != this.motCache) {
			System.out.println("                                    ___                       \r\n"
					+ "                                            (   )                      \r\n"
					+ "                               .--.    .--.  | | .-.   .--.    .--.    \r\n"
					+ "                              /    \\  /    \\ | |/   \\ /    \\  /    \\   \r\n"
					+ "                             |  .-. ;|  .-. ;|  .-. .|  .-. ;|  .-. ;  \r\n"
					+ "                             |  | | ||  |(___) |  | ||  | | ||  |(___) \r\n"
					+ "                             |  |/  ||  |    | |  | ||  |/  ||  |      \r\n"
					+ "                             |  ' _.'|  | ___| |  | ||  ' _.'|  | ___  \r\n"
					+ "                             |  .'.-.|  '(   ) |  | ||  .'.-.|  '(   ) \r\n"
					+ "                             '  `-' /'  `-' || |  | |'  `-' /'  `-' |  \r\n"
					+ "                              `.__.'  `.__,'(___)(___)`.__.'  `.__,'   \r\n"
					+ "                                                                       \r\n"
					+ "                                                                       ");
			nbPartPerdues++;
		}else {
			System.out.println("                                                                     ___            ___         ___                         \r\n"
					+ "                                                                             (   )          (   )       (   )   .-.                  \r\n"
					+ "                               .--.    .--.  ___ .-.   .--.  ___ .-.    .---. | |_   ___  ___| |   .---. | |_  ( __) .--.  ___ .-.   \r\n"
					+ "                              /    \\  /    \\(   )   \\ /    \\(   )   \\  / .-, (   __)(   )(   ) |  / .-, (   __)(''\")/    \\(   )   \\  \r\n"
					+ "                             |  .-. ;|  .-. ;|  .-. .;  ,-. '| ' .-. ;(__) ; || |    | |  | || | (__) ; || |    | ||  .-. ;|  .-. .  \r\n"
					+ "                             |  |(___) |  | || |  | || |  | ||  / (___) .'`  || | ___| |  | || |   .'`  || | ___| || |  | || |  | |  \r\n"
					+ "                             |  |    | |  | || |  | || |  | || |       / .'| || |(   ) |  | || |  / .'| || |(   ) || |  | || |  | |  \r\n"
					+ "                             |  | ___| |  | || |  | || |  | || |      | /  | || | | || |  | || | | /  | || | | || || |  | || |  | |  \r\n"
					+ "                             |  '(   ) '  | || |  | || '  | || |      ; |  ; || ' | || |  ; '| | ; |  ; || ' | || || '  | || |  | |  \r\n"
					+ "                             '  `-' |'  `-' /| |  | |'  `-' || |      ' `-'  |' `-' ;' `-'  /| | ' `-'  |' `-' ;| |'  `-' /| |  | |  \r\n"
					+ "                              `.__,'  `.__.'(___)(___)`.__. (___)     `.__.'_. `.__.  '.__.'(___)`.__.'_. `.__.(___)`.__.'(___)(___) \r\n"
					+ "                                                      ( `-' ;                                                                        \r\n"
					+ "                                                       `.__.                                                                         ");
			nbPartGagnees++;
		}
		Affichage.afficheArray(parcour);
		System.out.println("nombre des partie gagnat: "+nbPartGagnees+"\n nombre des partie perdues: "+nbPartPerdues);
	}
}
