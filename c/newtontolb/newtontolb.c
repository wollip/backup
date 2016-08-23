// newton to pounds

#include <stdio.h>



#define newtonToLb 4.448;

int main(void){
	double forceNewton, forceLb;

	printf( "Please enter the force in Newton:" );
	scanf( "%lf" , &forceNewton);

	forceLb = forceNewton * newtonToLb;

	printf( "\n%lfN is equal to %lfLbs" , forceNewton, forceLb );

	getchar();
	//System( "PAUSE" );
	return 0;
}