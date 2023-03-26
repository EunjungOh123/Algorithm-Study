package Study1_자료구조.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 버블 정렬 -> 오름차순 정렬
 */

public class baekjoon_23969 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    cnt++;
                    swap(arr, j, j + 1);
                    swapped = true;
                }
                if (cnt == k) {
                    for (int h : arr) {
                        sb.append(h).append(" ");
                    }
                    System.out.println(sb);
                    return;
                }
            }
            if (!swapped) break;
        }
        if (cnt < k) {
            System.out.println(-1);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
