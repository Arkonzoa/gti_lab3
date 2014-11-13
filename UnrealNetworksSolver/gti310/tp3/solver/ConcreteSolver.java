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
		for(int i = 0; i < input.getNbsommet(); i++){
			summits.add(new Summit<String>(Integer.toString(i+1)));
		}
		ArrayList<Integer> start = input.getSommetEntree();
		ArrayList<Integer> end = input.getSommetSortie();
		for (int x = 0; x < input.getSommetEntree().size() && x < input.getSommetSortie().size(); x++){
			dgraph.addLink(new Summit<String>(Integer.toString(start.get(x))), new Summit<String>(Integer.toString(end.get(x))));
			
		}
		
		
		
		
		List<Link<String>> path = dgraph.findEulerianPath(new Summit<String>(Integer.toString(input.getSommetDepart())), new Summit<String>(Integer.toString(input.getSommetDepart())));
		solution.setPath("");
		for (int i=0; i<path.size(); i++) {
			   solution.addToPath(path.get(i).start.label + " ");
		   }
		solution.addToPath(path.get(path.size()-1).end.label);
		
		//int cursor = 0;
		try{
			//solution.addToPath(input.getSommetDepart());
			//while (solution[cursor])
			
			return solution;
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}

	}

}
