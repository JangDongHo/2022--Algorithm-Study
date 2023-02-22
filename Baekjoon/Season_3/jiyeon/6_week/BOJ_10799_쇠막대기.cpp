#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    string bracketInfo;
    getline(cin, bracketInfo);
    stack<int> idxStack;
    vector<int> lasers;
    vector<pair<int, int>> sticks;
    int idx = -1;
    bool isLaser = false;

    for(auto c: bracketInfo) {
        idx++;
        if(c == '(') {
            isLaser = true;
            idxStack.push(idx);
        }
        else {
            if(!isLaser) {
                sticks.push_back(make_pair(idxStack.top(), idx));
                idxStack.pop();
            } 
            else {
                isLaser = false;
                lasers.push_back(idx-1);
                idxStack.pop();
            }
        }
    }
    int result = 0;
    for(int i = 0; i < lasers.size(); i++)
        for(int j = 0; j < sticks.size(); j++) 
            if(sticks[j].first <= lasers[i] && lasers[i] <= sticks[j].second) result++;
    cout << result + sticks.size();
}