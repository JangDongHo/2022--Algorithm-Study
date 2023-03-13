#include <bits/stdc++.h>
using namespace std;

#define MAX 100001
#define MIN 0
int vis[100001];

int main() {
    memset(vis, -1, sizeof(vis));

    int n, k;
    cin >> n >> k;

    vis[n] = 0;
    queue<int> Q;
    Q.push(n);
    while(!Q.empty())
    {
        int cur = Q.front(); Q.pop();
        for(int nx : {cur-1, cur+1, 2*cur}) {
            if(nx < MIN || nx > MAX) continue;
            if(vis[nx] != -1) continue;
            vis[nx] = vis[cur] + 1;
            Q.push(nx);
        }
    }
    cout << vis[k];
}