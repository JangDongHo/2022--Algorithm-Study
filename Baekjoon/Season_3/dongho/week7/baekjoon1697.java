import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon1697 {

  static int[] dist;
  static int[] moves;
  static Queue<Integer> Q;
  static int MAX_SIZE = 100_001;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    dist = new int[MAX_SIZE]; // 수빈이와 동생이 이동하거나 서있을 수 있는 자리
    Q = new LinkedList<>();
    // 배열 초기화
    Arrays.fill(dist, -1); // 배열 -1로 초기화
    Q.offer(N);
    dist[N] = 0;
    // 시작
    while (dist[K] == -1) {
      int cur = Q.poll();
      moves = new int[] { cur + 1, cur - 1, cur * 2 }; // 수빈이가 이동할 수 있는 거리

      for (int move : moves) {
        if (move < 0 || move >= MAX_SIZE) continue; // 범위 체크
        if (dist[move] != -1) continue; // 방문 체크
        dist[move] = dist[cur] + 1;
        Q.offer(move);
      }
      System.out.println(Arrays.toString(dist));
    }
    System.out.println(dist[K]);
  }
}
