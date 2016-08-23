#include <stdio.h>

void sort(int unsorted[], int length);
void swap(int array[], int index1, int index2);
int max(int array[], int startindex, int endindex);


int main(void){
	int array[] = {7, 5, 2, 4, 1, 3, 8, 9, 6, 0};
	int arraylength = 10;
	

	sort(array, arraylength);

	for(int i = 0; i<arraylength; i++){
		printf("%d,", array[i]);
	}
	printf("\n");
}

int max(int array[], int startindex, int endindex){
	int max = array[startindex-1];
	int store = startindex -1;
	for (int i = startindex; i<endindex; i++){
		if (array[i]>max){
			max = array[i];
			store = i;
		}
	}
	return store;
}

void swap(int array[], int index1, int index2){
	int store = array[index1];
	array[index1] = array[index2];
	array[index2] = store;
}

void sort(int unsorted[], int length){
	int maxplace;
	for (int i = 0; i<length-1; i++){
		maxplace = max(unsorted, i+1, length);
		swap(unsorted, i, maxplace);
	}
}
