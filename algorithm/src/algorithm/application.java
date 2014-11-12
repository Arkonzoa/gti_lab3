package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
 
/**
 * Java implementation of Hierholzer's algorithm to find an Eulerian path in a directed graph 
 * 
 * http://en.wikipedia.org/wiki/Eulerian_path
 * 
 * @author stones333
 *
 */
public class application {
  
 static private class Vertex<T> {
  public T label;
  public boolean visited=false;
  public Vertex(T n) {
   this.label=n;
  }
 }
 
 static private class Edge<T> {
  public Vertex<T> start;
  public Vertex<T> end;
  public boolean visited=false;
  public Edge(Vertex<T> start, Vertex<T> end) {
   this.start=start;
   this.end=end;
  }
 }
 
  
 static private interface GraphInterface<T> {
  public Graph addVetex(Vertex<T> n) ;
  public boolean isVetexExist(Vertex<T> vetex);
  public Graph addEdge(Vertex<T> start, Vertex<T> end) ;
  public Vertex<T> getUnvisitedChildren(Vertex<T> n);
   
 }
  
 static private abstract class Graph<T> implements GraphInterface<T> {
 
   
  //DFS traversal of a tree is performed by the dfs() function
  public void dfs(Vertex<T> start) {
   //DFS uses Stack data structure
   Stack<Vertex<T>> stack =new Stack<Vertex<T>>();
   start.visited=true;
   stack.push(start);
   printNode(start);
   while(!stack.isEmpty()) {
    Vertex<T> n= stack.peek();
    Vertex<T> child=getUnvisitedChildren(n);
    if(child!=null) {
     child.visited=true;
     stack.push(child);
     printNode(child);
    } else {
     stack.pop();
    }
   }
  }
 
  //BFS traversal of a graph is performed by the bfs() function
  public void bfs(Vertex<T> start)
  {
   //BFS uses Queue data structure
   Queue<Vertex<T>> que=new LinkedList<Vertex<T>>();
   start.visited=true;
   que.add(start);
   printNode(start);
    
   while(!que.isEmpty()) {
    Vertex<T> n=(Vertex<T>)que.remove();
    Vertex<T> child=null;
    while((child=getUnvisitedChildren(n))!=null) {
     child.visited=true;
     que.add(child);
     printNode(child);
    }
   }
  }
 
  public void printPath(List<Edge<T>> path) {
   for (int i=0; i<path.size(); i++) {
	   System.out.print(path.get(i).start.label + " ");
    //System.out.print(path.get(i).start.label + "->" + path.get(i).end.label + " ");
   }
  }
   
  public void printEdge(Edge<T> e) {
   System.out.print(e.start.label + "->" + e.end.label );
  }
 
  public void printNode(Vertex<T> n) {
   System.out.print(n.label+" ");
  }
 }
 
  
 static private class DirectedGraph<T> extends Graph<T> implements GraphInterface<T> {
  List<Edge<T>> edges=new ArrayList<Edge<T>>();
  List<Vertex<T>> vetexes=new ArrayList<Vertex<T>>();
 
  public Graph addVetex(Vertex<T> n) {
   vetexes.add(n);
   return this;
  }
 
  public boolean isVetexExist(Vertex<T> vetex) {
   return ( vetexes.indexOf(vetex) >=0 ) ;
  }
 
  public boolean isAllEdgeVisited() {
   for (Edge<T> e : edges) {
    if (! e.visited) return false;
   }
   return true;
  }
 
  public List<Edge<T>> findHierholzerPath(Vertex<T> start) {
   Stack<Edge<T>> forward =new Stack<Edge<T>>();
   Stack<Edge<T>> backtrack =new Stack<Edge<T>>();
   Edge<T> e = getUnvisitedEdge(start);
   while (e!=null) {
    e.visited=true;
    forward.push(e);
    e = getUnvisitedEdge(e.end);
   }
    
   while ( ( !forward.isEmpty() ) ) {
    e = forward.pop();
    backtrack.push(e);
    e = getUnvisitedEdge(e.start);
    while (e!=null) {
     e.visited = true;
     forward.push(e);
     e = getUnvisitedEdge(e.end);
    }
   }
 
   List<Edge<T>> path = new LinkedList<Edge<T>>();
   while(!backtrack.isEmpty()) {
    Edge<T> edge = backtrack.pop();
    path.add(edge);
   }
 
   return path;
  }
 
  public List<Edge<T>> findHierholzerPath(Vertex<T> start, Vertex<T> end) {
 
   List<Edge<T>> path = findHierholzerPath(start);
   if (path==null || path.size()==0) {
    System.out.println ("\nNo Eulerian path found!");
   } else {
    if ( path.get(path.size()-1).end == end ) {
     System.out.println ("\nEulerian path found:");
     this.printPath(path);  
    } else {
     System.out.println ("\nNo Eulerian path found!");
    }
   }
   return path;
  }
 
 
 
