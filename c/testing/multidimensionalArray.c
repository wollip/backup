#include <stdio.h>

void printarray(int array[][2], int numRow){
	for(int i = 0; i<numRow; i++){
		for (int i2 = 0; i2<2; i2++){
			printf("%d,", array[i][i2]);
		}
		printf("\n");
	}
	printf("\n");
}

int main(void){
	int array[][2] = {
		{1,2},
		{2,3},
		{3,4},
	};
	int numRow = 3;

	printarray(array, numRow);


	return 0;
}