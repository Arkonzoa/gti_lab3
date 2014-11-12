package gti310.tp3;

import java.util.ArrayList;

public class Bean {
	
	private int nbsommet;
	private int valeurInfini;
	private int sommetDepart;
	
	private ArrayList<Integer> sommetEntree = new ArrayList<Integer>();
	private ArrayList<Integer> sommetSortie = new ArrayList<Integer>();

	/**
	 * @return the nbsommet
	 */
	public int getNbsommet() {
		return nbsommet;
	}

	/**
	 * @param nbsommet the nbsommet to set
	 */
	public void setNbsommet(int nbsommet) {
		this.nbsommet = nbsommet;
	}

	/**
	 * @return the valeurInfini
	 */
	public int getValeurInfini() {
		return valeurInfini;
	}

	/**
	 * @param valeurInfini the valeurInfini to set
	 */
	public void setValeurInfini(int valeurInfini) {
		this.valeurInfini = valeurInfini;
	}

	/**
	 * @return the sommetDepart
	 */
	public int getSommetDepart() {
		return sommetDepart;
	}

	/**
	 * @param sommetDepart the sommetDepart to set
	 */
	public void setSommetDepart(int sommetDepart) {
		this.sommetDepart = sommetDepart;
	}

	/**
	 * @return the sommetEntree
	 */
	public ArrayList<Integer> getSommetEntree() {
		return sommetEntree;
	}

	/**
	 * @param sommetEntree the sommetEntree to set
	 */
	public void setSommetEntree(ArrayList<Integer> sommetEntree) {
		this.sommetEntree = sommetEntree;
	}

	/**
	 * @return the sommetSortie
	 */
	public ArrayList<Integer> getSommetSortie() {
		return sommetSortie;
	}

	/**
	 * @param sommetSortie the sommetSortie to set
	 */
	public void setSommetSortie(ArrayList<Integer> sommetSortie) {
		this.sommetSortie = sommetSortie;
	}
	
	public void addSommetSortie(int a) {
		sommetSortie.add(a);
	}
	
	public void addSommetEntree(int a) {
		sommetEntree.add(a);
		
	}

}
