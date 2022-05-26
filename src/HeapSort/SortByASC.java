package HeapSort;

public class SortByASC {
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
            int maxIndex = inspect * 2 + 1;
            if (inspect * 2 + 2 < len && array[inspect * 2 + 2] < array[maxIndex]) {
                maxIndex = inspect * 2 + 2;
            }

            if (array[maxIndex] < array[inspect]) {
                int temp = array[maxIndex];
                array[maxIndex] = array[inspect];
                array[inspect] = temp;
                inspect = maxIndex;
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
