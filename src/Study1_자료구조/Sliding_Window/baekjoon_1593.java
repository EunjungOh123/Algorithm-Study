package Study1_자료구조.Sliding_Window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1593 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int wLength = Integer.parseInt(st.nextToken());
        int sLength = Integer.parseInt(st.nextToken());
        String w = br.readLine();
        String s = br.readLine();

        // 알파벳 대문자 26개 + 소문자 26개 + 기타 특수문자 6개 (아스키 코드 활용)
        int[] alphabet = new int[58];

        // alphabet[c-'A']++, alphabet[A-'A']++, alphabet[d-'A']++, alphabet[a-'A']++
        for (int i = 0; i < wLength; i++) {
            alphabet[w.charAt(i) - 'A']++;
        }

        int cnt = 0;
        boolean check = true;

        for (int i = 0; i < sLength; i++) {
            alphabet[s.charAt(i) - 'A']--;
            if (i == wLength - 1) {
                for (int j = 0; j < alphabet.length; j++) {
                    if (alphabet[j] != 0) { // 배열 내의 모든 값이 0이 아니라면 s 안에 w의 순열 존재하지 않음
                        check = false;
                        break;
                    }
                    check = true;
                }
                if(check) cnt++; // 배열 내 모든 값이 0이 되는 경우 개수 증가
            }
            if (i >= wLength) {
                alphabet[s.charAt(i - wLength) - 'A']++;
                for (int j = 0; j < alphabet.length; j++) {
                    if (alphabet[j] != 0) { // 배열 내의 모든 값이 0이 아니라면 s 안에 w의 순열 존재하지 않음
                        check = false;
                        break;
                    }
                    check = true;
                }
                if(check) cnt++; // 배열 내 모든 값이 0이 되는 경우 개수 증가
            }
        }
        System.out.println(cnt);
    }
}
