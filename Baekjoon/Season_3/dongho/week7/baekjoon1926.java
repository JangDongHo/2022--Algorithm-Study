import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

public class baekjoon1926 {

  static int n, m;
  static int[][] board;
  static boolean[][] vis;
  static int[] dx, dy;
  static Queue<Pair> Q;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    board = new int[n][m];
    vis = new boolean[n][m];
    Q = new LinkedList<>();

    dx = new int[] { 1, 0, -1, 0 };
    dy = new int[] { 0, 1, 0, -1 };
    // 배열 값 세팅
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // 시작
    int count = 0; // 그림의 개수
    int area = 0; // 넓이
    int maxArea = 0; // 최대 넓이
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        // 0이거나 방문한 적이 없으면 생략
        if (board[i][j] == 0 || vis[i][j]) {
          continue;
        }
        count++;
        Q.offer(new Pair(i, j));
        vis[i][j] = true;
        area = 0;
        while (!Q.isEmpty()) {
          Pair cur = Q.poll();
          area++; // 넓이 1 증가
          for (int dir = 0; dir < 4; dir++) {
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if (board[nx][ny] != 1 || vis[nx][ny]) continue;
            vis[nx][ny] = true;
            Q.offer(new Pair(nx, ny));
          }
        }
        if (area > maxArea) {
          maxArea = area;
        }
      }
    }

    System.out.println(count);
    System.out.println(maxArea);
  }
}
