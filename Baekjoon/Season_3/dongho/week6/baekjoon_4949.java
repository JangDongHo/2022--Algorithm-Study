import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon_4949 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력값 받기
    Stack<Character> s = new Stack<Character>(); // 괄호쌍을 저장할 자료구조

    while (true) {
      String contents = br.readLine();
      boolean isBalance = true; // 균형을 이루고 있는지 체크
      if (contents.charAt(0) == '.') {
        break;
      }
      for (int i = 0; i < contents.length(); i++) {
        Character c = contents.charAt(i);
        if (c == '(' || c == '[') {
          s.push(c);
        } else if (c == ')') {
          // 맞는지 검사
          if (s.isEmpty()) {
            isBalance = false;
            break;
          }
          if (s.peek() == '(') {
            s.pop();
          } else {
            isBalance = false;
            break;
          }
        } else if (c == ']') {
          // 맞는지 검사
          if (s.isEmpty()) {
            isBalance = false;
            break;
          }
          if (s.peek() == '[') {
            s.pop();
          } else {
            isBalance = false;
            break;
          }
        }
      }
      // 남아있는지 검사
      if (s.size() != 0) {
        isBalance = false;
      }
      // 결과 출력
      System.out.println(isBalance ? "yes" : "no");
      s.clear();
    }
  }
}