  //This method will be called to make connect two nodes
  public Graph addEdge(Vertex<T> start, Vertex<T> end) {
   if ( ! isVetexExist(start) ) addVetex(start);
   if ( ! isVetexExist(end) ) addVetex(end);
    
   Edge<T> edge = new Edge<T>(start, end);
   edges.add(edge);
   return this;
  }
   
  public Vertex<T> getUnvisitedChildren(Vertex<T> n) {
   for (Edge<T> e : edges) {
    if ( e.visited==false && e.start.equals(n) ) {
     e.visited=true;
     return e.end;
    }
   }
   return null;
  }
 
  public Edge<T> getUnvisitedEdge(Vertex<T> n) {
   for (Edge<T> e : edges) {
    if ( e.visited==false && e.start.equals(n) ) {
     e.visited=true;
     return e;
    }
   }
   return null;
  }
 
   
  public void clearNodes() {
   for ( Edge<T> e : edges)
    e.visited=false;
    
   for ( Vertex<T> v : vetexes)
    v.visited=false;
 
  }
 }
  
 private static void testEulerianPathCase2() {
  //Lets create nodes as given as an example in the article
  Vertex<String> nA=new Vertex<String>("A"), nB=new Vertex<String>("B");
  Vertex<String> nC=new Vertex<String>("C"), nD=new Vertex<String>("D");
  Vertex<String> nE=new Vertex<String>("E"), nF=new Vertex<String>("F");
 
 
  DirectedGraph<String> g=new DirectedGraph<String>();
   
  g.addEdge(nA,nB); g.addEdge(nB,nC); g.addEdge(nC,nD); g.addEdge(nD,nE);
  g.addEdge(nB,nC); g.addEdge(nC,nF); g.addEdge(nF,nB);
  List<Edge<String>> path = g.findHierholzerPath(nA, nE);
 }
 
 private static void testEulerianPathCase1() {
  Vertex<String> nA=new Vertex<String>("A"), nB=new Vertex<String>("B");
  Vertex<String> nC=new Vertex<String>("C"), nD=new Vertex<String>("D");
  DirectedGraph<String> g=new DirectedGraph<String>();
 
  g.addEdge(nA,nB).addEdge(nB,nC).addEdge(nC,nD).addEdge(nD,nA).addEdge(nA,nC);
   
  List<Edge<String>> path = g.findHierholzerPath(nA, nC);
 }
 
 private static void testNegEulerianPathCase1() {
  Vertex<String> nA=new Vertex<String>("A"), nB=new Vertex<String>("B");
  Vertex<String> nC=new Vertex<String>("C"), nD=new Vertex<String>("D");
  DirectedGraph<String> g=new DirectedGraph<String>();
   
  g.addEdge(nA,nB).addEdge(nB,nC).addEdge(nC,nD).addEdge(nD,nA).addEdge(nA,nC);
   
  List<Edge<String>> path = g.findHierholzerPath(nA, nD);
 }
 
 public static void test(){
	 Vertex<String> a=new Vertex<String>("1"), b=new Vertex<String>("2");
	 Vertex<String> c=new Vertex<String>("3"), d=new Vertex<String>("4");
	 Vertex<String> e=new Vertex<String>("5"), f=new Vertex<String>("6");
	 Vertex<String> g=new Vertex<String>("7"), h=new Vertex<String>("8");
	 Vertex<String> i=new Vertex<String>("9"), j=new Vertex<String>("10");
	 Vertex<String> k=new Vertex<String>("11"), l=new Vertex<String>("12");
	 Vertex<String> m=new Vertex<String>("13"), n=new Vertex<String>("14");
	 DirectedGraph<String> gr=new DirectedGraph<String>();
	 
	 gr.addEdge(a,h); gr.addEdge(h,a); gr.addEdge(h,n); gr.addEdge(n,h);
	 gr.addEdge(h,d); gr.addEdge(d,h); gr.addEdge(h,m);
	 gr.addEdge(m,h); gr.addEdge(d,f); gr.addEdge(f,d); gr.addEdge(m,f);
	 gr.addEdge(f,l); gr.addEdge(l,f); gr.addEdge(l,c);
	 gr.addEdge(c,l); gr.addEdge(g,j); gr.addEdge(j,g); gr.addEdge(b,j);
	 gr.addEdge(j,b); gr.addEdge(e,m); gr.addEdge(l,e);
	 gr.addEdge(g,l); gr.addEdge(k,g); gr.addEdge(c,k); gr.addEdge(i,c);
	 gr.addEdge(f,i);
	 List<Edge<String>> path = gr.findHierholzerPath(a, a);
 }
  
 public static void main(String[] args) {
 
  test();
	 /*System.out.println ("\ntestEulerianPathCase1:");
  testEulerianPathCase1();
   
  System.out.println ("\ntestNegEulerianPathCase1:");
  testNegEulerianPathCase1();
   
  System.out.println ("\ntestEulerianPathCase2:");
  testEulerianPathCase2();*/
 }
 
}