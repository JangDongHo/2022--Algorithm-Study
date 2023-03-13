import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon_10799 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    Stack<Character> s = new Stack<Character>();
    int count = 0;

    for (int i = 0; i < input.length(); i++) {
      Character c = input.charAt(i);
      if (c == '(') {
        s.push(c);
      } else if (c == ')') {
        Character c_front = input.charAt(i - 1);
        s.pop();
        if (c_front == '(') {
          count += s.size();
        } else if (c_front == ')') {
          count++;
        }
      }
    }

    System.out.println(count);
  }
}
