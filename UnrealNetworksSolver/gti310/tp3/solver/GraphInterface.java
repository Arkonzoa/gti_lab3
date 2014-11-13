package gti310.tp3.solver;

/*Graph interface*/
public interface GraphInterface<T> {
	//This method is called whenever we want to add a new summit
	public Graph addSummit(Summit<T> n);
	
	//This method is called to verify if the summit exists based on the input
	public boolean isSummitExist(Summit<T> summit);
	//This method is called to add a new link between summits
	public Graph addLink(Summit<T> start, Summit<T> end);
	//This method returns the unvisited summits based on the current summit
	public Summit<T> getUnvisitedChildren(Summit<T> n);
}
