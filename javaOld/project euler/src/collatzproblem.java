import java.util.Scanner;

public class collatzproblem {
	public static void main(String[]args){
		int[] howManySteps = new int[1000000];
		howManySteps[1]=0;
		
		for(int loop=2; loop<1000000;loop++){
			System.out.println("loop= "+loop);
			long currentnumber = loop;
			int turns = 0;
			while (currentnumber>=loop){
				if(currentnumber%2==0){
					currentnumber = currentnumber/2;
				}else{
					currentnumber = 3*currentnumber+1;
				}
				turns ++;
				//System.out.println("current turns= " + turns);
			}
			howManySteps[loop] = turns + howManySteps[(int)currentnumber];
			System.out.println(howManySteps[loop]);
		}	
		int max = 0;
		for (int i =1; i <1000000;i++){
			int oldmax = max;
			max = Math.max(max, howManySteps[i]);
			if(oldmax != max){
				System.out.println(max +", "+ howManySteps[i]+", "+ i);
			}
		}
		//System.out.println(howManySteps[113383]);
		while(true){
			Scanner input = new Scanner(System.in);
			System.out.println("enter number to check for steps");
			int integer = input.nextInt();
			if(integer<1000000){
				System.out.println(howManySteps[integer]);
			}else{
				System.out.println("error, number must be below 1000000");
			}
		}
		
		
		
	}
}
