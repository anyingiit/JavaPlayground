package HeapSort;

public class SortByDESC {
    public static void sort(int[] array) {
        toMinHeap(array);
        int inspectLen = array.length;
        while (inspectLen > 0) {
            int temp = array[0];
            array[0] = array[inspectLen - 1];
            array[inspectLen - 1] = temp;
            inspectLen--;
            minHeapSiftDown(array, 0, inspectLen);
        }
    }

    private static void minHeapSiftDown(int[] array, int index, int len) {
        int inspect = index;
        while (inspect * 2 + 1 < len) {
            int minIndex = inspect * 2 + 1;
            if (inspect * 2 + 2 < len && array[inspect * 2 + 2] < array[minIndex]) {
                minIndex = inspect * 2 + 2;
            }

            if (array[minIndex] < array[inspect]) {
                int temp = array[minIndex];
                array[minIndex] = array[inspect];
                array[inspect] = temp;
                inspect = minIndex;
            } else {
                break;
            }
        }
    }

    private static void toMinHeap(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            minHeapSiftDown(array, i, array.length);
        }
    }
}
