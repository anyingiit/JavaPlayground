package MergeSort;

import OrderArray.OrderArray;
import Random.Random;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestSortByDESC {
    @Test
    public void test1() {
        int[] test = {5, 2, 5, 6, 8, 1, 2, 0};
        MergeSort.SortByDESC.sort(test);

        Assertions.assertTrue(OrderArray.checkArrIsOrderByDESC(test));
    }

    @Test
    public void test2() {
        int[] test = Random.generateRandoms(1000000);
        MergeSort.SortByDESC.sort(test);

        Assertions.assertTrue(OrderArray.checkArrIsOrderByDESC(test));
    }
}
