package Study1_자료구조.Stack_Queue.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_13335 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Queue<Integer> bridge = new LinkedList<>(); // 다리에 대한 큐
        Queue<Integer> truck = new LinkedList<>(); // 트럭에 대한 큐

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            truck.add(Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < w; i++) {
            bridge.add(0); // 다리 길이만큼
        }
        int sum = 0; // 다리 위에 올라간 트럭의 합
        int time = 0;
        while(!bridge.isEmpty()) {
            time++;
            sum -= bridge.poll();
            if(!truck.isEmpty()) {
                if(sum + truck.peek() <= l) {
                    sum += truck.peek();
                    bridge.add(truck.poll());
                } else {
                    bridge.add(0);
                }
            }
        }
        System.out.println(time);
    }
}
