package gti310.tp3.parser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import gti310.tp3.Bean;

public class ConcreteParser implements Parser<Bean> {

	@Override
	public Bean parse(String filename) {
		Bean newBean = new Bean();
		String[] splited;

		// lecture du fichier texte
		try {
			InputStream ips = new FileInputStream(filename);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			int i = 0;
			while ((ligne = br.readLine()) != null) {
				if (i == 0) {
					// On place le premier cractère du fichier dans la variable
					// voulu de notre objet
					newBean.setNbsommet(Integer.parseInt(ligne));

				}
				if (i == 1) {
					newBean.setValeurInfini(Integer.parseInt(ligne));

				}
				if (i == 2) {
					newBean.setSommetDepart(Integer.parseInt(ligne));

				} else if (i > 2) {
					// On découpe la ligne par espace pour garder que nos deux
					// premiers caractères
					splited = ligne.split("\\s+");
					if (splited[0].equals("$")) {
						System.out.println("Fin du fichier");
					} else {
						System.out.println("caractere 1: " + splited[0]
								+ " caractere 2: " + splited[1]);

						newBean.addSommetEntree(i-2,Integer.parseInt(splited[0]));
						 newBean.addSommetSortie(i-2,Integer.parseInt(splited[1]));
					}

				}
				System.out.println(ligne);

				i++;
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

}
