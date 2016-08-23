/*
 *  Course: APSC 160
 *  Program: DAQ_general_framework.c
 *  Purpose: This program implements the general framework for DAQ programs.
 *  The program compiles, but it does not do anything useful, as it is just a framework.
 */
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <DAQlib.h>

#define TRUE 1
#define FALSE 0

/* function prototypes */
void workFunction(void);

/* main Function */
int main(void)
{
    int setupNum;

	/*
	** Prompt user for DAQ mode
	**
	** A more detailed prompt would be:
    ** printf("Just the Framework for DAQ programs. A supplement to lecture notes on DAQ.\n");
    ** printf("Note: This program does not do anything, as it is just the framework. \n\n\n");
    ** printf("Choose type 0 to use the hardware; type 1 to 6 to use the simulator.\n");
    */

    printf("Enter the setup number for DAQ (0 for the device or 1 for the simulator): ");
    scanf("%d", &setupNum);

	/*
	** Calling the setupDAQ function to initialize DAQ
    ** If the return value of the setupDAQ function call is TRUE, initialization is
	** successful.
	*/

    if ( setupDAQ(setupNum) == TRUE )
        workFunction();
    else
        printf("ERROR: Cannot initialize DAQ\n");

    system("PAUSE");
    return 0;
}

/*
** Function to perform work once DAQ is initialized properly
** The function name to be changed to be more descriptive, based on the problem statement
*/

void workFunction(void)
{
    /* variable declarations and initializations, if any */

    /* loop to perform operation until the user quits */

    while( continueSuperLoop() == TRUE )
    {
		/* body of the super-loop to be added to do useful stuff with DAQ */
    }
}


