package velog.reachtherecord.codingjava.sort;

/**
 * 선택 정렬 - 선택한 숫자와 바로 뒤 숫자와 비교하여 스와핑 실행
 * 시간복잡도 - O(N^2)
 * 10 + 9 + 8 + ... + 1 => 10 * (10 + 1) / 2 = 55
 * => N * (N + 1) / 2
 * 시간복잡도에서 상수는 무시 > O(N * N) > O(N^2)
 */
public class SelectionSort {
    public static void main(String[] args) {
        SelectionSort s = new SelectionSort();
        int[] arr = s.sort(new int[] {3,5,2,6,7,9,1,10,4,8});

        for (int i : arr) {
            System.out.println("i = " + i);
        }
    }

    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            int min = Integer.MAX_VALUE;
            for (int j = i; j < arr.length; j++) {  //가장 앞의 값부터 비교해서 순차적으로 최소값을 찾아 스와핑
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }

        return arr;
    }
}
