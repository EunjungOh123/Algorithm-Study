package Study1_자료구조.Two_Pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2018 {

    /** 배열 만들어서 풀이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];

        int ans = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }
        int start = 0; // 시작점
        int end = 0; // 끝점

        while (end <= n) {
            if(sum < n) { // 합이 n보다 작은 경우 > 부분 배열의 길이를 늘려 합을 더해주고 end 한 칸 오른쪽으로 이동
                sum += arr[end];
                end++;
            } else { // 합이 n보다 크거나 같은 경우 부분 배열의 길이를 줄여 합을 빼주고 start 한 칸 오른쪽 이동
                sum -= arr[start];
                start++;
            }
            if (sum == n) {
                ans++;
            }
        }
        System.out.println(ans);
    } */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int ans = 0;
        int sum = 1;

        int start = 1;
        int end = 1;

        while (end <= n) {
            if(sum < n) {
                end++;
                sum += end;
            } else if (sum > n){
                sum -= start;
                start++;
            } else {
                ans++;
                end++;
                sum += end;
            }
        }
        System.out.println(ans);
    }
}
