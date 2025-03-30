import java.util.List;

//* Задача 2
//Дан список чисел: List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
//- Отфильтруйте чётные числа.
//- Увеличьте каждое число на 10 и соберите в новый список.
public class Stream2 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        //List<Integer> newList = numbers.stream().filter((a) -> a % 2 == 0).map((n) -> n + 10).toList();
        System.out.println(numbers.stream().filter((a) -> a % 2 == 0).map((n) -> n + 10).toList());
    }
}
