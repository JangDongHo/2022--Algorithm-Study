import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class baekjoon_11003 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력값 받기
    StringTokenizer st; // 입력값 토큰화
    StringBuilder sb = new StringBuilder(); // 출력값 받기
    int min; // 최솟값 저장
    Deque<Integer> q = new LinkedList<Integer>(); // 덱큐

    st = new StringTokenizer(br.readLine()); // 첫째 줄 입력값 받기
    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());
    int start = 2 - L;

    st = new StringTokenizer(br.readLine()); // 둘째 줄 입력값 받기
    while (st.hasMoreTokens()) {
      // i ≤ 0 인 A_i는 무시
      if (start > 0) {
        q.pollFirst();
      }
    }
  }
}
