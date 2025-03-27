import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
//* Задача 1
// Отсортируйте список строк List<String> words = Arrays.asList("apple", "banana", "cherry");:
//        - По алфавиту.
//        - По длине строки (используйте `Comparator.comparingInt`).

public class Stream1 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("bananas", "cherry", "apple");

        Comparator<String> comparatorByAlphabet = ((o1, o2) -> {
            return o1.compareTo(o2);
        });

        //words.sort(comparatorByAlphabet);
        words.sort(Comparator.naturalOrder());
        words.forEach(System.out::println);
        words.sort(Comparator.comparingInt((o) -> o.length()));
        System.out.println("\n");
        words.forEach(System.out::println);
    }
}
