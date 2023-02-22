package Study1_자료구조.Stack_Queue.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class baekjoon_12873 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int t = 1; // 단계
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        while (queue.size() != 1) {
            long num = (long) Math.pow(t, 3);
            long r = num % queue.size();

            if (r == 0) { // 나머지가 0이 되는 경우
                r = queue.size();
            }
            for (int i = 0; i < r - 1; i++) {
                queue.add(queue.poll());
            }
            queue.poll();
            t++;
        }
        System.out.println(queue.peek());
    }
}
