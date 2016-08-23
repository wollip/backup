// rounding test

#include <stdio.h>
#include <math.h>

int main(void){
	double x = 1.6;
	double y = trunc(x);
	printf("x = %.10lf\n;",x);
	printf("using trunc, y = %lf\n",y);
	int z = x;
	printf("using int, z = %d",z);
	double a = rint(x);
	printf("using rint, a = %lf",a);
}