package Study1_자료구조.Sliding_Window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * k값의 범위 조심
 * 고정 크기의 윈도우가 좌표 크기의 최대치인 1000000보다 큰 경우 얼음들의 합 최댓값은 배열 전체의 합과 같음
 */

public class baekjoon_10025 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[1000001];
        int total = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr[x] = g;
            total += g;
        }
        int sum = 0;
        int max = 0;
        int window = 2 * k + 1;
        boolean check = false;
        if(window > 1000000) {
            System.out.println(total);
        } else {
            for (int i = 0; i <= 1000000 && window <= 1000000; i++) {
                if (i == window - 1) {
                    check = true;
                }
                if (i >= window) {
                    sum -= arr[i - window];
                }
                sum += arr[i];
                if (sum > max && check) {
                    max = sum;
                }
            }
            System.out.println(max);
        }
    }
}
