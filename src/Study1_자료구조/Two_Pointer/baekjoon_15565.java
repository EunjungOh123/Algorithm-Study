package Study1_자료구조.Two_Pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1: 라이언
 * 2: 어피치
 * K개 이상의 라이언 인형을 포함하는 가장 작은 연속된 인형들의 집합의 크기
 */

public class baekjoon_15565 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        int cnt = 0;
        while (end <= n) {

            if(cnt >= k) {
                min = Math.min (min, end-start);
                if(arr[start] == 1) {
                    cnt--;
                }
                start++;
            }
            if(cnt < k) {
                if(arr[end] == 1) {
                    cnt++;
                }
                end++;
            }
        }
        if(min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }
}
