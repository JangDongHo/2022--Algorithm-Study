#include <bits/stdc++.h>
using namespace std;

const int MX = 1000005;
int dat[2*MX + 1];
int head = MX, tail = MX;

int empty() {
    if(head == tail) return 1;
    return 0;
}

void push_front(int x) {
    dat[--head] = x;
}

void push_back(int x) {
    dat[tail++] = x;
}

int pop_front() {
    if(empty()) return -1;
    return dat[head++];
}

int pop_back() {
    if(empty()) return -1;
    return dat[--tail];
}

int size() {
    return tail - head;
}

int front() {
    if(empty()) return -1;
    return dat[head];
}

int back() {
    if(empty()) return -1;
    return dat[tail-1];
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n;
    cin >> n;

    while(n--) {
        string command;
        cin >> command;
        
        if(command == "push_front") {
            int x;
            cin >> x;
            push_front(x);
        }
        else if(command == "push_back") {
            int x;
            cin >> x;
            push_back(x);
        }
        else if(command == "pop_front") {
            cout << pop_front() << '\n';
        }
        else if(command == "pop_back") {
            cout << pop_back() << '\n';
        }
        else if(command == "size") {
            cout << size() << '\n';
        }
        else if(command == "empty") {
            cout << empty() << '\n';
        }
        else if(command == "front") {
            cout << front() << '\n';
        }
        else { // command == "back" 
            cout << back() << '\n';
        }
    }

}