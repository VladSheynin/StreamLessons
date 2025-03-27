//*Задача6
//Даны класс Person и список:
//   record Person(String name, int age) {}
//   List<Person> people = List.of(
//       new Person("Alice", 25),
//       new Person("Bob", 30),
//       new Person("Charlie", 20)
//   );
//
//   - Отфильтруйте людей старше 21 года.
//   - Соберите имена в одну строку через запятую (`Collectors.joining`).

import java.util.List;
import java.util.stream.Collectors;

public class Stream6 {
    public static void main(String[] args) {
        List<Person> people = List.of(new Person("Alice", 25), new Person("Bob", 30), new Person("Charlie", 20));

        List<Person> people21Year = people.stream().filter(person -> person.age() > 21).toList();
        String allName = people.stream().map(p -> p.name()).collect(Collectors.joining());
        System.out.println(people21Year);
        System.out.println(allName);
    }
    record Person(String name, int age) {}
}




