#include <stdio.h>
#include <math.h>
#include <time.h>
#include <stdlib.>

int main(void){
	int attempts = 5;
	int secretNum = getSecretNumber(100);
	int guess;
	int gotIt = 0;

	srand( (unsigned) time( NULL ));

	while(gotIt == 0 && attempts > 0){
		guess = getGuess(attempts);
		gotIt = checkGuess( guess, secretNum);
		attempts--;
		printf("\n");
	}
	if (gotIt){
		printf("Congradulation you got the number");
	}else{
		printf("Sorry, you have no guesses remaining\n");
		printf( "The secret Number was %d\n", secretNum);
	}	
}

int getSecretNumber(int maxNum){
	return rand() % maxNum+1;	
}

int getGuess( int attemptsRemaining ){
	int guess;
	printf("You have %d guesses remaining...\n", attemptsRemaining);
	printf("Enter your guess: ");
	scanf("%d", &guess);
	return guess;

}	

int checkGuess ( int guess, int secretNum){
	int retvalue;
	if(guess == secretNum){
		retvalue = 1;
	}else{
		if(guess>secretNum){
			printf("your guess is too big\n");
		}else{
			printf("your guess is too low\n");
		}
		retvalue = 0;
	}
	return retvalue;
}