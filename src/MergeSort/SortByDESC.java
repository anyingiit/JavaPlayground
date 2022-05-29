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
        int[] arrCopy = new int[r - l + 1];
        for (int i = 0; i < r - l + 1; i++) {
            arrCopy[i] = arr[l + i];
        }

        int arrCopyMid = mid - l;
        int arrCopyL = 0;
        int arrCopyR = arrCopyMid + 1;
        int k = l;
        while (true) {
            if (arrCopyL > arrCopyMid && arrCopyR > arrCopy.length - 1) {
                break;
            }
            if (arrCopyL <= arrCopyMid && arrCopyR <= arrCopy.length - 1) {
                if (arrCopy[arrCopyL] < arrCopy[arrCopyR]) {
                    arr[k] = arrCopy[arrCopyL];
                    arrCopyL++;
                } else {
                    arr[k] = arrCopy[arrCopyR];
                    arrCopyR++;
                }
            } else {
                if (arrCopyR > arrCopy.length - 1) {
                    arr[k] = arrCopy[arrCopyL];
                    arrCopyL++;
                } else {
                    arr[k] = arrCopy[arrCopyR];
                    arrCopyR++;
                }
            }
            k++;
        }
    }
}
