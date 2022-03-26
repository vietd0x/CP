#include <bits/stdc++.h>
using namespace std;

void printAr(int a[], int n){
    for (int i = 0; i < n; i++)
        printf("%d ", a[i]);
    printf("\n");
}
// ------------------------Merge Sort------------------------
void merge(int a[], int l, int m, int r){
    int nl = m - l + 1, L[nl];
    int nr = r - m, R[nr];
    for(int i = 0; i < nl; i++)     L[i] = a[l+i];
    for(int i = 0; i < nr; i++)     R[i] = a[m+1+i];

    int i = 0, j = 0, k = l;
    while(i < nl && j < nr){
        if(L[i] <= R[j])
            a[k++] = L[i++];
        else
            a[k++] = R[j++];
    }

    while(i < nl)
        a[k++] = L[i++];
    while(j < nr)
        a[k++] = R[j++];
}
void mergeSort(int a[], int l, int r){
    if(l < r){
        int m = l + (r-l)/2;
        mergeSort(a, l, m);
        mergeSort(a, m+1, r);
        merge(a, l, m, r);
    }
}
// ------------------------Quich Sort------------------------
int partition(int a[], int l, int r, int key){
    int il = l, ir = r;
    while(il <= ir){
        while(a[il] < key)  il++;
        while(a[ir] > key)  ir--;
        if(il <= ir){
            int tmp = a[il];
            a[il] = a[ir];
            a[ir] = tmp;
            il++; ir--;
        }
    }
    return il;
}
void quickSort(int a[], int l, int r){
    if(l >= r)  return;
    int key = a[l+(r-l)/2];
    int pivot = partition(a, l, r, key);
    quickSort(a, l, pivot-1);
    quickSort(a, pivot, r);
}
int main(){
    int nums[] = {5,1,1,2,0,0};
    int len_ = *(&nums+1) - nums;
    // mergeSort(nums, 0, len_-1);
    quickSort(nums, 0, len_-1);
    printAr(nums, len_);
    return 0;
}