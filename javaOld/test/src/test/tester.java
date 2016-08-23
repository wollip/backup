package test;

public class tester {
	public static void main(String args[]){
//		int k = 1;
//		int[] a = {1,1,0,0,1,0,1,0};
//		System.out.println(Hard_Process(a,k));
		
		for(int i = 0; i < 31; i++){
			System.out.println(i);
		}
	}
	public static int Hard_Process(int[] a, int k) {
	    int start = 0;
	    int maxCount = 0;
	    System.out.println("hello");
	    for(;start<a.length-k; start++){
	        System.out.println(start + "hi");
	        int inner = 0;
	        int count = 0;
	        int zeros = 0;
	        while(zeros<=k){
	            System.out.println(inner+start + "hey");
	            if(start+inner >= a.length){
	                break;
	            }else{
	                if(a[start+inner]==0){
	                    zeros++;  
	                }
	                count++;                
	            }
	            inner++;
	        }
	        count--;
	        if(maxCount < count){
	            maxCount = count;
	        }
	    }
	    return maxCount;
	}

}
