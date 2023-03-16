package Study1_자료구조.Stack_Queue.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 모든 강의들을 시작 시간 오름차순으로 정렬
 * 현재 강의의 종료 시간이 다음 강의의 시작 시간과 같거나 작다면 큐에 현재 강의 삭제 후 다음 강의 추가
 * 현재 강의의 종료 시간이 다음 강의의 시작 시간보다 크다면 강의실을 추가하고 큐에 다음 강의 추가
 */

public class baekjoon_1374 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Lecture[] lectures = new Lecture[n]; // 진행될 모든 강의들
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(start, end);
        }
        Arrays.sort(lectures); // 시작 시간 빠른 순서대로 정렬

        // 현재 진행 중인 강의를 우선순위 큐에 > 종료 시간이 빠른 순서대로
        PriorityQueue<Lecture> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.end == o2.end) {
                return o1.start - o2.start; // 종료 시간이 동일하면 시작 시간 빠른 순서대로
            }
            return o1.end - o2.end;
        });
        // 시작
        pq.add(lectures[0]);
        int roomCnt = 1;
        for (int i = 1; i < n; i++) {
            if (!pq.isEmpty()) {
                Lecture now = pq.peek();
                // 현재 진행 중인 강의의 종료 시간 <= 다음 강의 시작 시간 (강의가 서로 겹치지 않음)
                if (now.end <= lectures[i].start) {
                    pq.poll(); // 현재 진행 중인 강의는 종료
                    pq.add(lectures[i]);
                } else {
                    pq.add(lectures[i]);
                    roomCnt++; // 강의실 추가
                }
            } else {
                pq.add(lectures[i]);
            }
        }
        System.out.println(roomCnt);
    }
}

class Lecture implements Comparable<Lecture> {
    int start;
    int end;

    public Lecture(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Lecture l) {
        if (this.start == l.start) {
            return this.end - l.end; // 시작 시간이 동일하면 종료 시간 빠른 순서대로
        }
        return this.start - l.start; // 시작 시간 오름차순 정렬
    }
}