package Study1_자료구조.Stack_Queue.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon_5464 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        int [] Rs = new int[n+1]; // 주차 공간별 단위 무게당 요금
        int [] cars = new int[n+1]; // 주차 공간 배열
        int [] Wk = new int[m+1]; // 차량별 무게
        Queue<Integer> wait = new LinkedList<>(); // 대기

        for (int i = 1; i <= n; i++) {
            Rs[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i <= m; i++) {
            Wk[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;
        first: for (int i = 0; i < 2 * m; i++) {
            int car = Integer.parseInt(br.readLine());
            if(car >= 0) { // 주차
                // 빈자리 있는지 확인
                for(int j = 1; j<= n; j++) {
                    if(cars[j] == 0) { // 0인 경우 주차 공간은 빈자리
                        cars[j] = car;
                        continue first;
                    }
                }
                // 주차 공간에 빈자리 없음 -> 대기 큐에 추가
                wait.add(car);

            } else { // 주차된 차량 나감
                for(int j = 1; j<=n; j++) {
                    if(cars[j] == Math.abs(car)) {
                        cars[j] = 0; // 나가서 빈 주차 공간은 다시 0으로
                        ans += Rs[j] * Wk[Math.abs(car)]; // 주차 공간의 단위 무게당 요금 x 차량 무게
                        if(!wait.isEmpty()) { // 대기하는 차량이 있는 경우
                            cars[j] = wait.poll(); // 빈 주차 공간에 대기 차량이 들어옴
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}