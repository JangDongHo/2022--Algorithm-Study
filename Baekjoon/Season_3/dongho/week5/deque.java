public class deque {

  static final int MX = 1_000_005;
  static int[] dat = new int[2 * MX + 1];
  static int head = MX, tail = MX;

  public static void main(String[] args) {
    push_back(30); // 30
    System.out.println(front());
    System.out.println(back());
    push_front(25); // 25 30
    push_back(12); // 25 30 12
    System.out.println(back());
    push_back(62); // 25 30 12 62
    pop_front(); // 30 12 62
    System.out.println(front());
    pop_front(); // 12 62
    System.out.println(back());
  }

  static void push_front(int x) {
    dat[--head] = x;
  }

  static void push_back(int x) {
    dat[tail++] = x;
  }

  static void pop_front() {
    head++;
  }

  static void pop_back() {
    tail--;
  }

  static int front() {
    return dat[head];
  }

  static int back() {
    return dat[tail - 1];
  }
}
