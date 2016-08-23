/* approximation of ln() */

#include <stdio.h>
#include <math.h>

int main (void) {
	double xvalue, sum = 0, currentterm;
	int termnumber = 0;

	printf("Please enter value of x (0 < x < 2):");
	scanf("%lf", &xvalue);

	do{
		termnumber++;
		currentterm = pow(-1, termnumber+1)*pow(xvalue-1, termnumber)/termnumber;
		
		sum = sum + currentterm;
	}while(fabs(currentterm)>0.000001);

	printf("Approximation to ln(%.6lf) is %.6lf\n", xvalue, sum);
	printf("- computed using %d\n", termnumber);

	system("PAUSE");
	return 0;
}