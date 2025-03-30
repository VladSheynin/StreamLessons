//*Задача6
//Для списка чисел List<Integer> nums = List.of(10, 20, 30, 40, 50);:
//   - Найдите сумму всех чисел (`reduce` или `sum`).
//   - Получите среднее значение (`Collectors.averagingInt`).
//

import java.util.List;
import java.util.stream.Collectors;

public class Stream5 {


    public static void main(String[] args) {
        List<Integer> nums = List.of(10, 20, 30, 40, 50);
        System.out.println("Среднее значение = " + nums.stream().collect(Collectors.averagingInt(Integer::intValue)));
        System.out.println("Сумма = " + nums.stream().reduce(Integer::sum).get());
    }
}
