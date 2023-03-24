package Study1_자료구조.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 버블 정렬 : 데이터의 인접 요소끼리 비교하고, swap 연산을 수행하며 정렬하는 방식
 * 오름차순 정렬
 */

public class baekjoon_23968 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        for (int i = 1; i < n; i++) {

            boolean swapped = false;

            for (int j = 0; j < n - i; j++) {
                if(arr[j] > arr[j+1]) {
                    cnt++;
                    if (cnt == k) {
                        System.out.println(arr[j+1] + " " +arr[j]);
                        return;
                    }
                    swap(arr, j, j+1);
                    swapped = true;
                }
            }
            if(!swapped) break; // 이미 정렬된 데이터인 경우
        }
        if(cnt < k) {
            System.out.println(-1);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
