package Study1_자료구조.Stack_Queue.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Queue, PriorityQueue 모두 사용
 */

public class baekjoon_22234 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());
        int finish = Integer.parseInt(st.nextToken());

        Queue<Customer> wait = new LinkedList<>(); // 대기 큐
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int px = Integer.parseInt(st.nextToken());
            int tx = Integer.parseInt(st.nextToken());
            wait.add(new Customer(px, tx, 0)); // 0초에 대기 큐에 들어가는 손님
        }

        int m = Integer.parseInt(br.readLine());
        PriorityQueue<Customer> priorityQueue = new PriorityQueue<>(); // 우선순위 큐

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int px = Integer.parseInt(st.nextToken());
            int tx = Integer.parseInt(st.nextToken());
            int cx = Integer.parseInt(st.nextToken());
            priorityQueue.add(new Customer(px, tx, cx));
        }

        int now = 0; // 현재 시점

        while (!wait.isEmpty()) {
            Customer c1 = wait.poll();
            if (c1.tx > time) {
                for (int j = now; j < Math.min(now + time, finish); j++) {
                    sb.append(c1.id).append("\n");
                }
                now += time;
            } else {
                for (int j = now; j < Math.min(now + c1.tx, finish); j++) {
                    sb.append(c1.id).append("\n");
                }
                now += c1.tx; // 현 시점은 업무가 끝나는 데 필요한 시간만큼 더해짐
            }
            if(now > finish) break; // 현 시점이 끝나는 시점보다 커지는 순간

            while (!priorityQueue.isEmpty()) { // 추가될 요소 있는지 확인
                int cx = priorityQueue.peek().cx;
                if(cx <= now) {
                    Customer c2 = priorityQueue.poll();
                    wait.add(new Customer(c2.id, c2.tx, c2.cx));
                } else {
                    break;
                }
            }
            if(c1.tx > time) {
                // 대기 큐에 남은 시간만큼 다시 추가
                wait.add(new Customer(c1.id, c1.tx - time, c1.cx));
            }
        }
        System.out.println(sb);
    }
}

class Customer implements Comparable<Customer>{
    int id;
    int tx;
    int cx;

    public Customer(int id, int tx, int cx) {
        this.id = id;
        this.tx = tx;
        this.cx = cx;
    }

    @Override
    public int compareTo(Customer c) {
        return this.cx - c.cx; // cx 기준으로 내림차순 정렬
    }
}
