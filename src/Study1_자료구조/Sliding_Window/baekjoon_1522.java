package Study1_자료구조.Sliding_Window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * a를 모두 연속으로 만들기
 * 문자열의 시작부분과 끝부분이 이어져있음
 */

public class baekjoon_1522 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] arr = new char[2 * str.length() - 1];
        int window = 0; // 윈도우 길이 = 입력 받은 문자열에 포함된 'b'의 개수

        for (int i = 0; i <str.length(); i++) {
            arr[i] = str.charAt(i);
            if (arr[i] == 'b') {
                window++;
            }
        }
        for(int i = str.length(); i<arr.length; i++) {
            arr[i] = arr[i-str.length()];
        }
        int cnt = 0; // 배열 내 'a'의 개수
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'a') {
                cnt++;
            }
            if (i == window - 1) {
                min = cnt;
            }
            if (i >= window) {
                if (arr[i - window] == 'a') {
                    cnt--;
                }
                min = Math.min(cnt, min);
            }
        }
        System.out.println(min);
    }
}
