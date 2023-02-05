package velog.reachtherecord.codingjava.sort;

/**
 * 버블정렬 - 옆에 있는 값과 비교하여 더 작은 값을 반복적으로 앞으로 보내는 정렬
 * 구현 난이도 - 낮음, 효율 - 가장 떨어짐
 *
 */
public class BubbleSort {

    public static void main(String[] args) {
        BubbleSort s = new BubbleSort();
        int[] arr = s.sort(new int[]{1, 10, 2, 4, 6, 7, 3, 9, 5, 8});

        for (int i : arr) {
            System.out.println("i = " + i);
        }
    }


    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {//뒷 값과 비교하기 위해 최대 length - 1까지 반복
                if (arr[j] > arr[j + 1]) {  //j번이 다음 인덱스값보다 클 경우 다음 인덱스 값과 스와핑
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

        return arr;
    }
}
