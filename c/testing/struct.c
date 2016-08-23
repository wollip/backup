#include <stdio.h>

struct BigInteger {
        unsigned int* array;
        int length;
        char flags;
};

void change(struct BigInteger number){
	number.flags = 'c';
	number.length = 5;
}

int main(void){
	unsigned int array[4] = {0,0,0,0};

	struct BigInteger a;
	a.array = array;
	a.length = 4;
	a.flags = 'h';
	
	change(a);

	printf("%c,", a.flags);
	printf("%d\n", a.length);
}