package applets;
import objectdraw.*;

public class randomnumbergenerator extends WindowController{
	
	private static final long serialVersionUID = 151684;
	
	private int seednumber =(int) 69.69,sn2,unitnumber,term,
			c1=0,c2=0,c3=0,c4=0,c5=0,c6=0,c7=0,c8=0,c9=0,c0=0
			;
	private Text t0,t1,t2,t3,t4,t5,t6,t7,t8,t9;
	
	public void begin(){
		new Text("click here to begin generating",0,0,canvas);
		t0 = new Text("0:" + c0,0,12,canvas);
		t1 = new Text("1:" + c1,0,24,canvas);
		t2 = new Text("2:" + c2,0,36,canvas);
		t3 = new Text("3:" + c3,0,48,canvas);
		t4 = new Text("4:" + c4,0,60,canvas);
		t5 = new Text("5:" + c5,0,72,canvas);
		t6 = new Text("6:" + c6,0,84,canvas);
		t7 = new Text("7:" + c7,0,96,canvas);
		t8 = new Text("8:" + c8,0,108,canvas);
		t9 = new Text("9:" + c9,0,120,canvas);
	}
	
	public void onMouseClick(Location point){
		sn2 = (seednumber-13)*(seednumber+13);
		sn2 = Math.abs(sn2);
		unitnumber = sn2 % 10;
		double thousandnumber = (double) Math.round(sn2/1000-0.5);
		int ithousandnumber = (int)thousandnumber;
		term = (sn2 - ithousandnumber*1000 - unitnumber)/10;
		seednumber = term;
		term = Math.round(term);
		System.out.print(term +",");
		if (term == 0 || term == 10){
			c0++;
			t0.setText("0:" + c0);
		}else if(term == 1){
			c1++;
			t1.setText("1:"+c1);
		}else if(term == 2){
			c2++;
			t2.setText("2:"+c2);
		}else if(term == 3){
			c3++;
			t3.setText("3:"+c3);
		}else if(term == 4){
			c4++;
			t4.setText("4:"+c4);
		}else if(term == 5){
			c5++;
			t5.setText("5:"+c5);
		}else if(term == 6){
			c6++;
			t6.setText("6:"+c6);
		}else if(term == 7){
			c7++;
			t7.setText("7:"+c7);
		}else if(term == 8){
			c8++;
			t8.setText("8:"+c8);
		}else if(term == 9){
			c9++;
			t9.setText("9:"+c9);
		}
		
		
	}
}
