#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second
#define MAX 1001
int field[MAX][MAX];
int dist[MAX][MAX];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, -1, 0, 1};

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n, m;
    cin >> m >> n;
    
    queue<pair<int,int>> Q;
    for(int row = 0 ; row < n; row++) {
        for(int col = 0; col < m; col++) {
            cin >> field[row][col];
            if(field[row][col] == 1) 
                Q.push({row, col});
            if(field[row][col] == 0)
                dist[row][col] = -1;
        }
    }
    while(!Q.empty()) {
        pair<int, int> cur = Q.front();
        Q.pop();
        for(int dir = 0; dir < 4; dir++){
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if(dist[nx][ny] >= 0) continue;
            dist[nx][ny] = dist[cur.X][cur.Y] + 1;
            Q.push({nx,ny});
        }
    }
    int day = 0;
    for(int row = 0; row < n; row++){
        for(int col = 0; col < m; col++){
            if(dist[row][col] == -1){
                cout << -1;
                return 0;
            }
            day = max(day, dist[row][col]);
        }
    }
    cout << day;
}