package gti310.tp3.solver;


public class Link<T> {
	public Summit<T> start;
	public Summit<T> end;
	public boolean visited=false;
	public Link(Summit<T> start, Summit<T> end) {
	   this.start=start;
	   this.end=end;
	}
}
