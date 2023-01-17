#include <bits/stdc++.h>
using namespace std;

deque<int> split(string str, char Delimiter) {
    stringstream ss(str);
    string buffer;

    deque<int> result;

    while(getline(ss, buffer, Delimiter)) {
        result.push_back(stoi(buffer));
    }

    return result;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    
    string tmp;
    getline(cin, tmp);
    int t = stoi(tmp);

    while(t--) {
        string p, n, elements;
        deque<int> DQ;
        bool isNormal = true;
        bool isReversed = false;
        getline(cin, p);
        getline(cin, n);
        getline(cin, elements);

        if(stoi(n) != 0) {
            elements.erase(elements.begin());
            elements.pop_back();
            DQ = split(elements, ',');
        }
        for(char command : p) {
            if(command == 'R') {
                if(isReversed) isReversed = false;
                else isReversed = true;
            }
            else if(command == 'D') {
                if(DQ.empty()) {
                    isNormal = false;
                    break;
                }
                else if(!isReversed) DQ.pop_front();
                else if(isReversed) DQ.pop_back();
            }
        }
        if(!isNormal) cout << "error\n";
        else if(!DQ.empty()) {
            cout << "[";
            if(isReversed) {
                for(int i = DQ.size()-1; i > 0; i--) {
                    cout << DQ[i] << ",";
                }
                cout << DQ.front() << "]\n";
            }
            else {
                for(int i = 0; i < DQ.size()-1; i++) {
                    cout << DQ[i] << ",";
                }
                cout << DQ.back() << "]\n";
            }
        } 
        else cout << "[]\n";
    }
}