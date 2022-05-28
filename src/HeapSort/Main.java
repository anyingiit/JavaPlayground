package HeapSort;

import java.util.Random;

public class Main {


    private static int[] generateRandoms(int scope) {
        int[] result = new int[scope];
        Random random = new Random();
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(10000);
        }
        return result;
    }

    private static boolean checkArrIsOrderByDESC(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkArrIsOrderByASC(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static boolean testHeapSortByASC() {
        int[] test1 = {5, 2, 5, 6, 8, 1, 2, 0};
        int[] test2 = generateRandoms(1000000);

        SortByASC.sort(test1);
        boolean test1Actually = checkArrIsOrderByASC(test1);
        System.out.println("test heap sort by ASC test1: " + (test1Actually ? "ok" : "failed"));

        SortByASC.sort(test2);
        boolean test2Actually = checkArrIsOrderByASC(test2);
        System.out.println("test heap sort by ASC test2: " + (test2Actually ? "ok" : "failed"));

        System.out.println("test heap sort by ASC: " + (test1Actually && test2Actually ? "ok" : "failed"));
        return test1Actually && test2Actually;
    }

    private static boolean testHeapSortByDESC() {
        int[] test1 = {0, 5, 2, 5, 6, 8, 1, 2};
        int[] test2 = generateRandoms(1000000);

        SortByDESC.sort(test1);
        boolean test1Actually = checkArrIsOrderByDESC(test1);
        System.out.println("test heap sort by DESC test1: " + (test1Actually ? "ok" : "failed"));

        SortByDESC.sort(test2);
        boolean test2Actually = checkArrIsOrderByDESC(test2);
        System.out.println("test heap sort by DESC test2: " + (test2Actually ? "ok" : "failed"));

        System.out.println("test heap sort by DESC: " + (test1Actually && test2Actually ? "ok" : "failed"));
        return test1Actually && test2Actually;
    }

    public static void main(String[] args) {
        boolean heapSortByASCActually = testHeapSortByASC();
        System.out.println();

        boolean testHeapSortByDESCActually = testHeapSortByDESC();
        System.out.println();
        System.out.println();

        System.out.println("test heap sort: " + (heapSortByASCActually && testHeapSortByDESCActually ? "ok" : "failed"));
    }
}
