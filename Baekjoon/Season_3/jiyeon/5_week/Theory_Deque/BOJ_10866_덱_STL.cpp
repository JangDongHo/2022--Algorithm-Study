#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int n;
    cin >> n;

    deque<int> DQ;
    while(n--) {
        string command;
        cin >> command;
        if(command == "push_front") {
            int x; 
            cin >> x;
            DQ.push_front(x);
        }
        else if(command == "push_back") {
            int x; 
            cin >> x;
            DQ.push_back(x);
        }
        else if(command == "pop_front") {
            if(DQ.empty()) cout << -1 << '\n';
            else {
                cout << DQ.front() << '\n';
                DQ.pop_front();
            }
        }
        else if(command == "pop_back") {
            if(DQ.empty()) cout << -1 << '\n';
            else {
                cout << DQ.back() << '\n';
                DQ.pop_back();
            }
        }
        else if(command == "size") {
            cout << DQ.size() << '\n';
        }
        else if(command == "empty") {
            cout << DQ.empty() << '\n';
        }
        else if(command == "front") {
            if(DQ.empty()) cout << -1 << '\n';
            else cout << DQ.front() << '\n';
        } 
        else {  // back
            if(DQ.empty()) cout << -1 << '\n';
            else cout << DQ.back() << '\n';
        }
    }
}