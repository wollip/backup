
public abstract class Cube {
	
	private int[][] points;
	private int[][] links;
	
	public Cube(int[][] points, int[][] links){
		this.points = points;
		this.links = links;
	}
	
	public int[][] getPoints(){
		return points;
	}
	
	public int[][] links(){
		return links;
	}
}
