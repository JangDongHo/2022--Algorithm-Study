import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair {

  int X, Y;

  Pair(int X, int Y) {
    this.X = X;
    this.Y = Y;
  }
}

public class baekjoon10026 {

  static char[][] board;
  static boolean[][] visit;
  static Queue<Pair> Q;
  static int N;
  static int[] dx = { 1, 0, -1, 0 };
  static int[] dy = { 0, 1, 0, -1 };

  static void bfs(int x, int y) {
    visit[x][y] = true;
    Q.offer(new Pair(x, y));
    while (!Q.isEmpty()) {
      Pair cur = Q.poll();
      for (int dir = 0; dir < 4; dir++) {
        int nx = cur.X + dx[dir];
        int ny = cur.Y + dy[dir];
        if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
        if (visit[nx][ny] || board[nx][ny] != board[x][y]) continue;
        visit[nx][ny] = true;
        Q.offer(new Pair(nx, ny));
      }
    }
  }

  static int area() {
    int count = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (visit[i][j]) continue;
        bfs(i, j);
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    board = new char[N][N];
    visit = new boolean[N][N];
    Q = new LinkedList<>();
    // 배열 입력
    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      for (int j = 0; j < N; j++) {
        board[i][j] = s.charAt(j);
      }
    }
    int no_count = area(); // 정상인 카운트

    // visit 배열 false로 초기화
    for (boolean vis[] : visit) {
      Arrays.fill(vis, false);
    }
    // 적록색약이 있는 사람은 빨강과 초록을 구분하지 못하므로, 초록색을 빨강으로 변경
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (board[i][j] == 'G') {
          board[i][j] = 'R';
        }
      }
    }

    int yes_count = area(); // 색맹인 카운트

    System.out.printf("%d %d", no_count, yes_count);
  }
}
