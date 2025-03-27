//*Задача6
//Для списка чисел List<Integer> nums = List.of(10, 20, 30, 40, 50);:
//   - Найдите сумму всех чисел (`reduce` или `sum`).
//   - Получите среднее значение (`Collectors.averagingInt`).
//

import java.util.List;

public class Stream5 {


    public static void main(String[] args) {
        List<Integer> nums = List.of(10, 20, 30, 40, 50);
        Integer sum = nums.stream().reduce((a, b) -> a + b).get();
        System.out.println(sum);
    }
}
