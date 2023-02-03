package velog.reachtherecord.codingjava.sort;

/**
 * 삽입 정렬 - 버블정렬, 선택정렬과 시간복잡도는 같음. O(N^2)
 * 각 숫자를 적절한 위치에 삽입하는 방법으로 정렬하는 방식
 * 선택, 버블 정렬과 다르게 필요할 때만 위치를 바꿈
 * 삽입 정렬은 기본적으로 정렬이 되어있다고 가정하고 정렬을 시작하므로,
 * 특정한 경우에 따라 굉장히 빠른 속도로 정렬이 가능.
 */
public class InsertionSort {

    public static void main(String[] args) {
        InsertionSort s = new InsertionSort();
        int[] arr = s.sort(new int[] {9, 3, 4, 8, 6, 7, 1, 2, 10, 5});

        for (int i : arr) {
            System.out.println("i = " + i);
        }
    }
    public int[] sort(int[] arr) {
        int idx;
        for (int i = 0; i < arr.length - 1; i++) {  //첫 인덱스 부터 마지막 인덱스 전까지 반복
            idx = i;
            while (idx >= 0 && arr[idx] > arr[idx + 1]) {   //인덱스의 값이 0 이상이고 인덱스 값이 다음 인덱스 값보다 작아질 때 까지 반복하여 스와핑
                int tmp = arr[idx];
                arr[idx] = arr[idx + 1];
                arr[idx + 1] = tmp;
                idx--;
            }
        }

        return arr;
    }
}
