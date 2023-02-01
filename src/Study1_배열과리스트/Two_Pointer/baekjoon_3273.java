package Study1_배열과리스트.Two_Pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 구간 합
 */
public class baekjoon_3273 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        int start = 0;
        int end = n-1;
        int cnt = 0;
        while (start < end) {
            int sum = arr[start] + arr[end];
            if(sum == x) {
                cnt++;
            }
            if(sum < x) {
                start++;
            } else {
                end--;
            }
        }
        System.out.println(cnt);
    }
}
