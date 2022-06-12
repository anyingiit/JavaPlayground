package HeapSort;

import OrderArray.OrderArray;
import Random.Random;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestSortByDESC {
    @Test
    public void test1() {
        int[] test = {5, 2, 5, 6, 8, 1, 2, 0};
        Assertions.assertFalse(OrderArray.checkArrIsOrderByDESC(test)); // 检查其本身不能具有顺序性

        SortByDESC.sort(test); // 进行排序

        Assertions.assertTrue(OrderArray.checkArrIsOrderByDESC(test)); // 检查排序后需要具有升序顺序性
    }

    @Test
    public void test2() {
        int[] test = Random.generateRandoms(1000000); // 创建100W个随机数据
        Assertions.assertFalse(OrderArray.checkArrIsOrderByDESC(test)); // 检查其本身不能具有顺序性

        SortByDESC.sort(test); // 进行排序

        Assertions.assertTrue(OrderArray.checkArrIsOrderByDESC(test)); // 检查排序后需要具有升序顺序性
    }
}
