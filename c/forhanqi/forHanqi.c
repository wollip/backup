#include <stdio.h>

int main (void){
	while (1){
		printf("%c%c%c%c%c", 72,97,110,113,105);
		printf("\n");
		printf("%c%c", '2' +'7', '7' +'<');
		printf("\n");
		printf("%c", '(' +'9');
		printf("\n");
		printf("%c%c%c%c\n", 112 -32, '}' -'1', 69, 6*11);
		printf("hit enter to start again\n");
		getchar();
	}
	return 0;
}