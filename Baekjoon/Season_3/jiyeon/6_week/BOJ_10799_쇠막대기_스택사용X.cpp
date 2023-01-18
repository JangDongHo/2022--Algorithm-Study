#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    string s;
    cin >> s;
    int cnt = 0;
    int ans = 0;    
    for(int i = 0; i < s.length(); i++) {
        if(s[i] == '(')
            cnt++;
        else {
            if(s[i-1] =='(') {
                cnt--;
                ans += cnt;
            }
            else {
                cnt--;
                ans++;
            }
        }
    }
    cout << ans << "\n";
}