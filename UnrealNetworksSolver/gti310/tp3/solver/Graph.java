package gti310.tp3.solver;

import java.util.List;

public abstract class Graph<T> implements GraphInterface<T>{
	//This method is used for testing purposes. It will print the solution in the console.
	public void printPath(List<Link<T>> path) {
		for (int i=0; i<path.size(); i++) {
			System.out.print(path.get(i).start.label + " ");
		}
		System.out.print(path.get(path.size()-1).end.label);
	}

}
