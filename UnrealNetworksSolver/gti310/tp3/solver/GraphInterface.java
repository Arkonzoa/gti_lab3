package gti310.tp3.solver;


public interface GraphInterface<T> {
	  public Graph addSummit(Summit<T> n) ;
	  public boolean isSummitExist(Summit<T> vetex);
	  public Graph addLink(Summit<T> start, Summit<T> end) ;
	  public Summit<T> getUnvisitedChildren(Summit<T> n);
}
