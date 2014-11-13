package gti310.tp3.solver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class DirectedGraph<T> extends Graph<T> implements GraphInterface<T> {
	
	List<Link<T>> links = new ArrayList<Link<T>>();
	List<Summit<T>> summits = new ArrayList<Summit<T>>();
	
	@Override
	public Graph addSummit(Summit<T> s) {
		// TODO Auto-generated method stub
		summits.add(s);
		return this;
	}

	@Override
	public boolean isSummitExist(Summit<T> summit) {
		// TODO Auto-generated method stub
		return(summits.indexOf(summit)>=0);
	}

	@Override
	public Graph addLink(Summit<T> start, Summit<T> end) {
		// TODO Auto-generated method stub
		if ( ! isSummitExist(start) ) addSummit(start);
			if ( ! isSummitExist(end) ) addSummit(end);
		   		Link<T> Link = new Link<T>(start, end);
		links.add(Link);
		return this;
	}

	@Override
	public Summit<T> getUnvisitedChildren(Summit<T> n) {
		// TODO Auto-generated method stub
		for (Link<T> l : links) {
		    if ( l.visited==false && l.start.equals(n) ) {
		    	l.visited=true;
		    	return l.end;
		    }
		}
		return null;
	}
	public boolean isAllLinkVisited() {
		for (Link<T> link : links) {
			if (! link.visited) return false;
		}
		return true;
	}
	public Link<T> getUnvisitedLink(Summit<T> summit) {
		for (Link<T> link : links) {
			if ( link.visited==false && link.start.label.equals(summit.label) ) {
				link.visited=true;
				return link;
		    }
		}
		return null;
	}
	public List<Link<T>> findEulerianPath(Summit<T> start, Summit<T> end) {
		List<Link<T>> path = findEulerianPath(start);
		if (path==null || path.size()==0) {
			System.out.println ("\nNo Eulerian path found!");
		} else {
			if ( path.get(path.size()-1).end.label.equals(end.label)) {
				System.out.println ("\nEulerian path found:");
		    } else {
		    	System.out.println ("\nNo Eulerian path found!");
		    }
		}
		return path;
	}
	public List<Link<T>> findEulerianPath(Summit<T> start) {
		Stack<Link<T>> forward =new Stack<Link<T>>();
		Stack<Link<T>> backtrack =new Stack<Link<T>>();
		Link<T> link = getUnvisitedLink(start);
		while (link!=null) {
			link.visited=true;
		    forward.push(link);
		    link = getUnvisitedLink(link.end);
		}
		    
		while ( ( !forward.isEmpty() ) ) {
			link = forward.pop();
		    backtrack.push(link);
		    link = getUnvisitedLink(link.start);
		    while (link!=null) {
		    	link.visited = true;
		    	forward.push(link);
		    	link = getUnvisitedLink(link.end);
		    }
		}
		 
		List<Link<T>> path = new LinkedList<Link<T>>();
		while(!backtrack.isEmpty()) {
			Link<T> Link = backtrack.pop();
		    path.add(Link);
		}
		//this.printPath(path); 
		return path;
	}
	public void clearNodes() {
		for ( Link<T> link : links)
			link.visited=false;	    
		for ( Summit<T> s : summits)
		    s.visited=false;
	}
}
