package gti310.tp3.solver;

import gti310.tp3.Bean;
import gti310.tp3.Solution;

public class ConcreteSolver implements Solver<Bean, Solution>{

	@Override
	public Solution solve(Bean input) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int cursor = 0;
		try{
			solution.addToPath(input.getSommetDepart());
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
