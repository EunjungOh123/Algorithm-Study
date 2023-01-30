package Study1_배열과리스트.Prefix_Sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_11660 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [][] sumArr = new int[n+1][n+1];

        for(int i = 1; i<=n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j<=n; j++) {
                sumArr[i][j] = sumArr[i][j-1] + Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i<m; i++) {
            long ans = 0;
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int j = x1; j <= x2; j++) {
                ans += sumArr[j][y2] - sumArr[j][y1-1];
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
