package Study1_자료구조.Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 좌측 방향과 우측 방향 모두 확인
 */

public class baekjoon_2304 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] storages = new int[1001];
        int start = Integer.MAX_VALUE; // 가장 작은 인덱스
        int end = 0; // 가장 큰 인덱스

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int idx = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            storages[idx] = height;
            start = Math.min(start, idx);
            end = Math.max(end, idx);
        }

        Stack<Integer> stack = new Stack<>();
        // 왼쪽부터
        int tmp = storages[start]; // 창고의 최대 높이
        for (int i = start + 1; i <= end; i++) {
            if (storages[i] < tmp) { // 현재 높이가 창고의 최대 높이보다 작은 경우
                stack.push(i);
            } else { // 현재 높이가 창고의 최대 높이보다 크거나 같은 경우
                while (!stack.isEmpty()) {
                    storages[stack.pop()] = tmp;
                }
                tmp = storages[i]; // 최대 높이를 갱신
            }
        }
        stack.clear();
        // 오른쪽부터
        tmp = storages[end];
        for (int i = end - 1; i >= start; i--) {
            if (storages[i] < tmp) {
                stack.push(i);
            } else {
                while (!stack.isEmpty()) {
                    storages[stack.pop()] = tmp;
                }
                tmp = storages[i];
            }
        }
        int result = 0;
        for (int i = start; i <= end; i++) {
            result += storages[i];
        }
        System.out.println(result);
    }
}