package gti310.tp3.writer;

import java.io.File;
import java.io.FileWriter;

import gti310.tp3.Solution;

/**
 * Classe qui va ecrire les solutions dans un fichier texte
 *
 */
public class ConcreteWriter implements Writer<Solution>{


/**
 * Méthode qui va ecrire dans le fichier texte, elle a besoin du nom du fichier et de l'objet solution
 */
	@Override
	public void write(String filename, Solution output) {
		
		//On met en parametre que le nom du fichier, l'extension est obligatoirement txt pour un fichier texte
		  final String chemin = "./"+filename+".txt";
		  
		  //On creer notre nouveau fichier objet
	        final File fichier =new File(chemin); 
	        
	        try {
	        	
	            // Creation du fichier
	            fichier .createNewFile();
	            
	            // creation d'un writer
	            final FileWriter writer = new FileWriter(fichier);
	            try {
	            	
	            	writer.write("Bienvenue dans le fichier de sortie de l'application, voici les solutions :"+"\n");
	               //On ecrit nos solutions dans le fichier txt
	            	writer.write(output.getPath()+"\n"+"\n");
	                writer.write("Fin des solutions");
	            } finally {
	                // quoiqu'il arrive, on ferme le fichier
	                writer.close();
	            }
	        } catch (Exception e) {
	            System.out.println("Impossible de creer le fichier");
	        }
		
	}


}
