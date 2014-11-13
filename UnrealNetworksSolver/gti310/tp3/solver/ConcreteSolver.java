package gti310.tp3.solver;

import java.util.ArrayList;
import java.util.List;

import gti310.tp3.Bean;
import gti310.tp3.Solution;

public class ConcreteSolver implements Solver<Bean, Solution>{

	@Override
	public Solution solve(Bean input) {
		
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		ArrayList<Summit<String>> summits = new ArrayList<Summit<String>>();
		DirectedGraph dgraph = new DirectedGraph();
		
		//This loops creates the summits based on the number of summit there are in the input file.
		for(int i = 0; i < input.getNbsommet(); i++){
			summits.add(new Summit<String>(Integer.toString(i+1)));
		}
		
		//We retrieve the ArrayLists of both the entry and exit.
		ArrayList<Integer> start = input.getSommetEntree();
		ArrayList<Integer> end = input.getSommetSortie();
		
		//This loops through both entries and exits arrays to create a unidirectional link between the two summits
		for (int x = 0; x < input.getSommetEntree().size() && x < input.getSommetSortie().size(); x++){
			dgraph.addLink(new Summit<String>(Integer.toString(start.get(x))), new Summit<String>(Integer.toString(end.get(x))));
			
		}
		
		
		
		//This calls the method that will find the eulerian path by sending the starting point and the ending point.
		//It returns a list containing the complete path.
		List<Link<String>> path = dgraph.findEulerianPath(new Summit<String>(Integer.toString(input.getSommetDepart())), new Summit<String>(Integer.toString(input.getSommetDepart())));
		solution.setPath("");
		
		//Loops through the list and joins each value into one string.
		for (int i=0; i<path.size(); i++) {
			   solution.addToPath(path.get(i).start.label + " ");
		   }
		solution.addToPath(path.get(path.size()-1).end.label);
		
		//int cursor = 0;
		return solution;

	}

}
