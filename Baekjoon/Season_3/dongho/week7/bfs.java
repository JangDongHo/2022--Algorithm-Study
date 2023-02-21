import java.util.LinkedList;
import java.util.Queue;

class Pair {

  int X, Y;

  Pair(int X, int Y) {
    this.X = X;
    this.Y = Y;
  }
}

public class bfs {

  public static void main(String[] args) {
    int board[][] = {
      { 1, 1, 1, 0, 1, 0, 0, 0, 0, 0 },
      { 1, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
      { 1, 1, 1, 0, 1, 0, 0, 0, 0, 0 },
      { 1, 1, 0, 0, 1, 0, 0, 0, 0, 0 },
      { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
      { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
      { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
    }; // 1이 파란칸, 0이 빨간 칸에 대응

    boolean vis[][] = new boolean[502][502]; // 해당 칸을 방문했는지 여부를 저장
    int n = 7, m = 10; // n = 행의 수, m = 열의 수
    int dx[] = { 1, 0, -1, 0 };
    int dy[] = { 0, 1, 0, -1 }; // 상하좌우 네 방향을 의미
    Queue<Pair> Q = new LinkedList<>();
    vis[0][0] = true; // (0, 0)을 방문했다고 명시
    Q.offer(new Pair(0, 0));
    while (!Q.isEmpty()) {
      Pair cur = Q.poll();
      System.out.printf("(%d,%d) -> ", cur.X, cur.Y);
      for (int dir = 0; dir < 4; dir++) { // 상하좌우 칸을 살펴볼 것이다.
        int nx = cur.X + dx[dir];
        int ny = cur.Y + dy[dir]; // nx, ny에 dir에서 정한 방향의 인접한 칸의 좌표가 들어감
        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue; // 범위 밖일 경우 넘어감
        if (vis[nx][ny] || board[nx][ny] != 1) continue; // 이미 방문한 칸이거나 파란 칸이 아닐 경우
        vis[nx][ny] = true; // (nx, ny)를 방문했다고 명시
        Q.offer(new Pair(nx, ny));
      }
    }
  }
}
