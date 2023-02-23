import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {

  int X, Y;

  Pair(int X, int Y) {
    this.X = X;
    this.Y = Y;
  }
}

public class baekjoon7576 {

  static int n, m;
  static int[][] board;
  static int[][] dist;
  static int[] dx, dy;
  static Queue<Pair> Q;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());

    board = new int[n][m];
    dist = new int[n][m];
    Q = new LinkedList<>();

    dx = new int[] { 1, 0, -1, 0 };
    dy = new int[] { 0, 1, 0, -1 };
    // 배열 값 세팅
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
        // 익은 토마토는 큐에 추가
        if (board[i][j] == 1) Q.offer(new Pair(i, j));
        // 안 익은 토마토는 거리 -1로 설정
        if (board[i][j] == 0) dist[i][j] = -1;
      }
    }

    while (!Q.isEmpty()) {
      Pair cur = Q.poll();
      for (int dir = 0; dir < 4; dir++) {
        int nx = cur.X + dx[dir];
        int ny = cur.Y + dy[dir];
        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
        if (dist[nx][ny] >= 0) continue;
        dist[nx][ny] = dist[cur.X][cur.Y] + 1;
        Q.offer(new Pair(nx, ny));
      }
    }

    int result = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        // 토마토가 안 익은게 있으면
        if (dist[i][j] == -1) {
          System.out.println(-1);
          return;
        }
        result = Math.max(result, dist[i][j]);
      }
    }
    System.out.println(result);
  }
}
