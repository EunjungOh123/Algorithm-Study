package Study1_자료구조.Stack_Queue;

import java.util.Stack;

/**
 * 가격이 떨어지지 않는 기간 구하기
 */

public class programmers_stock {

    public static int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) { // 가격이 떨어지는 구간
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) { // 채워지지 않은 배열의 idx = 가격이 떨어지지 않은 주식
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }
        return answer;
    }

    public static void main(String[] args)  {
        int [] arr = solution(new int[]{1, 2, 3, 2, 3});
    }
}
