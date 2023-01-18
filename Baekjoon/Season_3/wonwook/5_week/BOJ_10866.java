package deque;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10866 {
    public static void main(String []args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer sToken;
        sToken = new StringTokenizer(reader.readLine());
        int command = Integer.parseInt(sToken.nextToken());
        int arr[] = new int[2*command+1];
        int head, tail, size, totalSize;
        head = command;
        tail = command;
        totalSize = 2*command+1;
        size = tail-head;
        for(int i=0; i<totalSize; i++) {
            arr[i] = -1;
        }

        for(int i=0; i<command; i++){
            sToken = new StringTokenizer(reader.readLine());
            String str = sToken.nextToken();
            int num;
            switch(str){
                case "push_front":
                    num = Integer.parseInt(sToken.nextToken());
                    arr[--head] = num;
                    size = tail-head;
                    break;
                case "push_back":
                    num = Integer.parseInt(sToken.nextToken());
                    arr[tail++] = num;
                    size = tail-head;
                    break;
                case "pop_front":
                    if(size <= 0) writer.write(-1 + "\n");
                    else {
                        writer.write(arr[head] + "\n");
                        arr[head++] = -1;
                    }
                    size = tail-head;
                    break;
                case "pop_back":
                    if(size <= 0) writer.write(-1 + "\n");
                    else {
                        writer.write(arr[--tail] + "\n");
                        arr[tail] = -1;
                    }
                    size = tail-head;
                    break;
                case "size":
                    writer.write(size + "\n");
                    break;
                case "empty":
                    if(size == 0) writer.write(1 + "\n");
                    else writer.write(0 + "\n");
                    break;
                case "front":
                    if(size <= 0) writer.write(-1 + "\n");
                    else {
                        writer.write(arr[head] + "\n");
                    }
                    break;
                case "back":
                    if(size <= 0) writer.write(-1 + "\n");
                    else {
                        writer.write(arr[tail-1] + "\n");
                    }
                    break;
            }
        }
        writer.flush();
    }
}