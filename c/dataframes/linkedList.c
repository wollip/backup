// linked list
#include <stdio.h>
#include <stdlib.h>
#include <Windows.h>


typedef struct dataframe{
	int value;
	struct dataframe *next;
} list;

// function prototypes for linked list
list* create(void);
list* mod(list*, int);
void append(list*, int);
void print(list*);

// specail function protoypes
list* createMessage(void);
void printMessage(list*);
void scrollMessage(list*);
void backscroll(list*);

int main(void){
	list* message = createMessage();
	//scrollMessage(message);
	backscroll(message);
	return 0;
}


// for linked list
list* create(void){
	list *returnlist = malloc(sizeof(list));
	returnlist->value = 0;
	returnlist->next = NULL;
	return returnlist;
}

list* mod(list* node, int value){
	node->value = value;
	return node;
}


void append(list* previous, int value){
	list* after = create();
	after->next = previous->next;
	mod(after, value);
	previous->next = after;
}

void print(list* start){
	
	list *current = start;
	list *temp;

	while(1){
		printf("%d,", current->value);
		if (current->next == NULL){
			break;
		}
		//current = &*current;
		current = current->next;
	}

	printf("\n");
}

// for scrolling message
list* createMessage(void){
	list* head = create();
	list* temp = head;
	for(int i = 1; i<6; i++){
		append(temp, i);
		temp = temp->next;
	}
	temp->next = head;
	return head;
}

void printMessage(list* message){
	list* temp = message;
	for(int i = 0; i<6; i++){
		printf("%d,", temp->value);
		temp = temp->next;
	}
	printf("\n");
}

void scrollMessage(list* message){
	for(int i = 0; i < 50; i++){
		printMessage(message);
		message = message->next;
		Sleep(500);
	}
}

void backscroll(list* message){
	for(int i = 0; i < 50; i++){
		printMessage(message);
		message = message->next->next->next->next->next;
		Sleep(500);
	}
}