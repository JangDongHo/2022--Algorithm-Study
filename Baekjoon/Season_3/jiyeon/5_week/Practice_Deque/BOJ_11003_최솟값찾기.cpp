#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    deque<int> DQ;
    int n, l;
    cin >> n >> l;
    for(int i = 0; i < n; i++) {
        int a;
        cin >> a;
        DQ.push_back(a);
    }
    if(l == 1) {
        for(int num: DQ) cout << num << ' ';
    }
    else {
        l--;
        cout << DQ.front() << ' ';
        int minIdx = 0;
        for(int i = 1; i < n; i++) {
            int min = 1000000000;
            int start = i-l;
            if(start < 0) start = 0;
            if(start < minIdx) {
                for(int j = minIdx; j <= i; j++) {
                    if(DQ[j] < min) {
                        min = DQ[j];
                        minIdx = j;
                    }
                }
            }
            else {
                for(int j = start; j <= i; j++) {
                    if(DQ[j] < min) {
                        min = DQ[j];
                        minIdx = j;
                    }
                }
            }
            cout << min << ' ';
        }
    }
}