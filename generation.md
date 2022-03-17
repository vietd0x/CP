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
