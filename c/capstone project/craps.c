/*capstone game, some stupid game called craps. I keep on losing QQ*/

#include <stdio.h>

#define MIN_BET_VALUE 5
#define LOSE 0
#define WIN 1


int rollDie(void){
	int roll = rand()%6+1;
	return roll;
}

int getWallet(void){
	int money;
	printf( "How much money do you have in your wallet?\n" );
	while(1){
		scanf( "%d", &money );	
		if (money > MIN_BET_VALUE) {
			break;
		}
		printf("The amount of money you enter is not valid, try again\n");
	}
	return money;
}

int makeBet(int wallet){
	int bet;
	printf( "Enter amount of your bet\n" );
	while (1) {
		scanf( "%d", &bet );
		if (bet<MIN_BET_VALUE){
			printf( "The amount you entered is too little, try again\n" );
		}else if (bet>wallet){
			printf( "You don't have that much money, try again\n" );
		}else {
			break;
		}
	}
	return bet;
}

int playRound(){
	int sum = rollDie() + rollDie();
	printf( "You rolled %d\n", sum );
	if (sum==2||sum==3||sum==12){
		printf( "You Lose :-(\n" );
		return LOSE;
	}else if (sum==7||sum==11){
		printf( "You won!!\n" );
		return WIN;
	}
	int point = sum;
	printf( "Rolling for point: %d\n", point );
	while (1){
		sum = rollDie() + rollDie();
		printf( "You rolled a %d\n", sum );
		if (sum==point){
			printf( "You won!!\n" );
			return WIN;
		}else if (sum==7){
			printf( "You Lose :-(\n" );
			return LOSE;	
		}
	}
}

int doAgain(int wallet){
	if (wallet<MIN_BET_VALUE){
		printf( "You have no more money to play again :-(\n" );
		return LOSE;	
	}
	char answer;
	printf( "Would you like to play again? Y/N\n" );
	getchar();
	scanf( "%c", &answer );
	if (answer == 'Y'||answer =='y'){
		return WIN;
	}else {
		return LOSE;
	}
}

int main(void){
	int wallet, bet, again, winOrLose;
	wallet = getWallet();
	while (1) {
		printf("\n");

		bet = makeBet(wallet);
		printf("\n");

		winOrLose = playRound();
		if (winOrLose == WIN){
			wallet += bet;
		}else {
			wallet -= bet;
		}
		printf("You have $%d left in your wallet\n", wallet);

		again = doAgain(wallet);
		if (again == 0){
			break;
		}
	}
	
	printf( "You have $%d left in your wallet. Goodbye!\n", wallet );
	return 0;
}