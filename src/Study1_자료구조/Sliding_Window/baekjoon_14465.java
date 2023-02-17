package Study1_자료구조.Sliding_Window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  연속한 K개의 신호등이 존재하도록 신호등을 수리
 */

public class baekjoon_14465 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        boolean [] arr = new boolean[n+1]; // 신호등 배열 > true : 고장, false: 정상
        for(int i = 0; i<b; i++) {
            arr[Integer.parseInt(br.readLine())] = true;
        }
        int min = Integer.MAX_VALUE;
        int cnt = 0;
        for(int i = 1; i<=n; i++) {
            if(arr[i] == true) {
                cnt++;
            }
            if(i == k) {
                min = cnt;
            }
            if(i >= k+1) {
                if(arr[i-k] == true) {
                    cnt--;
                }
                min = Math.min(cnt, min);
            }
        }
        System.out.println(min);
    }
}
