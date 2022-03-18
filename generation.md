#### B1. Xâu nhị phân kế tiếp: 
Cho xâu nhị phân X[], đưa ra xâu nhị phân tiếp theo của X[]</br>
Input: </br>- Dòng đầu tiên đưa vào số lượng test T.</br>
       - T dòng tiếp theo là các xâu nhị phân X.</br>
       - 1<=T<=100; 1<=len(X)<=10^3

| Input | Output |
| --- | --- |
| 2</br>111111</br>010101 |010110</br>000000|
<details>
<summary>XauNhiPhan.cpp</summary>
	
```cpp
#include <bits/stdc++.h>
using namespace std;

void Solve(){
    string s;
    cin >> s;
    int len = s.size()-1;
    int i = len;
    while(s[i] == '1' && i > -1){
        s[i] = '0';
        --i;
    }
    if(i != -1)
        s[i] = '1';
    cout << s << endl;
}
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while(t--){
        Solve();
    }
    return 0;
}
```
</details>

#### B3. Xâu AB có độ dài N:
Xâu ký tự được gọi là xâu AB nếu mỗi ký tự trong xâu hoặc là ký tự 'A' hoặc là ký tự 'B'. Liệt kê tất cả các xâu AB có độ dài n.
</br>Input:</br>-Dòng đầu tiên đưa vào số lượng test T.</br>-Những dòng tiếp là các bộ test (số tự nhiên n)</br>- 1 <=T,n<=10.
| Input | Output |
| --- | --- |
| 2</br>2</br>3|AA AB BA BB</br>AAA AAB ABA ABB BAA BAB BBA BBB|
<details>
<summary>XauAB.cpp</summary>
	
```cpp
#include <bits/stdc++.h>
using namespace std;

int a[10];
int n;

void printAr(){
    for(int i = 0; i <= n; i++)     printf("%c", a[i]);
    printf(" ");
}

void backtrack(int i){
   if(i == n)   printAr();
   else{
       a[i] = 'A'; backtrack(i+1);
       a[i] = 'B'; backtrack(i+1);
   }
}
int main(){
    int t; cin >> t;
    while(t--){
        cin >> n;
        backtrack(0);
        printf("\n");
    }
    return 0;
}
```
</details>
	
#### B4. In ra các hoán vị từ 1 -> n:
<details>
<summary>XauAB.cpp</summary>
	
```cpp
#include <bits/stdc++.h>
using namespace std;

int a[10];
int n;
bool check[11]; // neu su dung r, check[i] = true

void printAr(){
    for(int i = 1; i <= n; i++) printf("%d", a[i]);
    printf(" ");
}

void backtrack(int i){
    if(i == n+1) printAr();
    else{
        for(int j = 1; j <= n; j++){
            if(!check[j]){
                a[i] = j;
                check[j] = true;
                backtrack(i+1);
                check[j] = false;
            }
        }
    }
}
int main(){
    int t; cin >> t;
    while(t--){
        cin >> n;
        // khoi tao chua dc su dung
        for(int i = 1; i <= n; i++) check[i] = false;
        backtrack(1);
        printf("\n");
    }
    return 0;
}
```
</details>
