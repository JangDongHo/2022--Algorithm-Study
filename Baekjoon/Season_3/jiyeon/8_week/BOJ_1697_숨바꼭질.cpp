#include <bits/stdc++.h>
using namespace std;

#define MAX 100001
#define MIN 0
int dist[100001];

int main() {
    memset(dist, -1, sizeof(dist));

    int n, k;
    cin >> n >> k;

    dist[n] = 0;
    queue<int> Q;
    Q.push(n);
    while(!Q.empty())
    {
        int cur = Q.front(); Q.pop();
        for(int nx : {cur-1, cur+1, 2*cur}) {
            if(nx < MIN || nx > MAX) continue;
            if(dist[nx] != -1) continue;
            dist[nx] = dist[cur] + 1;
            Q.push(nx);
        }
    }
    cout << dist[k];
}