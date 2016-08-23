/*
prompts user to enter a list of number and terminates when =1 is received
it returns the average of the numbers inputed.
*/

#include <stdio.h>

int main(void){
	int inputValue, numberOfInputs =0;
	double average =0;
	//tells the user what to do
	printf("Please enter your values:\nEnter -1 to stop\nThe program will calculate the average\n");
	//infinite loop until -1 is entered
	while(1){
		// gets the input
		scanf("%d", &inputValue);
		printf("input value = %d\n", inputValue);
		//checks if the input is -1
		if(inputValue == -1){
			//checks if the first input is -1
			if(numberOfInputs == 0){
				printf( "Error : no data\n");
			}else{
				printf( "Average of values entered is %lf\n", average);
			}
			//stops the infinite loop
			break;
		}else{
			//change the number of inputs and the current average
			numberOfInputs++;
			average = (average*(numberOfInputs-1) + inputValue)/numberOfInputs;
		}
		
	}
	
	return 0;
}