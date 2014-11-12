package gti310.tp3;

import java.util.ArrayList;

public class Solution {
	private ArrayList<Integer> path;

	public ArrayList<Integer> getPath() {
		return path;
	}

	public void setPath(ArrayList<Integer> path) {
		this.path = path;
	}
	public void addToPath(int value){
		this.path.add(value);
	}
}
