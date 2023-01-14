import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class baekjoon_5430 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    LinkedList<Integer> q = new LinkedList<Integer>();
    String p; // 수행할 함수
    StringTokenizer array; // 배열
    StringBuilder output = new StringBuilder(); // 출력값

    int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수

    while (T-- > 0) {
      Boolean isReverse = false;
      Boolean isError = false;
      p = br.readLine();
      int n = Integer.parseInt(br.readLine()); // 배열에 들어있는 수의 개수
      array = new StringTokenizer(br.readLine(), "[],");

      while (array.hasMoreTokens()) {
        q.offer(Integer.parseInt(array.nextToken()));
      }

      for (int i = 0; i < p.length(); i++) {
        char command = p.charAt(i);
        if (command == 'R') {
          isReverse = !isReverse;
        }
        if (command == 'D') {
          if (isReverse) {
            if (q.pollLast() == null) {
              isError = true;
              break;
            }
          } else {
            if (q.pollFirst() == null) {
              isError = true;
              break;
            }
          }
        }
      }

      if (isError) {
        output.append("error").append('\n');
      } else {
        output.append("[");
        while (!q.isEmpty()) {
          output.append(isReverse ? q.pollLast() : q.pollFirst());
          if (q.size() != 0) {
            output.append(",");
          }
        }
        output.append("]").append('\n');
      }
    }
    System.out.println(output);
  }
}
