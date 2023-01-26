import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon_3986 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Stack<Character> stack = new Stack<Character>();
    int count = 0;

    int N = Integer.parseInt(br.readLine()); // 단어의 수

    while (N-- > 0) {
      String word = br.readLine();
      for (int i = 0; i < word.length(); i++) {
        Character alphabet = word.charAt(i);
        // 스택의 최상단 값과 검사하려는 값이 같을 경우 pop
        if (!stack.isEmpty() && stack.peek() == alphabet) {
          stack.pop();
        } else {
          stack.push(alphabet);
        }
      }
      if (stack.isEmpty()) {
        count++;
      }
      stack.clear();
    }
    System.out.println(count);
  }
}
