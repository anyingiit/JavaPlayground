package HeapSort;

public class Main {
    public static void main(String[] args) {
        int[] test1 = {5, 2, 5, 6, 8, 1, 2, 0};
        SortByDESC.sort(test1);
        for (int e : test1) {
            System.out.println(e);
        }
        System.out.println();

        SortByASC.sort(test1);
        for (int e : test1) {
            System.out.println(e);
        }
    }
}
