//*Задача7
//   Дана CSV-строка: "1,John,25;2,Alice,30;3,Bob,20".
//   Преобразуйте её в список объектов Person (id, name, age), используя Stream:
//   - Разделите строку по ;, затем по ,.
//   - Игнорируйте строки с некорректными данными (например, `"4,Error"`).

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream7 {
    public static void main(String[] args) {
        String csvString = "1,John,25;2,Alice,30;3,Bob, 24";
        List<Person> persons = Arrays.stream(csvString.split(";")).toList().stream()
                .filter(str -> str.matches("^([^,]*,){2}[^,]*$"))
                .map(str -> {
                    int comma1 = str.indexOf(',');
                    int comma2 = str.indexOf(',', comma1 + 1);
                    return new Person(Integer.parseInt(str.substring(0, comma1).trim()),
                            str.substring(comma1 + 1, comma2).trim(),
                            Integer.parseInt(str.substring(comma2 + 1).trim()));
                }).toList();
        System.out.println(persons);
    }

    record Person(int id, String name, int age) {
    }
}


