#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    while(1) {
        stack<char> brackets;
        bool isNormal = true;
        string input;
        getline(cin, input);

        if(input.at(0) == '.') break;
        
        for(auto c: input ) {
            switch(c) {
                case '(': {
                    brackets.push('(');
                    break;
                }
                case ')': {
                    if(brackets.empty() || brackets.top() != '(') {
                        isNormal = false;
                        break;
                    }
                    brackets.pop();
                    break;
                }
                case '[': {
                    brackets.push('[');
                    break;
                }
                case ']': {
                    if(brackets.empty() || brackets.top() != '[') {
                        isNormal = false;
                        break;
                    }        
                    brackets.pop();
                    break;
                }
            }
        }
        if(!brackets.empty()) isNormal = false;
        if(isNormal) cout << "yes\n";
        else cout << "no\n";
    }
}