package Study1_자료구조.Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon_1935 {

    static int[] alphabet = new int[26]; // 피연산자(A~Z의 영대문자)에 대응하는 값을 담은 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        for (int i = 0; i < n; i++) {
            alphabet[i] = Integer.parseInt(br.readLine());
        }
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            double tmp;
            if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
                stack.push(Double.valueOf(alphabet[str.charAt(i) - 'A']));
            } else if (str.charAt(i) == '*') {
                tmp = stack.pop();
                stack.push(tmp * stack.pop());
            } else if (str.charAt(i) == '+') {
                tmp = stack.pop();
                stack.push(tmp + stack.pop());
            } else if (str.charAt(i) == '/') {
                tmp = stack.pop();
                stack.push(stack.pop() / tmp);
            } else if (str.charAt(i) == '-') {
                tmp = stack.pop();
                stack.push(stack.pop() - tmp);
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}
