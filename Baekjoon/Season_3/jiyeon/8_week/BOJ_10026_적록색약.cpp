#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second
int dx[4] = {1,0,-1,0};
int dy[4] = {0,-1,0,1};
char colorMap[101][101];
int vis[101][101];

void BFS(int x, int y)
{
    queue<pair<int,int>> Q;
    vis[x][y] = 1;
    Q.push({x,y});
    while(!Q.empty()){
        pair<int, int> cur = Q.front(); Q.pop();
        for(int i = 0; i < 4; i++) {
            int nx = cur.X + dx[i];
            int ny = cur.Y + dy[i];
            if(nx < 0 || nx > 101 || ny < 0 || ny > 101) continue;
            if(vis[nx][ny] == 1) continue;
            if(colorMap[nx][ny] != colorMap[cur.X][cur.Y]) continue;
            vis[nx][ny] = 1;
            Q.push({nx, ny});
        }
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;
    for(int row = 0; row < n; row++) {
        for(int col = 0; col < n; col++) {
            cin >> colorMap[row][col];
        }
    }

    memset(vis, 0, sizeof(vis));
    int ans[2] = {0,0};
    for(int row = 0; row < n; row++) {
        for(int col = 0; col < n; col++) {
            if(vis[row][col] == 1) continue;
            BFS(row, col);
            ans[0]++;
        }
    }

    memset(vis, 0, sizeof(vis));
    
    for(int row = 0; row < n; row++)
        for(int col = 0; col < n; col++)
            if(colorMap[row][col] == 'G') colorMap[row][col] = 'R';

    for(int row = 0; row < n; row++) {
        for(int col = 0; col < n; col++) {
            if(vis[row][col] == 1) continue;
            BFS(row, col);
            ans[1]++;
        }
    }

    cout << ans[0] << ' ' << ans[1];
}