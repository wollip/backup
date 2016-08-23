#include <stdio.h>
#include <string.h>

typedef struct instruc{
	int instructions; 
	// instruction 1 = 
	int line1;
	int line2;
	int line3;
} string;

string* dataprep(void);
int convert(char line[3]);
int convertD(char line[3]);
int doStuff(string* instructions);
void changeLines(void);

unsigned int lines[1000] = {0};

int main(void){
	printf("start\n");
	changeLines();

	string* data = dataprep();
	
	doStuff(data);
	for(int i = 0; i < 340; i++){
		printf("%d: %d\n", i, lines[i]);
	}
	return 0;
}

void changeLines(void){
	for(int i = 0; i<1000; i++){
		lines[i] = 1234567;
	}
}

string* dataprep(void){
	// reading from the file
	FILE* fp = fopen("rawstuff.txt", "r");
	if (fp == NULL){
		printf("file failed to open\n");
	}else{
		printf("file opened\n");
	}

	// setting up variables
	char tempstore[3]; 	// raw inputs from file
	int tempint;			// stores temp interger.
	int flags; 			// what will be the next input
	int retflag = 0;	// if the next value is the endline
	int ret;			// store return values
	int index = 0;		// index for data
	char lazy;			// store first index of tempstore
	int intIndex = 800; // store the index if it is a raw number instead of a list
	string* data = (string*)(malloc(sizeof(string)));
	printf("variable initialized\n");

	while(fscanf(fp, "%s", tempstore) != 0){
		// check for 4 types of inputs

		lazy = tempstore[0];
		if (lazy >= '0' && lazy <= '9'){
			if (flags == 0){
				data[index].line1 = intIndex;
				lines[intIndex] = convertD(tempstore);
				intIndex++;
				flags++;
			}else {
				data[index].line2 = intIndex;
				lines[intIndex] = convertD(tempstore);
				intIndex++;
				flags++;
			}
		}else if(lazy >= 'A' && lazy <= 'Z'){
			// instructions
			switch(lazy){
				case 'A':
					// and instruction
					data[index].instructions = 1;
					break;
				case 'R':
					// right shift
					data[index].instructions = 2;
					break;
				case 'L':
					// left shift
					data[index].instructions = 3;
					break;
				case 'O':
					// or
					data[index].instructions = 4;
					break;
				case 'N':
					// not
					data[index].instructions = 5;
					break;
			}
			flags++;
			
		}else if(lazy >= 'a' && lazy <= 'z'){
			ret = convert(tempstore);
			if (retflag == 1){
				//printf("scanning%d\n", index);
				retflag = 0;
				if (flags == 1){
					data[index].instructions = 0;
				}else if(flags ==2){
					data[index].line1 = 0;
				}
				flags = 0;
				data[index].line3 = ret;

				index++;
				data = (string*) (realloc(data, (index+1)* sizeof(string)));
				if (index == 339){
					break;
				}
			}else{
				if (flags == 0){
					data[index].line1 = ret;
					flags++;
				}else {
					data[index].line2 = ret;
					flags ++;
				}
			}
		}else if(lazy = '-'){
			retflag = 1;
		}else{
			printf("erroreroer\n\n\n\n");
		}
	}
	fclose(fp);
	printf("data prep completed \n\n\n");
	return data;
}

int convert(char line[3]){
	int ret = 0;
	for (int i = 0; line[i] != '\0'; i++){
		ret *= 26;
		ret += (int) line[i] - 'a' + 1;
	}
	return ret;
}
int convertD(char line[3]){
	int ret = 0;
	for (int i = 0; line[i] != '\0'; i++){
		ret *= 10;
		ret += (int) line[i] - '0';
	}
	return ret;
}



int doStuff(string* data){
	int cont = 1;
	int breakClaus = 0;
	while(breakClaus < 339){
		for (int i = 0; i < 340; i++){
			switch(data[i].instructions){
				case 0:
					// no instructions
					if (lines[data[i].line1] != 1234567){
						lines[data[i].line3] = lines[data[i].line1];
						data[i].instructions = -2;
					}
					break;
				case 5:
					// not
					if (lines[data[i].line2] != 1234567){
						lines[data[i].line3] = (~lines[data[i].line2])%65536;
						data[i].instructions = -2;
					}
					break;
				case 1:
					// and
					if (lines[data[i].line1] != 1234567 && lines[data[i].line2] != 1234567){
						lines[data[i].line3] = lines[data[i].line1] & lines[data[i].line2];
						data[i].instructions = -2;
					}
					break;
				case 2:
					// right shift
					if (lines[data[i].line1] != 1234567 && lines[data[i].line2] != 1234567){
						lines[data[i].line3] =  lines[data[i].line1] >> lines[data[i].line2];
						data[i].instructions = -2;
					}
					break;
				case 3:
					// left shift
					if (lines[data[i].line1] != 1234567 && lines[data[i].line2] != 1234567){
						lines[data[i].line3] =  (lines[data[i].line1] << lines[data[i].line2])%65536;
						data[i].instructions = -2;
					}
					break;
				case 4:
					//or
					if (lines[data[i].line1] != 1234567 && lines[data[i].line2] != 1234567){
						lines[data[i].line3] =  (lines[data[i].line1] ^ lines[data[i].line2]);
						data[i].instructions = -2;
					}
					break;
				case -2:
					breakClaus++;
					data[i].instructions = -1;
					printf("a number is found %d\n", i);
				default:
					break;
			}
		}
	}
	return 0;
}