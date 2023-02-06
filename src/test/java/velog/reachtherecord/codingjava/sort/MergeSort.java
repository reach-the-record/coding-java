package velog.reachtherecord.codingjava.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 병합 정렬 - 하나의 큰 문제를 두개의 작은 문제로 분할한 뒤 각자 계산하고 나중에 합치는 형태
 * 정확히 반으로 나누고 나중에 정렬
 * 이 특징이 O(N * logN)을 보장한다.
 * 2의 배수만큼 합치며, 합치는 순간에 정렬한다.
 */
public class MergeSort {
    private int[] sorted;
    public MergeSort(int n) {
        this.sorted = new int[n];
    }

    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        MergeSort m = new MergeSort(n);

        arr = m.mergeSort(arr, 0, n - 1);

        for (int i : arr) {
            bw.write(String.valueOf(i));
            bw.newLine();
        }
        bw.flush();
    }

    public int[] merge(int[] arr, int m, int middle, int n) {
        int i = m;
        int j = middle + 1;
        int k = m;

        //작은 순서대로 배열에 삽입
        while (i <= middle && j <= n) {
            if (arr[i] <= arr[j]) {
                sorted[k++] = arr[i++];
            } else {
                sorted[k++] = arr[j++];
            }
        }
        //남은 데이터 삽입
        if (i > middle) {
            for (int t = j; t <= n; t++) {
                sorted[k++] = arr[t];
            }
        } else {
            for (int t = i; t <= middle; t++) {
                sorted[k++] = arr[t];
            }
        }

        //정렬된 배열을 삽입
        for (int t = m; t <= n; t++) {
            arr[t] = sorted[t];
        }

        return arr;
    }

    public int[] mergeSort(int[] arr, int m, int n) {
        //크기가 1보다 큰 경우
        if (m < n) {
            int middle = (m + n) / 2;
            mergeSort(arr, m, middle);
            mergeSort(arr, middle + 1, n);
            arr = merge(arr, m, middle, n);

            return arr;
        }
        return arr;
    }
}
