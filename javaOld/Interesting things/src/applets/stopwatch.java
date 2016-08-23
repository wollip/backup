package applets;

public class stopwatch {
	private int starttime,currenttime, elapsedtime;
	
	public stopwatch(){}
	
	public void start(){
		starttime = (int) System.currentTimeMillis()/1000;
	}
	public int time(){
		currenttime = (int) System.currentTimeMillis()/1000;
		elapsedtime = currenttime - starttime;
		return elapsedtime;
	}
	public void reset(){
		starttime = (int) System.currentTimeMillis();
	}
	

}
