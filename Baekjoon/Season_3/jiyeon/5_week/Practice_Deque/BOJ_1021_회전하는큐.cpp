#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m;
    cin >> n >> m;
    deque<int> DQ; 
    int cnt = 0;

    for(int i = 1; i <= n; i++) {
        DQ.push_back(i);
    }

    while(m--) {
        int x;
        cin >> x;
        
        int idx = 0;
        for(int a : DQ)
        {
            if(a == x) break;
            idx++;
        }

        if(idx == 0) DQ.pop_front();
        else if(idx <= DQ.size()/2) {
            for(int i = 0; i < idx; i++) {
                int tmp = DQ.front();
                DQ.pop_front();
                DQ.push_back(tmp);
                cnt++;
            }
            DQ.pop_front();
        }
        else if(idx > DQ.size()/2) {
            for(int i = DQ.size(); i > idx; i--) {
                int tmp = DQ.back();
                DQ.pop_back();
                DQ.push_front(tmp);
                cnt++;
            }
            DQ.pop_front();
        }
    }
    cout << cnt;
}