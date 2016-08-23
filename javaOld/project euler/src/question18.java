import java.util.*;
public class question18 {
	
	
	public static void main(String[] args){
		int[] end =   {1,2,3,4,5,6,7,8};
		int[] begin = {0,1,0,2,0,3,0,4,0};
		int[] finalarray = newarray(end,begin);
		for(int i=0; i<finalarray.length;i++){
			System.out.println(finalarray[i]);
		}
	}
	
	public static int[] newarray(int[] end, int[] begin){
		int endlength = end.length;
		int beginlength = begin.length;
		if( endlength+1 != beginlength){
			System.out.println("ERROR ERROR EROOR");
			return end;
		}
		for (int i =0; i<endlength;i++){
			end[i] = end[i] + Math.max(begin[i], begin[i+1]);
		}
		return end;
	}

}
