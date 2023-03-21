package Study1_자료구조.Stack_Queue.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon_13975 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < test; i++) {
            int k = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            int[] files = new int[k];
            PriorityQueue<Long> pq = new PriorityQueue<>(); // 오름차순 정렬

            for (int j = 0; j < k; j++) {
                files[j] = Integer.parseInt(st.nextToken());
                pq.add((long) files[j]);
            }
            Arrays.sort(files); // 오름차순 정렬

            long ans = 0;
            while (!pq.isEmpty()) {
                if (pq.size() == 1)
                    break;
                long a = pq.poll();
                long b = pq.poll();
                ans += a + b;
                pq.add(a + b);
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
