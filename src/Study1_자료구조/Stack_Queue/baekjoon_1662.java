package Study1_자료구조.Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 압축되지 않은 문자열의 길이
 * '(' 앞에 위치한 숫자만큼 ( ) 안의 문자열이 반복되었다는 의미
 * ( ) 안의 문자열의 크기 구하기
 */

public class baekjoon_1662 {

    static String str;
    static int tmp;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        visited = new boolean[str.length() + 1];
        System.out.println(recursive(str, 0, str.length()));
    }

    public static int recursive(String str, int idx, int length) {
        int ans = 0;
        for (int i = idx; i < length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            if ('0' <= str.charAt(i) && str.charAt(i) <= '9' && i + 1 < length && str.charAt(i + 1) == '(') {
                tmp = str.charAt(i) - '0';
            } else if (str.charAt(i) == '(') { // 재귀 시작
                ans += tmp * recursive(str, i + 1, length);
            } else if ('0' <= str.charAt(i) && str.charAt(i) <= '9') {
                ans++;
            } else if (str.charAt(i) == ')') { // 재귀 종료
                return ans;
            }
        }
        return ans;
    }
}
