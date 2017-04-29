package contenu;

public class Main {

	public static void main(String[] args) {
		int nbLignes, nbColonnes;
		
		if(args.length >= 2){
			nbLignes = Integer.parseInt(args[0]);
			nbColonnes = Integer.parseInt(args[1]);
		} else {
			nbLignes = 3;
			nbColonnes = 4;
		}

		Partie p = new Partie(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		
		System.out.println(p.getGaufre().toString());
	}

}
