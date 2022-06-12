package HeapSort;

import OrderArray.OrderArray;
import Random.Random;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class TestSortByASC {
    @Test
    public void test1() { // 手工创建的随机数据进行测试
        int[] test = {5, 2, 5, 6, 8, 1, 2, 0};
        Assertions.assertFalse(OrderArray.checkArrIsOrderByASC(test)); // 检查其本身不能具有升序顺序性

        SortByASC.sort(test); // 进行排序

        Assertions.assertTrue(OrderArray.checkArrIsOrderByASC(test)); // 检查排序后需要具有升序顺序性
    }

    @Test
    public void test2() { // 有随机数生成类创建的数据进行测试
        int[] test = Random.generateRandoms(1000000); // 创建100W个随机数据
        Assertions.assertFalse(OrderArray.checkArrIsOrderByASC(test)); // 检查其本身不能具有升序顺序性

        SortByASC.sort(test); // 进行排序

        Assertions.assertTrue(OrderArray.checkArrIsOrderByASC(test)); // 检查排序后需要具有升序顺序性
    }
}
