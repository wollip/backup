// cpp_compiler_options_openmp.cpp
#include "stdafx.h"
#include <omp.h>
#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#include <iostream>
#include <algorithm>



volatile DWORD dwStart;
volatile int global = 0;
/*
double test2(int num_steps) {
	int i;
	global++;
	double x, pi, sum = 0.0, step;

	step = 1.0 / (double)num_steps;

	#pragma omp parallel for reduction(+:sum) private(x)
	for (i = 1; i <= num_steps; i++) {
		x = (i - 0.5) * step;
		sum = sum + 4.0 / (1.0 + x*x);
	}

	pi = step * sum;
	return pi;
}
*/

void test1(int* alist, int* blist, int max) {
	//printf("test 1 started\n");
	for(int i = 0; i < max; i++) {
		for(int i2 = 0; i2 < max; i2++)
			alist[i] += blist[i];
		//std::cout << alist[i] << i;
	}
}

void test2(int* alist, int* blist, int max)
{
	//printf("test2 started\n");
#pragma omp parallel for 
	for (int i = 0; i < max; i++) {
		for (int i2 = 0; i2 < max; i2++)
			alist[i] += blist[i];
		//std::cout << alist[i] << omp_get_thread_num << "\n";
	}
}

void checkResult(int* list, int n, int length) {
#pragma omp parallel 
	{
		#pragma omp for
		for (int i = 0; i < length; i++) {
			if (list[i] != n) {
				printf("test failed\n");
				#pragma omp cancel for
				//return;
			}
			#pragma omp cancellation point for
		}
	}
	printf("test succeeded\n");
	return;
}

int main(int argc, char* argv[]) {
	std::cout << "program starting\n";
	const int n = 10000;
	/*
	if (!omp_get_cancellation())
	{
		printf("Cancellations were not enabled, enabling cancellation and rerunning program\n");
	}
	*/
	printf("starting test with array of %d index\nand adding them for %d times\n", n, n);
	
	int blist[n];
	std::fill_n(blist, n, 1);

	for (int i = 0; i < 10; i++)
		std::cout << blist[i];
	std::cout << "\nfinished displaying blist\n";

	int alist[n];
	std::fill_n(alist, n, 0);

	for (int i = 0; i < 10; i++)
		std::cout << alist[i];
	std::cout << "\nfinished displaying alist\n";

	printf("starting test 1 with no pragma\n");
	dwStart = GetTickCount();
	test1(alist, blist, n);
	int result1 = GetTickCount() - dwStart;
	printf_s("test ended in %d milliseconds\n", result1);

	checkResult(alist, n, n);
	
	std::fill_n(alist, n, 0);
	printf("starting test 2 with pragma\n");
	dwStart = GetTickCount();
	test2(alist, blist, n);
	int result2 = GetTickCount() - dwStart;
	printf_s("test ended in %d milliseconds\n", result2);

	checkResult(alist, n, n);
	
	printf("optimized  code took %.2f percent of unoptimized code\n", double(result2) / result1*100);
	
	system("pause");
	return 0;
}