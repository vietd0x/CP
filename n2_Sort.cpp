// #include <bits/stdc++.h>
#include <stdio.h>
#include <iostream>

using namespace std;
#define debug(x) cout << #x << " " << x << endl;

void printArr(int k, int *a, int n){
	printf("%d: ", k);
	for(int i = 0; i < n; i++)
		printf("%d ", a[i]);
	printf("\n");
}

void bubbleSort(int a[], int n){
	for(int i = 0; i < n-1; i++){
		bool isSorted = true;
		for(int j = 0; j < n-i-1; j++){
			if(a[j] > a[j+1]){
				isSorted = false;
				int tmp = a[j];
				a[j] = a[j+1];
				a[j+1] = tmp;
			}
		}
		// printArr(i, a, n);
		if (isSorted)
			break;
	}
}

void insertionSort(int a[], int n){
	for(int i = 1; i < n; i++){
		int ai = a[i];
		int j = i-1;
		while(j >= 0 && ai < a[j]){
			a[j+1] = a[j];
			j--;
		}
		a[j+1] = ai;
		// printArr(i, a, n);
	}
}

void selectionSort(int a[], int n){
	for(int i = 0; i < n; i++){
		int minIdx = i;
		for(int j = i+1; j < n; j++){
			if(a[minIdx] > a[j])
				minIdx = j;
		}
		if(minIdx != i){
			int tmp = a[minIdx];
			a[minIdx] = a[i];
			a[i] = tmp;
		}

		printArr(i, a, n);
	}
}

int main(){
	int n; cin >> n;
	int a[n];
	for(int i = 0; i < n; i++)
		cin >> a[i];
	selectionSort(a, n);
	printArr(0, a, n);
	return 0;
}