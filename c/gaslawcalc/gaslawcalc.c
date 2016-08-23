#include <stdio.h>
#include <stdlib.h>

double r = 0.08206;

double findp(double v, double n, double t){
	double p = n*r*t/v;
	return p;
}
double findv(double p, double n, double t){
	double v = n*r*t/p;
	return v;
}
double findn(double p, double v, double t){
	double n = p*v/t/r;
	return n;
}
double findt(double p, double v, double n){
	double t = p*v/r/n;
	return t;
}

int main(){
	char result;
	double value;
	double volume, mol, pressure, temp;
	while (1){
		printf("please enter what you want to find\n(pressure = p,volume=v,mol=n,temperature=t)\n");
		scanf("%s", &result);
		printf("you entered: %c\n",result);

		switch (result){
			case 'p': 
				while(1){
					printf("Please enter volume (in litre), mol, temperature in kelvin.\nSeparate each variable with a space\n");
					scanf("%lf %lf %lf", &volume, &mol, &temp);
					printf("volume = %lfL\t", volume);
					printf("mol = %lfmol\t", mol);
					printf("temperature = %lfK\nare these value correct? yes/no\n",temp);
					char answer[5];
					scanf("%s",answer);
					if (!(strcmp(answer,"yes"))){
						break;
					}
				}	
				printf("beginning to calculate");
				value = findp(volume, mol, temp);
				break;
			case 'v':
				while(1){
					printf("Please enter pressure (in atm), mol, temperature in kelvin.\nSeparate each variable with a space\n");	
					scanf("%lf %lf %lf", &pressure, &mol, &temp);
					printf("pressure = %lfatm\t", pressure);
					printf("mol = %lfmol\t", mol);
					printf("temperature = %lfK\nare these value correct? yes/no\n", temp);
					char answer[5];
					scanf("%s",answer);
					if (!(strcmp(answer,"yes"))){
						break;
					}
				}	
				printf("beginning to calculate");
				value = findv(pressure, mol, temp);
				break;	
			case 'n':
				while(1){
					printf("Please enter pressure (in atm), volume (in litre), temperature in kelvin.\nSeparate each variable with a space\n");
					scanf("%lf %lf %lf", &volume, &mol, &temp);
					printf("pressure = %lfatm\t", pressure);
					printf("volume = %lfL\t", volume);
					printf("temperature = %lfK\nare these value correct? yes/no\n", temp);
					char answer[5];
					scanf("%s",answer);
					if (!(strcmp(answer,"yes"))){
						break;
					}
				}	
				printf("beginning to calculate");
				value = findn(pressure, volume, temp);
				break;	
			case 't':
				while(1){
					printf("Please enter pressure (in atm). volume (in litre), mol.\nSeparate each variable with a space\n");
					scanf("%lf %lf %lf", &pressure, &volume, &mol);
					printf("volume = %lfL\t", volume);
					printf("mol = %lfmol\t", mol);
					printf("pressure = %lfatm\nare these value correct? yes/no\n", pressure);
					char answer[5];
					scanf("%s",answer);
					if (!(strcmp(answer,"yes"))){
						break;
					}
				}	
				printf("beginning to calculate");
				value = findt(pressure, volume, mol);
				break;	
			default:
				printf("that value is not supported\n");
				continue;	
			
		}
		break;
	}	
	printf("\nthe answer you are looking for is: %lf", value);
	getchar();
	getchar();
	return 0;
}