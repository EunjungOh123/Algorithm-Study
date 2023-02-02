package Study1_자료구조.Two_Pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 숫자 타입 주의 (int, long)
 */

public class baekjoon_14246 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int k = Integer.parseInt(br.readLine());

        int start = 0;
        int end = 0;
        long sum = 0;
        long cnt = 0;

        while (end <= n) {
            if (sum <= k) {
                sum += arr[end];
                end++;
            } else {
                /**
                 * ex) arr = {1,2,3,2,1} & k=5
                 * {1,2,3}의 합이 k보다 커졌으므로 {1,2,3,2}의 합 / {1,2,3,2,1}의 합도 k보다 큼
                 * 배열 내 모든 숫자는 자연수이기 때문...
                 */
                cnt += n-end+1;
                sum -= arr[start];
                start++;
            }
        }
        System.out.println(cnt);
    }
}
