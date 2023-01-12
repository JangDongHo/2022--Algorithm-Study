import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class baekjoon_1021 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    LinkedList<Integer> q = new LinkedList<Integer>();

    st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int count = 0;

    for (int i = 1; i <= N; i++) {
      q.offer(i);
    }

    st = new StringTokenizer(br.readLine(), " ");
    while (M-- > 0) {
      int X = Integer.parseInt(st.nextToken());
      int X_idx = q.indexOf(X);
      // 2번 연산 수행
      if (X_idx <= N / 2) {
        for (int i = 0; i < X_idx; i++) {
          System.out.println(X_idx);
          q.offerLast(q.pollFirst());
          count++;
        }
      }
      // 3번 연산 수행
      else {
        for (int i = 0; i < N - X_idx; i++) {
          q.offerFirst(q.pollLast());
          count++;
        }
      }
      // 1번 연산 수행
      q.pollFirst();
    }
    System.out.print(count);
  }
}
