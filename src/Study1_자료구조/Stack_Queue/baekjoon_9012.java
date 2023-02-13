package Study1_자료구조.Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon_9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<n; i++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean check = true;
            for(int j = 0; j<str.length(); j++) {
                if(str.charAt(j) == '(') {
                    stack.push(str.charAt(j));
                } else if (str.charAt(j) == ')') {
                    if(stack.isEmpty()) {
                        check = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if(!stack.isEmpty() || !check) {
                sb.append("NO").append("\n");
            } else if (stack.isEmpty()){
                sb.append("YES").append("\n");
            }
        }
        System.out.println(sb);
    }
}