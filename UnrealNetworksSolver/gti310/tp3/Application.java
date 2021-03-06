package gti310.tp3;

import gti310.tp3.parser.ConcreteParser;
import gti310.tp3.parser.Parser;
import gti310.tp3.solver.ConcreteSolver;
import gti310.tp3.writer.ConcreteWriter;
import gti310.tp3.writer.Writer;

/**
 * The Application class defines a template method to call the elements to
 * solve the problem Unreal-Networks is fa�ing.
 * 
 * @author Fran�ois Caron <francois.caron.7@ens.etsmtl.ca>
 */
public class Application {

	/**
	 * The Application's entry point.
	 * 
	 * The main method makes a series of calls to find a solution to the
	 * problem. The program awaits two arguments, the complete path to the
	 * input file, and the complete path to the output file.
	 * 
	 * @param args The array containing the arguments to the files.
	 */
	public static void main(String args[]) {
		System.out.println("Bienvenue dans l'application : Unreal Networks Solver !");
		//Création d'un objet parser pour sortir et traiter les informations du fichier texte d'entrée
		Parser<Bean> parser = new ConcreteParser();
		
		//Appelle de la fonction du parseur avec le fichier en entrée comme argument
		Solution solver = new ConcreteSolver().solve(parser.parse(args[0]));
		
		//Ecriture de la solution dans la console
		System.out.println(solver.getPath());
		
		//Creation d'un writer
		Writer<Solution> writer = new ConcreteWriter();
		
		//Ecriture du fichier texte avec le second argument et la solution comme parametre
		writer.write(args[1], solver);
		
	}
}
