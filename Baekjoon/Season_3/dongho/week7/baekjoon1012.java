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

public class baekjoon1012 {

  static int[][] board; // 땅
  static boolean[][] visit; // 방문 여부 저장
  static Queue<Pair> Q;
  static int[] dx, dy;
  static int M, N, K;

  static void bfs(int x, int y) {
    visit[x][y] = true;
    Q.offer(new Pair(x, y));
    while (!Q.isEmpty()) {
      Pair cur = Q.poll();
      for (int dir = 0; dir < 4; dir++) {
        int nx = cur.X + dx[dir];
        int ny = cur.Y + dy[dir];
        if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
        if (board[nx][ny] == 0 || visit[nx][ny]) continue;
        visit[nx][ny] = true;
        Q.offer(new Pair(nx, ny));
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
    Q = new LinkedList<>();
    dx = new int[] { 1, 0, -1, 0 };
    dy = new int[] { 0, 1, 0, -1 };
    StringTokenizer st;

    // 테스트 케이스만큼 반복
    for (int i = 0; i < T; i++) {
      st = new StringTokenizer(br.readLine());
      M = Integer.parseInt(st.nextToken()); // 배추밭의 가로길이
      N = Integer.parseInt(st.nextToken()); // 배추밭의 세로길이
      K = Integer.parseInt(st.nextToken()); // 배추가 심어져 있는 위치의 개수
      // 배열 초기화
      board = new int[N][M];
      visit = new boolean[N][M];
      for (int j = 0; j < K; j++) {
        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        board[Y][X] = 1;
      }
      // bfs 시작
      int count = 0; // 배추흰지렁이 마리 수
      for (int k = 0; k < N; k++) {
        for (int l = 0; l < M; l++) {
          if (board[k][l] == 0 || visit[k][l]) continue;
          bfs(k, l);
          count++;
        }
      }
      System.out.println(count);
    }
  }
}
