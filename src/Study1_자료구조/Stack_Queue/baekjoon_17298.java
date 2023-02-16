package Study1_자료구조.Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 스택에 새로 들어오는 수가 stack.peek()보다 크면 그 수는 오큰수가 됨
 * 배열의 인덱스를 활용
 */

public class baekjoon_17298 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int [] arr = new int[n];
        int [] ans = new int[n];
        for(int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                ans[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }

        for(int i : ans) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
