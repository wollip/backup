#include <stdio.h>
//#include <string.h>
#include <math.h>

void printbinary(FILE* fpointer, int term){
	char binary[8] = "00000000";
	for (int i = 7; i >= 0; i--){
		if (term>=pow(2,i)){
			term = term - pow(2,i);
			binary[7-i] = '1';
		}
	}
	fwrite(binary, 1, 8, fpointer);
	fprintf(fpointer, "\t");
}

void printhex(FILE* fpointer, int term){
	char hex[2] = "00";
	hex[0] = term/16+'0';
	if (term%16<10){
		hex[1] = term%16 +'0';
	}else{
		int digit = term%16;
		switch (digit){
			case 10:
				hex[1] = 'a';
				break;
			case 11:
				hex[1] = 'b';
				break;
			case 12:
				hex[1] = 'c';
				break;
			case 13:
				hex[1] = 'd';
				break;
			case 14:
				hex[1] = 'e';
				break;
			case 15:
				hex[1] = 'f';
				break;
		}
	}
	fwrite(hex, 1, 2, fpointer);
	fprintf(fpointer, "\t");
}

int main(void) {
	FILE* filepointer;
	
	filepointer = fopen("convertchart.txt", "r+");

	if (filepointer == NULL){
		printf("failed to open file\n");
		return 1;
	}else {
		printf( "file successfully opened\n");
	}
	// max value is 127 min is 0
	for (int i = 0; i < 128; i++){
		fprintf(filepointer, "%3d\t", i);
		printbinary(filepointer, i);
		printhex(filepointer, i);
		fprintf(filepointer, "%c", i);
		fprintf(filepointer, "\n");
	}
	

	fclose(filepointer);
	printf("program has finished running\n");

	return 0;
}