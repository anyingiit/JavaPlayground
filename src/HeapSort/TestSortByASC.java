package HeapSort;

import OrderArray.OrderArray;
import Random.Random;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class TestSortByASC {
    @Test
    public void test1() {
        int[] test = {5, 2, 5, 6, 8, 1, 2, 0};
        SortByASC.sort(test);

        Assertions.assertTrue(OrderArray.checkArrIsOrderByASC(test));
    }

    @Test
    public void test2() {
        int[] test = Random.generateRandoms(1000000);
        SortByASC.sort(test);

        Assertions.assertTrue(OrderArray.checkArrIsOrderByASC(test));
    }
}
