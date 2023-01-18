package queue;

import java.io.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_2164 {
    public static void main(String []args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer sToken;
        Queue<Integer> queue = new LinkedList<>();

        sToken = new StringTokenizer(reader.readLine());
        int num = Integer.parseInt(sToken.nextToken());

        for(int i=1; i<=num; i++){
            queue.add(i);
        }
        while(queue.size() != 1){
            queue.poll();
            queue.add(queue.peek());
            queue.poll();
        }
        writer.write(Integer.toString(queue.peek()) + '\n');
        writer.flush();
    }
}
