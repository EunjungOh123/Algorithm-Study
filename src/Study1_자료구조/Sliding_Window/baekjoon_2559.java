package Study1_자료구조.Sliding_Window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2559 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int [] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        int max = 0;
        for(int i = 0; i<n; i++) {
            sum += arr[i];
            if(i == k-1) {
                max = sum;
            }
            if(i >= k) {
                sum -= arr[i-k];
                max = Math.max(max, sum);
            }
        }
        System.out.println(max);
    }
}
