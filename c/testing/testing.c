#include <stdio.h>

int* returnpointer(int (*pointer)[2][2]){
	for (int i = 0; i<2; i++){
		for (int i2 = 0; i2 < 2; i++){
			pointer[0][i][i2] = 6;
		}
	}
	return pointer;
}

int main(void){
	int matrix[2][2] = {1,2,3,4};
	int (*mpointer)[2][2] = &matrix;
	printf("%d", mpointer[0][0][0]);
}