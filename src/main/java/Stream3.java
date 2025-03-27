import java.util.List;

public class Stream3 {

    //* Задача 3
    //Найдите в списке List<String> names = List.of("John", "Alice", "Bob");
    // имя, начинающееся на "A" (используйте `findFirst`).
    public static void main(String[] args) {
        List<String> names = List.of("John", "Alice", "Bob");
        String nameStartA = names.stream()
                .filter(a -> a.contains("A"))
                .findFirst()
                .orElse("нет такого слова");
        System.out.println(nameStartA);
    }
}