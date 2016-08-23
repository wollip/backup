
public class question9 {
	
	public static void main(String[] args){
		int maxtry = 500;
		boolean end = false;
		for(int outloop = 0; outloop<maxtry;outloop++){
			//System.out.println("outside loop start" + outloop);
			for(int inloop =0;inloop<maxtry;inloop++){
				//System.out.println("inside loop start" + inloop);
				double c = Math.pow(outloop, 2)+Math.pow(inloop, 2);
				//System.out.print("the square root of:"+c);
				c = Math.sqrt(c);
				//System.out.print("is:"+c+"\n");
				if(c%1==0){
					System.out.println("found pythagoras triplets");
					System.out.println(outloop+","+inloop+","+c);
					if((outloop+inloop+c)==1000){
						int product = (int) (outloop*inloop*c);
						System.out.println(product+"="+outloop+"*"+inloop+"*"+c);
						end = true;
						break;
						
					}
				}
			}
			if (end){
				break;
			}
		}
		
	}
}
