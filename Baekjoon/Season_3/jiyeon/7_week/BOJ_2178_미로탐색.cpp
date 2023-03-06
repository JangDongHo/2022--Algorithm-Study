#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
#define MAX 101
int board[MAX][MAX];
bool vis[MAX][MAX];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n, m;
    cin >> n >> m;
    for(int row = 0; row <= n; row++){
        string num_str ="";
        getline(cin, num_str);
        if(num_str.size()==0)continue;
        for(int col = 0; col < num_str.size(); col++) {
            board[row-1][col] = num_str.at(col)-'0';
        }
    }
    queue<pair<int,int>> Q;
    vis[0][0] =1;
    Q.push({0,0});
    while(!Q.empty()){
        pair<int, int> cur = Q.front();
        Q.pop();
        for(int dir = 0; dir < 4; dir++) {
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if(vis[nx][ny] || board[nx][ny]!=1) continue;
            board[nx][ny] += board[cur.X][cur.Y];
            vis[nx][ny] = 1;
            Q.push({nx,ny});
        }
    }

    cout << board[n-1][m-1];
    return 0;
}