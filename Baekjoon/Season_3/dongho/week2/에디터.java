/*
 * ����: ���� 1406 ������
 * ����: ���� ����Ʈ
 * L - Ŀ���� �������� �� ĭ �ű� (Ŀ���� ������ �� ���̸� ���õ�)
 * D - Ŀ���� ���������� �� ĭ �ű� (Ŀ���� ������ �� ���̸� ���õ�)
 * B - Ŀ�� ���ʿ� �ִ� ���ڸ� ������ (Ŀ���� ������ �� ���̸� ���õ�)
 * P - ���ڸ� Ŀ�� ���ʿ� �߰���
 * ��, ��ɾ ����Ǳ� ���� Ŀ���� ������ �� �ڿ� ��ġ�ϰ� �ִٰ� �Ѵ�.
 * <input>
 * 1 - �ʱ⿡ �����⿡ �ԷµǾ� �ִ� ���ڿ� (N <= 100,000, ���� �ҹ���)
 * 2 - �Է��� ��ɾ��� ������ ��Ÿ���� ���� M (1 <= M <= 500,000)
 * 3~ - M���� �ٿ� ���� �Է��� ��ɾ ������� �־��� (��ɾ�� �� ���� ����)
 * <output>
 * ��� ��ɾ �����ϰ� �� �� �����⿡ �ԷµǾ� �ִ� ���ڿ� ���
 */

import java.util.Scanner;
import java.util.Arrays;

public class ������ {
  static final int size = 100001; // N <= 100,000
  static int[] data = new int[size];
  static int[] pre = new int[size];
  static int[] nxt = new int[size];
  static int unused = 1;
  public static void main(String[] args) {
    Arrays.fill(pre, -1);
    Arrays.fill(nxt, -1);
    String text = new Scanner(System.in).nextLine();
    int num = new Scanner(System.in).nextInt();
  }
}
