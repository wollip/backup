#include <stdio.h>

int main()
{
	// c does not have a boolean
	// 1 = true , 0 = false
	char true =1;
	char false = 0;
	if (true){
		printf("hello\n");
	}
	if (false){
		printf("this will not print\n");
	}	
	
	// int = %d, float = %f, double = %lf char = %s

	//string does not exist
	// strcmp returns 0 (false) if strings are the same)
	char * name = "Jason Peng";
	char myname[] = "Jason Peng";
	char * notname = "Bob Smith";
	printf("my name is %s\n", name);
	printf("I am called %s\n", myname);
	printf("his name is %s\n", notname);
	if (strcmp(name, notname)){
		printf("their names are not the same\n");
	}else {
		printf("their names are the same\n");
	}
	
	return 0;
	
}