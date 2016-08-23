#include <stdio.h>
#include <stdlib.h>

#define MAX 150
#define LISTLENGTH 20
int LIST[] = {33, 14, 18, 20, 45, 35, 16, 35, 1, 13, 18, 13, 50, 44, 48, 6, 24, 41, 30, 42};
// i deleted 0 got to multiply the answer by 2

int subtract(int, int, int);

int main(void){
	int possibility = 0;
	for(int index = 0; index < LISTLENGTH; index++){
		possibility = subtract(MAX, index, possibility);
	}
	printf("%d\n",possibility);
	return 0;
}

int subtract(int currentMax, int currentIndex, int currentCount){
	//checks if we exhaust the LIST already
	if (currentIndex < LISTLENGTH){
		// we have not	
		// creating new max
		int newMax = currentMax - LIST[currentIndex];
		int newIndex = currentIndex + 1;
		// checks if max is negative
		if(newMax<0){
			// go back to decrease depth to check next value in LIST
			return currentCount;
		}else if(newMax == 0){
			// we found a value
			currentCount ++;
			return currentCount;
		}else{
			// max is still to big
			for(int index = newIndex; index<LISTLENGTH; index++){
				// subtract the current possibility by all the child states
				currentCount = subtract(newMax, index, currentCount);
			}
			// after all childstates are found
			return currentCount;
		}

	}else{
		// we exhausted the list
		return currentCount;
	}

	printf("erroreroeroeroeroeroerer\n");
	return 0;	
}