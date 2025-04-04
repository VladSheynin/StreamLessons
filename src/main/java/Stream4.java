import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//* Задача 4
//Дан список строк: List<String> words = List.of("apple", "banana", "apricot", "cherry", "blueberry");
//   Сгруппируйте их по первой букве в Map<Character, List<String>>. -- Наверное второе значение строка? - сделал оба варианта
//                                                                   -- если первые буквы совпадают, то строка не добавляется?
public class Stream4 {

    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana", "apricot", "cherry", "blueberry");
        Map<Character, String> map1 = words.stream().collect(Collectors.toMap(str -> (Character) str.charAt(0), str -> str, (oldValue, newValue) -> oldValue));
        Map<Character, List<String>> map2 = words.stream().collect(Collectors.toMap(str -> (Character) str.charAt(0), str -> words, (oldValue, newValue) -> oldValue));
        Map<Character,List<String>> map3 = words.stream().collect(Collectors.groupingBy(word->word.charAt(0)));
        System.out.println(map1);
        System.out.println(map2);
        System.out.println(map3);
    }
}
