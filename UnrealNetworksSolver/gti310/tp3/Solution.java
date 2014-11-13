package gti310.tp3;

public class Solution {
	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	public void addToPath(String value){
		this.path += "\n"+value;
	}
}
