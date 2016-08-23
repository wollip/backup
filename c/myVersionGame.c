/* Name: Jason Peng
** student number : 29225159
** email: c.peng@alumni.ubc.ca
** Purpose: the simon game with a slight variation because why not
**			I will include a second mode where you can see how long of a patern you can memorize
*/


#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <stdlib.h>
#include <Windows.h>
#include <time.h>
#include <DAQlib.h>

#define SIMULATOR 6

#define LED0 0
#define LED1 1
#define LED2 2
#define LED3 3

#define PUSHBUTTON0 0
#define PUSHBUTTON1 1
#define PUSHBUTTON2 2
#define PUSHBUTTON3 3

#define ON 1
#define OFF 0

#define SECOND 1000.0

#define CORRECT 1
#define INCORRECT 0


// Function prototypes
// contains the game
void simonGame(void);
// generates a number between 0 and 3 which correspond to the colour
int colourGenerator(void);
// display the sequence
void displaySequence( int* sequence, int sequenceLen);
// checks if the sequence is correct
int checkSequence(int* sequence, int sequenceLen);

int main(void){
	
    int setupNum = SIMULATOR;
	srand( (unsigned) time( NULL) ) ;
	/*
	** Calling the setupDAQ function to initialize DAQ
    ** If the return value of the setupDAQ function call is TRUE, initialization is
	** successful.
	*/

    if ( setupDAQ(setupNum) == TRUE ){
        simonGame();
	}else
        printf("ERROR: Cannot initialize DAQ\n");

    system("PAUSE");
    return 0;

}

void simonGame(void){
	int sequenceLen = 1, currentIndex = 0, continueGame, winnerprinter;
	char answer;
	int* sequence = (int*)(malloc(sequenceLen * sizeof(int)));
	printf( "The game begins now,\n click on the button that corresponding to the sequence of colour\n" );
	while( continueSuperLoop() == TRUE )
    {
		// generate next number
		sequence[currentIndex] = colourGenerator();
		
		// display the sequence to the user
		displaySequence(sequence, sequenceLen);

		// check the user for correct sequence
		
		continueGame = checkSequence(sequence,sequenceLen);
		if (continueGame == INCORRECT){
			// you lose the game
			if (sequenceLen < 6){
				printf("GAME OVER\n" );
			}else{
				printf("GOOD JOB YOU MADE IT TO %d ROUND\n" , sequenceLen-1); 
				
			}
			free(sequence);
			break;
		}else{
			if (sequenceLen == 5){
				
				for( winnerprinter = 0; winnerprinter < 10; winnerprinter++){
					printf("CONGRATULATIONS\n" );
				}
				printf("DO YOU WISH TO CONTINUE? [Y/N]:");
				scanf("%c", &answer);
				if ( answer == 'N' || answer == 'n'){
					printf("SEE YOU NEXT TIME");
					free(sequence);
					break;
				}
			}
			// change the parameters of the sequence
			currentIndex++;
			sequenceLen++;
			sequence = (int*)(realloc(sequence, sequenceLen* sizeof(int)));
			printf("GOING TO NEXT ROUND\n");
			Sleep(2*SECOND);
			
		}
		
    }

}

int colourGenerator(void){
	return rand()%4;
}

void displaySequence(int* sequence, int sequenceLen){
	int currentIndex;
	for(currentIndex = 0; currentIndex <sequenceLen; currentIndex++){
		digitalWrite(sequence[currentIndex], ON);
		Sleep(SECOND);
		digitalWrite(sequence[currentIndex], OFF);
		if(currentIndex != sequenceLen-1){
			Sleep(0.2*SECOND);
		}
	}
}


// please don't click too fast
int checkSequence(int* sequence, int sequenceLen){
	
	int currentIndex;
	int button[4];
	int returnValue = CORRECT;

	for(currentIndex = 0; currentIndex < sequenceLen && returnValue == CORRECT; currentIndex++){
		// read the button push
	
		while(TRUE){
			//wait for a button to pressed
			button[0] = digitalRead(PUSHBUTTON0);
			button[1] = digitalRead(PUSHBUTTON1);
			button[2] = digitalRead(PUSHBUTTON2);
			button[3] = digitalRead(PUSHBUTTON3);
			
			if (button[0] == ON || button[1] == ON || button[2] == ON || button[3] == ON){
				//printf("button is clicked\n");
				// once button is pressed
				// checks if the button pushed is correct
				if(button[sequence[currentIndex]] == ON){
					//correct button is pressed
					while(TRUE){
						//wait for button to be released
						button[sequence[currentIndex]] = digitalRead(sequence[currentIndex]);
												
						if(button[sequence[currentIndex]] == OFF){
							break;
						}
					}	
				}else{
					// incorrect button pressed
					returnValue = INCORRECT;
				}
				break;
			}
		}
	}
	return returnValue;
}