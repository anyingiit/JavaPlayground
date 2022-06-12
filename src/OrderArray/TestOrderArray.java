package OrderArray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestOrderArray {

    @Test
    public void test1() { // 对于数据内容相等的数据来说, 具有正序也具有倒序特性
        int[] test = {1, 1, 1, 1, 1};

        Assertions.assertTrue(OrderArray.checkArrIsOrderByASC(test));
        Assertions.assertTrue(OrderArray.checkArrIsOrderByDESC(test));
    }

    @Test
    public void test2() { // 对于乱序数据, 其既不具有顺序特性, 也不具有倒序特性
        int[][] tests = {
                {5, 4, 3, 2, 5},
                {1, 2, 3, 4, 1},
                {7, 2, 6, 2, 1}
        };

        for (int[] test :
                tests) {
            Assertions.assertFalse(OrderArray.checkArrIsOrderByASC(test));
            Assertions.assertFalse(OrderArray.checkArrIsOrderByDESC(test));
        }
    }

    @Test
    public void test3() { // 对于正序数据来说, 其具有正序特性
        int[][] tests = {
                {1, 2, 3, 4, 5},
                {11, 22, 33, 44, 55},
                {55, 66, 77, 88, 99}
        };

        for (int[] test :
                tests) {
            Assertions.assertTrue(OrderArray.checkArrIsOrderByASC(test));
        }
    }

    @Test
    public void test4() { // 对于倒序数据来说, 齐聚友倒序特性
        int[][] tests = {
                {5, 4, 3, 2, 1},
                {55, 44, 33, 22, 11},
                {99, 88, 77, 66, 55}
        };

        for (int[] test :
                tests) {
            Assertions.assertTrue(OrderArray.checkArrIsOrderByDESC(test));
        }
    }
}
