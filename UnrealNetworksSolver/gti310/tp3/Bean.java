package gti310.tp3;

import java.util.ArrayList;

public class Bean {
	
	private int nbsommet;
	private int valeurInfini;
	private int sommetDepart;
	
	private int[] sommetEntree;
	private int[] sommetSortie;

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
	public int[] getSommetEntree() {
		return sommetEntree;
	}

	/**
	 * @param sommetEntree the sommetEntree to set
	 */
	public void setSommetEntree(int[] sommetEntree) {
		this.sommetEntree = sommetEntree;
	}

	/**
	 * @return the sommetSortie
	 */
	public int[] getSommetSortie() {
		return sommetSortie;
	}

	/**
	 * @param sommetSortie the sommetSortie to set
	 */
	public void setSommetSortie(int[] sommetSortie) {
		this.sommetSortie = sommetSortie;
	}
	
	public void addSommetSortie(int i,int a) {
		sommetSortie[i]=a;
	}
	
	public void addSommetEntree(int i,int a) {
		sommetEntree[i]=a;
	}

}
