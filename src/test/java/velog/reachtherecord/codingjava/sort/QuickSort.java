package velog.reachtherecord.codingjava.sort;

import java.util.Arrays;

/**
 * 퀵 정렬 - 대표적인 빠른 알고리즘. 평균 시간 복잡도 O(N * logN)
 * 대표적인 분할 정복 알고리즘.
 * 피벗을 기준으로 두개의 군으로 분할하여 정렬한다.
 * 최악의 시간 복잡도는 O(N^2). (거의 정렬이 되어있는 경우)
 * 정렬할 데이터의 특성에 따라 적절한 알고리즘을 사용해야 한다.
 */
public class QuickSort {
    public static void main(String[] args) {
        QuickSort s = new QuickSort();
        int[] arr = s.sort(new int[]{9,2,6,4,5,1,8,7,10,3});
        for (int i : arr) {
            System.out.println("i = " + i);
        }
        arr = s.reverseOrder(arr);
        for (int i : arr) {
            System.out.println("i = " + i);
        }
    }

    public int[] sort(int[] arr) {
        return this.quickSort(arr, 0, arr.length - 1);
    }
    public int[] reverseOrder(int[] arr) {
        return this.reverseQuick(arr, 0, arr.length - 1);
    }

    private int[] quickSort(int[] arr, int start, int end) {
        int pivot = start;  //첫 시작점을 피벗으로 설정
        int i = start + 1;  //피벗을 제외하고 시작
        int j = end;
        int tmp;

        if (start >= end) { //시작 인덱스가 끝과 같거나 클 경우 (1개) 메서드를 종료한다.
            return arr;
        }

        while (i <= j) {    //시작 인덱스가 끝 인덱스보다 커질 때까지 반복
            while (i <= end && arr[i] <= arr[pivot]) {  //인덱스가 끝 인덱스보다 작으면서 인덱스값이 피벗 값보다 작으면 다음 인덱스로 이동
                i++;
            }

            while (j > start && arr[j] >= arr[pivot]) { //끝부터 조회하여 끝 인덱스가 시작 인덱스보다 크면서 피벗값보다 크거나 같으면 이전 인덱스로 이동
                j--;
            }
            if (i > j) {    // i가 j보다 클 경우 (엇갈릴 경우) 끝 인덱스 값과 피벗 값을 스와핑
                tmp = arr[j];
                arr[j] = arr[pivot];
                arr[pivot] = tmp;
            } else {    // 엇갈리지 않았을 경우에 i 인덱스 값과 j 인덱스 값을 스와핑
                tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }

        quickSort(arr, start, j - 1);   //재귀 호출로 정렬 시작점부터 j 인덱스 전까지 다시 정렬 처리
        quickSort(arr, j + 1, end);     //재귀 호출로 정렬 j 다음 인덱스부터 끝까지 다시 정렬 처리

        return arr;
    }

    private int[] reverseQuick(int[] arr, int start, int end) {
        int pivot = start;
        int i = start + 1;
        int j = end;
        int tmp;

        if (start >= end) {
            return arr;
        }

        while (i <= j) {
            while (i <= end && arr[i] >= arr[pivot]) {  //오름차순 정렬과 비교만 반대로 변경
                i++;
            }
            while (arr[j] <= arr[pivot] && j > start) { //오름차순 정렬과 비교만 반대로 변경
                j--;
            }
            if (i > j) {
                tmp = arr[j];
                arr[j] = arr[pivot];
                arr[pivot] = tmp;
            } else {
                tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }

        reverseQuick(arr, start, j - 1);
        reverseQuick(arr, j + 1, end);

        return arr;
    }
}
