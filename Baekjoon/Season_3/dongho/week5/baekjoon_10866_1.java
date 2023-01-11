import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// Deque Interface 사용
public class baekjoon_10866_1 {

  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer command;

    Deque<Integer> q = new ArrayDeque<Integer>();
    int N = Integer.parseInt(br.readLine());

    while (N-- > 0) {
      command = new StringTokenizer(br.readLine(), " ");

      switch (command.nextToken()) {
        case "push_front" -> {
          int X = Integer.parseInt(command.nextToken());
          q.offerFirst(X);
        }
        case "push_back" -> {
          int X = Integer.parseInt(command.nextToken());
          q.offerLast(X);
        }
        case "pop_front" -> {
          Integer X = q.pollFirst();
          sbAppend(X);
        }
        case "pop_back" -> {
          Integer X = q.pollLast();
          sbAppend(X);
        }
        case "size" -> {
          sbAppend(q.size());
        }
        case "empty" -> {
          int X = q.isEmpty() ? 1 : 0;
          sbAppend(X);
        }
        case "front" -> {
          Integer X = q.peekFirst();
          sbAppend(X);
        }
        case "back" -> {
          Integer X = q.peekLast();
          sbAppend(X);
        }
      }
    }
    System.out.print(sb);
  }

  static void sbAppend(Integer X) {
    if (X == null) {
      sb.append(-1).append('\n');
    } else {
      sb.append(X).append('\n');
    }
  }
}
