#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second
#define MAX 501
bool board[MAX][MAX];
bool vis [MAX][MAX];
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int n, m;

int BFS(int row, int col) {
    queue<pair<int,int>> Q;
    vis[row][col] = 1;
    Q.push({row,col});
    int area = 0; //그림의 넓이
    while(!Q.empty()) {
        area++;
        pair<int,int> cur = Q.front(); 
        Q.pop();
        for(int dir = 0; dir < 4; dir++) {
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if(vis[nx][ny] || board[nx][ny] != 1) continue;
            vis[nx][ny] = 1;
            Q.push({nx, ny});
        }
    }
    return area;
}

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m;
    for(int row = 0; row < n; row++){
        for(int col = 0; col < m; col++){
            cin >> board[row][col];
        }
    }
    int cnt = 0;
    int mx = 0;
    for(int row = 0; row < n; row++){
        for(int col = 0; col < m; col++){
            if(board[row][col]==0 || vis[row][col]) continue;
            cnt++;  // 그림의 개수
            mx = max(mx, BFS(row,col));  //그림의 넓이
        }
    }
    cout << cnt << '\n' << mx;
    return 0;
}