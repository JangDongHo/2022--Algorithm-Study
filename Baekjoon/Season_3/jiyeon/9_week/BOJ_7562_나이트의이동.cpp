#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second
#define MAX 301
int dis[MAX][MAX];
int dx[8] = { 2,2, -1,1, -2,-2, -1,1};
int dy[8] = {-1,1, -2,-2, -1,1, 2,2};
int length;

void BFS(int x, int y)
{
    queue<pair<int,int>> Q;
    Q.push({x,y});
    dis[x][y] = 0;
    while(!Q.empty()) {
        pair<int,int> cur = Q.front(); Q.pop();
        for(int i = 0; i < 8; i++) {
            int nx = cur.X + dx[i];
            int ny = cur.Y + dy[i];
            if(nx < 0 || nx >= length || ny < 0 || ny >= length) continue;
            if(dis[nx][ny] >= 0) continue;
            dis[nx][ny] = dis[cur.X][cur.Y] + 1;
            Q.push({nx,ny});
        }
    }
}

int main() 
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int tc;
    cin >> tc;

    while(tc--)
    {
        int x, y;
        cin >> length;

        fill(&dis[0][0], &dis[length][length], -1);
        
        cin >> x >> y;
        BFS(x, y);

        cin >> x >> y;
        cout << dis[x][y] << '\n';
    }
}