// ConsoleApplication1.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <stdio.h>
#include <omp.h>
#include <windows.h>
#include <algorithm>

#pragma optimize ("",off)
volatile DWORD dwstart;

int main()
{
	const int n = 10000;
	int times = 10000;
	int start;

	int list[n];
	std::fill_n(list, n, 1);
	printf("starting test with array size %d\ndoing addition for %d times\n", n, times);

	printf("starting test with pragma\n");
	dwstart = GetTickCount();
#pragma omp parallel for
	for(int i = 0; i < n; i ++){
		for(int m = 0; m < times; m++)
			list[i]++;
		//printf("%d\n", i);
	}
	printf("test ended in %d milliseconds\n", GetTickCount() - dwstart);

	printf("starting test without pragma\n");
	dwstart = GetTickCount();
	for (int i = 0; i < times; i++) {
		for (int m = 0; m < 10000; m++)
			list[i]++;
		//printf("%d\n", i);
	}
	printf("test ended in %d milliseconds\n", GetTickCount() - dwstart);

	system("pause");
    return 0;
}

