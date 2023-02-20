package Study1_자료구조.Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 스택이 비어있지 않는 경우
 * 1. 스택의 맨 위에 위치한 빌딩에서 새로운 빌딩을 확인할 수 있다면 stack.peek() > buildings[i]
 * 2. 스택의 맨 위에 위치한 빌딩에서 새로운 빌딩을 확인할 수 없다면 stack.peek() <= buildings[i]
 * 확인 가능한 빌딩이 나올 때까지 높이가 낮거나 같은 빌딩은 스택에서 삭제
 */

public class baekjoon_6198 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] buildings = new int[n+1];
        for(int i = 1; i<=n; i++) {
            buildings[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> stack = new Stack<>();
        long result = 0;
        for(int i = 1; i<=n; i++) {
            while(!stack.isEmpty() && buildings[stack.peek()] <= buildings[i]) {
                stack.pop();
            }
            stack.push(i);
            result += stack.size() - 1; // 자기 자신은 제외
        }
        System.out.println(result);
    }
}
