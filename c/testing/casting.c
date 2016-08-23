/* casting test */

#include <stdio.h>

int main (void) {
	int a = 5;
	int b = 2;

	double c;
	c = (double) a/b;
	printf("c = %lf\n", c);
	
	double d;
	d =  a/(double) b;
	printf("d = %lf\n", d);

	double e;
	e = (double) (a/b);
	printf("e = %lf\n", e);

	double f;
	f = a/b;
	printf("f = %lf\n", f);

	return 0;
}