#include <stdio.h>
#include <stdlib.h>

int main()
{
    int x[10];
    int scanint;
    FILE* filepointer;

    filepointer = fopen("filetest2.txt", "r");
    if ( filepointer==NULL ){
        printf("file did not open\n");
        return 1;    
    } else {
        printf("file has open\n");
    }

    scanint = fscanf(filepointer, "%d", &x[0]);
    if (scanint != 1){
        printf("error in scanning\n");
        return 1;
    } else {
        printf("scanned the number\n");
    }

    printf("the number scanned is %d\n", x[0]);

    scanint = fscanf(filepointer, "%d", &x[1]);
    if (scanint != 1){
        printf("error in scanning\n");
        return 1;
    } else {
        printf("scanned the number\n");
    }

    printf("the number scanned is %d\n", x[1]);

    fclose(filepointer);

    printf("file closed\n");

    return 0;
}