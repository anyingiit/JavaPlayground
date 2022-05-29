package MergeSort;

public class SortByDESC {
    public static void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int l, int r) {
        // 如果是空区间或者区间内只有一个元素, 则无需处理
        if (l >= r) {
            return;
        }
        int mid = (r - l) / 2 + l;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] arrCopy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrCopy[i] = arr[i];
        }

        int i = l;
        int j = mid + 1;
        int k = l;
        while (true) {
            if (i > mid && j > r) {
                break;
            }
            if (i <= mid && j <= r) {
                if (arrCopy[i] < arrCopy[j]) {
                    arr[k] = arrCopy[i];
                    i++;
                } else {
                    arr[k] = arrCopy[j];
                    j++;
                }
            } else {
                if (j > r) {
                    arr[k] = arrCopy[i];
                    i++;
                } else {
                    arr[k] = arrCopy[j];
                    j++;
                }
            }
            k++;
        }
    }
}
