
public class question8B {
	
	
	public static void main(String[] args){
		int[]  list = {1,8,6,9,4,7,8,8,5,1,8,4,3,8,5,8,6,1,5,6};
		for(int i = 0; i <list.length-12; i++){
			int product =1;
			for (int x=0;x<13;x++){
				product = product*list[i+x];
			}
			System.out.print(product+",");
		}
	}
	

}
