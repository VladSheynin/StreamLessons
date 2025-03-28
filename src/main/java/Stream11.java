//*Задача11
//Дан Stream<String>, где некоторые элементы могут быть null. Обработайте поток так, чтобы:
//    - Пропустить `null`-значения.
//    - Преобразовать строки в числа (`Integer.parseInt`), игнорируя нечисловые строки.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Stream11 {
    public static void main(String[] args) {
        List<String> listForStream = new ArrayList<>(Arrays.asList("1", "2", "nhb", null, "3"));
        Stream<String> stream = listForStream.stream();
        List<Integer> intList = new ArrayList<>();
        intList = stream.filter((a) -> (!(a == null)&&(a.matches("\\d+"))))
                .map(i -> Integer.parseInt(i))
                .toList();
        System.out.println(intList);
    }
}
