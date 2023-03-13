package Study1_자료구조.Stack_Queue.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 맛의 합을 최대화
 * N일 동안 매일 두 메뉴 중 하나를 골라서 먹음 -> 메뉴를 고르지 않는 경우는 없음
 * 모든 날 1000원 짜리 메뉴를 고르는 것으로 시작
 * 5000원 메뉴와 1000원 메뉴 맛의 차가 큰 순서로 정렬
 * 정해진 금액 내에서 5000원 메뉴로 변경
 */

public class baekjoon_23559 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        PriorityQueue<Lunch> pq = new PriorityQueue<>();

        int taste = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq.add(new Lunch(a, b));
            taste += b; // n일 간 1000원 메뉴 먹을 경우 맛의 총합
        }

        int money = 1000 * n; // n일 간 1000원 메뉴 먹을 경우 총액

        while (!pq.isEmpty()) {
            Lunch lunch = pq.poll();
            if (lunch.tasteA > lunch.tasteB) {
                money += 4000;
                if (money > x) break; // 정해진 금액 초과할 경우
                taste += lunch.tasteA - lunch.tasteB;
            }
        }
        System.out.println(taste);
    }
}

class Lunch implements Comparable<Lunch> {
    int tasteA;
    int tasteB;

    public Lunch(int tasteA, int tasteB) {
        this.tasteA = tasteA;
        this.tasteB = tasteB;
    }

    @Override
    public int compareTo(Lunch r) {
        int p1 = this.tasteA - this.tasteB;
        int p2 = r.tasteA - r.tasteB;
        return p2 - p1; // 메뉴 A와 메뉴 B의 맛 차이 내림차순 정렬
    }
}