package Study1_자료구조.Sliding_Window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 슬라이딩 윈도우 vs 투 포인터 : 부분 배열 길이의 변화 여부 차이
 * 슬라이딩 윈도우는 부분 배열의 길이가 고정적이므로 하나의 포인터만 사용
 */

public class baekjoon_21921 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int max = 0;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (i == x - 1) {
                max = sum;
                cnt = 1;
            }
            if (i >= x) {
                sum -= arr[i - x];
                if(sum > max) {
                    max = sum;
                    cnt = 1;
                } else if (sum == max) {
                    cnt++;
                }
            }
        }
        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(cnt);
        }
    }
}
