import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Stream4 {

    //* Задача 4
    //Дан список строк: List<String> words = List.of("apple", "banana", "apricot", "cherry", "blueberry");
    //   Сгруппируйте их по первой букве в Map<Character, List<String>>. -- Наверное второе значение строка? - сделал оба варианта
    //                                                                   -- если первые буквы совпадают, то строка не добавляется?


    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana", "apricot", "cherry", "blueberry");
        Map<Character, String> map1 = new HashMap<>();
        map1 = words.stream().collect(
                Collectors.toMap(str -> (Character) str.charAt(0), str->str, (oldValue, newValue) -> oldValue));
        Map<Character,List<String>> map2 = words.stream().collect(
                Collectors.toMap(str -> (Character) str.charAt(0), str->words, (oldValue, newValue) -> oldValue));

        System.out.println(map1);
        System.out.println(map2);

    }
}
