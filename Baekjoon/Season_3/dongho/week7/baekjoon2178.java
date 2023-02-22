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

public class baekjoon2178 {

  static int n, m;
  static int[][] board;
  static int[][] dist;
  static int[] dx, dy;
  static Queue<Pair> Q;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    board = new int[n][m];
    dist = new int[n][m];
    Q = new LinkedList<>();

    dx = new int[] { 1, 0, -1, 0 };
    dy = new int[] { 0, 1, 0, -1 };
    // 배열 값 세팅
    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      for (int j = 0; j < m; j++) {
        board[i][j] = s.charAt(j) - '0';
      }
    }
    for (int d[] : dist) {
      Arrays.fill(d, -1);
    }

    // 시작
    Q.offer(new Pair(0, 0));
    dist[0][0] = 0;
    while (!Q.isEmpty()) {
      Pair cur = Q.poll();
      for (int dir = 0; dir < 4; dir++) {
        int nx = cur.X + dx[dir];
        int ny = cur.Y + dy[dir];
        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
        if (dist[nx][ny] >= 0 || board[nx][ny] != 1) continue;
        dist[nx][ny] = dist[cur.X][cur.Y] + 1;
        Q.offer(new Pair(nx, ny));
      }
    }

    System.out.println(dist[n - 1][m - 1] + 1);
  }
}
