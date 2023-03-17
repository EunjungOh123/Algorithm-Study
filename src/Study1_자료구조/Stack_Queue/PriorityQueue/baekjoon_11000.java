package Study1_자료구조.Stack_Queue.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon_11000 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Lesson[] lessons = new Lesson[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            lessons[i] = new Lesson(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        // 시작 시간 빠른 순서대로 정렬
        Arrays.sort(lessons, (l1, l2) -> {
            if (l1.start == l2.start) {
                return l1.end - l2.end;
            }
            return l1.start - l2.start;
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 끝나는 시간 빠른 순서대로 정렬
        pq.add(lessons[0].end);

        for (int i = 1; i < n; i++) {
            if (lessons[i].start >= pq.peek()) {
                pq.poll();
            }
            pq.add(lessons[i].end);
        }
        System.out.println(pq.size());
    }
}

class Lesson {
    int start;
    int end;

    public Lesson(int start, int end) {
        this.start = start;
        this.end = end;
    }
}