#include <stdio.h>

int main()
{
	// single character input
	/*printf("enter something here\n (one character only) \n");
	int x = getchar();

	printf("you entered: ");
	putchar(x);*/

	//a string with definitive length
	/*char str[20];
	printf("Enter anything\n (within 20 characters please)\n");
	gets (str);

	printf("You entered: ");
	puts (str);*/
	
	//anything
	char string[10000];
	
	
	printf("Enter anything you want\n");
	scanf("%s",string);
	
	printf("you entered: %s", string);
	
	return 0;
}