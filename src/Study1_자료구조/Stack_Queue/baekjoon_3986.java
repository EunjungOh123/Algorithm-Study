package Study1_자료구조.Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * stack 비어있다면 push
 * stack 비어있지 않은 경우
 * -> stack의 맨 위에 있는 문자가 넣고자 하는 문자와 동일하다면 pop
 * -> stack의 맨 위에 있는 문자가 넣고자 하는 문자와 다르다면 push
 * stack 비어있다면 좋은 문자가 된다
 */

public class baekjoon_3986 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < str.length(); j++) {
                if(stack.isEmpty()) {
                    stack.push(str.charAt(j));
                } else {
                    if(stack.peek() == str.charAt(j)) {
                        stack.pop();
                    } else {
                        stack.push(str.charAt(j));
                    }
                }
            }
            if (stack.isEmpty()) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
