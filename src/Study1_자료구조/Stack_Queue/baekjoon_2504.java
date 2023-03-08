package Study1_자료구조.Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 분배 법칙의 원리를 이용
 * ( ( ) [ [ ] ] )
 * -> 2 x (2 + 3 x 3) = (2 x 2) + (2 x 3 x 3)
 * -> 위의 식은 ( ( ) ) ( [ [ ] ] ) 괄호식으로 표현할 수 있음
 */

public class baekjoon_2504 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        int tmp = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {

                stack.push('(');
                tmp *= 2;

            } else if (str.charAt(i) == '[') {

                stack.push('[');
                tmp *= 3;

            } else if (str.charAt(i) == ')') {
                if (stack.isEmpty() || stack.peek() != '(') { // 올바르지 못한 괄호열
                    ans = 0;
                    break;
                } else if (str.charAt(i - 1) == '(') {
                    ans += tmp;
                }
                tmp /= 2;
                stack.pop();
            } else if (str.charAt(i) == ']') {
                if (stack.isEmpty() || stack.peek() != '[') { // 올바르지 못한 괄호열
                    ans = 0;
                    break;
                } else if (str.charAt(i - 1) == '[') {
                    ans += tmp;
                }
                tmp /= 3;
                stack.pop();
            }
        }
        ans = stack.isEmpty() ? ans : 0;
        System.out.println(ans);
    }
}
