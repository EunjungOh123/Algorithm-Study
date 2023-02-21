package Study1_자료구조.Stack_Queue.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_1966 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < test; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");

            Queue<Integer> queue = new LinkedList<>();
            Queue<Integer> idxQueue = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                queue.add(Integer.parseInt(st.nextToken()));
                idxQueue.add(j);
            }

            int cnt = 1;

            while (!queue.isEmpty()) {
                int max = Collections.max(queue);
                int cur = queue.poll();
                int curIdx = idxQueue.poll();

                if(cur == max) { // 인쇄가 가능한 경우
                    if(curIdx == m) { // 찾는 문서를 인쇄했다면
                        sb.append(cnt).append("\n");
                        break;
                    }
                    cnt++;
                } else { // 인쇄 불가능하면 다시 맨 뒤에 넣어줌
                    queue.add(cur);
                    idxQueue.add(curIdx);
                }
            }
        }
        System.out.println(sb);
    }
}
