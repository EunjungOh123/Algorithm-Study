package Study1_자료구조.Stack_Queue.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_26042 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Queue<Integer> queue = new LinkedList<>();
        int maxCnt = 0;
        int minNum = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int type = Integer.parseInt(st.nextToken());
            if(type == 1) {
                int student = Integer.parseInt(st.nextToken());
                queue.add(student);
                if(maxCnt < queue.size()) {
                    maxCnt = queue.size();
                    minNum = student;
                } else if (maxCnt == queue.size()) {
                    minNum = Math.min(minNum, student);
                }
            } else {
                queue.poll();
            }
        }
        System.out.println(maxCnt+" "+minNum);
    }
}
