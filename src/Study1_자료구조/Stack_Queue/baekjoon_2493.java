package Study1_자료구조.Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 가장 먼저 만나는 단 하나의 탑에서만 수신
 * 오큰수와 비슷한 유형
 */

public class baekjoon_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        Stack<int []> stack = new Stack<>();
        for(int i = 1; i<=n; i++) {
            int current = Integer.parseInt(st.nextToken()); // 현재 탑의 높이
            while(!stack.isEmpty()) {
                if (current > stack.peek()[1]) {
                    stack.pop();
                } else {
                    sb.append(stack.peek()[0]).append(" ");
                    break;
                }
            }
            if(stack.isEmpty()) {
                sb.append(0).append(" ");
            }
            stack.push(new int[] {i, current});
        }
        System.out.println(sb);
    }

/** 나의 풀이 > 탑들의 높이를 담은 배열을 뒤집어 생각
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int[] tops = new int[n];
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            tops[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && tops[stack.peek()] <= tops[i]) {
                ans[stack.pop()] = n-i;
            }
            stack.push(i);
        }
        for(int i = n-1; i>= 0; i--) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }
 */
}
