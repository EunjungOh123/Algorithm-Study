package Study1_자료구조.Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 가장 작은 수를 가장 높은 수와 같게 만들어야 함
 */

public class baekjoon_2374 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        long max = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
            max = Math.max(arr[i], max); // 배열 내 최댓값 구하기
        }
        long ans = 0;
        Stack<Long> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                stack.push(arr[i]); // stack이 비어있다면 push
            } else {
                if (stack.peek() < arr[i]) { // stack의 top보다 크면
                    ans += arr[i] - stack.pop(); // 차이만큼 더해주고
                    stack.push(arr[i]); // 새로운 값 push
                } else if (stack.peek() > arr[i]) { // stack의 top보다 작으면
                    stack.pop();
                    stack.push(arr[i]); // pop 후 새로운 값 push
                }
            }
        }
        while (!stack.isEmpty()) {
            long tmp = stack.pop();
            ans += max - tmp;
        }
        System.out.println(ans);
    }
}
