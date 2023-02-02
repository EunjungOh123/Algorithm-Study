package Study1_자료구조.Array_List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * String > char [] 변환하는 방법도 있음 (문자 -> 숫자 변환: 문자 -'0')
 */

public class baekjoon_11720 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        String number = br.readLine();
        int ans = 0;
        for(int i = 0; i<cnt; i++) {
            ans += Integer.parseInt(number.substring(i, i+1));
        }
        System.out.println(ans);
    }
}
