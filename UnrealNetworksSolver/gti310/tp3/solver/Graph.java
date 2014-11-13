package gti310.tp3.solver;

import java.util.List;

public abstract class Graph<T> implements GraphInterface<T>{
		 
	  public void printPath(List<Link<T>> path) {
	   for (int i=0; i<path.size(); i++) {
		   System.out.print(path.get(i).start.label + " ");
	   }
	   System.out.print(path.get(path.size()-1).end.label);
	  }
	   
	  public void printEdge(Link<T> e) {
	   System.out.print(e.start.label + "->" + e.end.label );
	  }
	 
	  public void printNode(Summit<T> n) {
	   System.out.print(n.label+" ");
	  }

}
