package Study1_자료구조.Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 스택 or 재귀를 활용
 * 수소 원자 하나의 질량은 1, 탄소 원자 하나의 질량은 12, 산소 원자 하나의 질량은 16
 */

public class baekjoon_2257 {

    static String str;
    static boolean[] visited = new boolean[101];
    static int tmp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        System.out.println(recursive(str, 0, str.length()));
    }

    public static int recursive(String str, int idx, int length) {
        int ans = 0;
        for (int i = idx; i < length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            if (str.charAt(i) == 'C') {
                ans += 12;
                tmp = 12;
            } else if (str.charAt(i) == 'H') {
                ans += 1;
                tmp = 1;
            } else if (str.charAt(i) == 'O') {
                ans += 16;
                tmp = 16;
            } else if (str.charAt(i) == '(') { // 재귀 시작
                ans += recursive(str, i + 1, length);
            } else if (str.charAt(i) == ')') { // 재귀 종료
                if(i+1<length && '2' <= str.charAt(i+1) && str.charAt(i+1) <= '9') {
                    visited[i + 1] = true;
                    ans *= str.charAt(i+1) -'0';
                }
                return ans;
            } else if ('2' <= str.charAt(i) && str.charAt(i) <= '9') {
                ans += (tmp * (str.charAt(i) - '0')) - tmp;
            }
        }
        return ans;
    }
}
