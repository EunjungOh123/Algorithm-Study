package Study1_배열과리스트.Two_Pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 다른 문자가 나올 경우, 왼쪽을 제거하고 유사 회문 여부 체크 or 오른쪽을 제거하고 유사 회문 여부 체크
 */

public class baekjoon_17609 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            char[] charArr = word.toCharArray();
            int start = 0;
            int end = charArr.length - 1;
            int tmp = 0;
            int ans = 0;
            while (start <= end) {
                if (charArr[start] == charArr[end]) { // 양쪽 문자가 일치할 경우
                    start++;
                    end--;
                } else {
                    tmp = 1;
                    // 오른쪽 무시
                    int left = start;
                    int right = end - 1;
                    while (left <= right) {
                        if (charArr[left] == charArr[right]) {
                            left++;
                            right--;
                        } else { // 유사회문 불가능
                            tmp++;
                            break;
                        }
                    }
                    // 왼쪽 무시
                    left = start + 1;
                    right = end;
                    while (left <= right) {
                        if (charArr[left] == charArr[right]) {
                            left++;
                            right--;
                        } else { // 유사회문 불가능
                            tmp++;
                            break;
                        }
                    }
                    if(tmp >= 2) {
                        ans = tmp-1;
                    } else {
                        ans = tmp;
                    }
                    break;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
