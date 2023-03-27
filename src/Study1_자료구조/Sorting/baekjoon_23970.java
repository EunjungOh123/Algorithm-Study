package Study1_자료구조.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 버블 정렬 -> 오름차순 정렬
 */

public class baekjoon_23970 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        if (Arrays.equals(arr1, arr2)) { // 버블 정렬 실행하기 이전에 이미 배열이 동일한 경우
            System.out.println(1);
            return;
        }
        for (int i = 1; i < n; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i; j++) {
                if (arr1[j] > arr1[j + 1]) {
                    swap(arr1, j, j + 1);
                    swapped = true;
                    if (arr1[j] == arr2[j] && arr1[j + 1] == arr2[j + 1]) {
                        if (Arrays.equals(arr1, arr2)) {
                            System.out.println(1);
                            return;
                        }
                    }
                }
            }
            if (!swapped) break;
        }
        System.out.println(0);
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
