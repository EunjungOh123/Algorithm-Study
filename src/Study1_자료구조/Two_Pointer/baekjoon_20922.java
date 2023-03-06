package Study1_자료구조.Two_Pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 같은 원소가 K개 이하로 들어 있는 최장 연속 부분 수열의 길이
 */

public class baekjoon_20922 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] cnt = new int[100001]; // 배열의 인덱스에 해당되는 숫자의 개수를 담아줄 배열
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int max = Integer.MIN_VALUE;

        while (end < n) {
            if (cnt[arr[end]] < k) {
                cnt[arr[end]]++;
                end++;
                max = Math.max(max, end - start);
            } else {
                cnt[arr[start]]--;
                start++;
            }
        }
        System.out.println(max);
    }
}
