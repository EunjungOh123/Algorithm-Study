package Study1_자료구조.Stack_Queue.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon_23843 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Integer[] time = new Integer[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(time, Collections.reverseOrder()); // 충전 시간 내림차순 정렬

        PriorityQueue<Integer> socket = new PriorityQueue<>(); // 충전 시간 오름차순 정렬

        int idx = 0;
        // 콘센트의 개수만큼 가장 높은 충전 시간을 가진 전자기기 충전
        for(int i = 0; i<m; i++) {
            socket.add(time[idx++]);
            if(idx == n) { // 전자기기의 개수가 콘센트의 개수보다 적은 경우
                break;
            }
        }
        for(int i = idx; i<n; i++) {
            // 현재까지 누적 충전 시간이 가장 적은 콘센트에 남은 전자기기 중 가장 높은 충전 시간을 가진 것을 충전
            int tmp = socket.peek() + time[i];
            socket.poll();
            socket.add(tmp);
        }
        int ans = 0;
        while(!socket.isEmpty()) {
            ans = Math.max(ans, socket.poll());
        }
        System.out.println(ans);
    }
}
