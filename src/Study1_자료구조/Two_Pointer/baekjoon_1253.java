package Study1_자료구조.Two_Pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 수의 위치가 다르면 값이 같아도 다른 수
 */

public class baekjoon_1253 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int start = 0;
            int end = n - 1;
            while (start < end) {
                int sum = arr[start] + arr[end];
                if (sum == arr[i]) {
                    if(i == start) {
                        start++;
                    } else if (i == end) {
                        end--;
                    } else { // i != start && i != end
                        cnt++;
                        break;
                    }
                }
                if (sum < arr[i]) { // 합을 늘려야 한다
                    start++;
                } else if (sum > arr[i]) { // 합을 줄여야 한다
                    end--;
                }
            }
        }
        System.out.println(cnt);
    }
}
