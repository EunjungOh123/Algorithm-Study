package Study1_자료구조.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 끝내야 하는 시간이 가장 늦은 순서대로 정렬, 일은 최대한 늦게 시작
 */

public class baekjoon_1263 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Work[] works = new Work[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            works[i] = new Work(t, s);
        }
        Arrays.sort(works);
        int min = works[0].s - works[0].t; // 마지막 일을 시작하는 시간 (마지막 일을 하는 시간 -> 15 ~ 20)

        for (int i = 1; i < n; i++) {
            if (works[i].s < min) {
                min = works[i].s; // i번째 일을 마감 시간 내에 끝내야 하므로
            }
            min -= works[i].t; // 일이 걸리는 시간만큼 빼주면 i번째 일이 시작하는 시간
            if (min < 0) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(min);
    }
}

class Work implements Comparable<Work> {
    int t;
    int s;

    public Work(int t, int s) {
        this.t = t;
        this.s = s;
    }

    @Override
    public int compareTo(Work w) {
        return w.s - this.s; // 내림차순 정렬
    }
}