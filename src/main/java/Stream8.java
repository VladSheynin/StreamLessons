//*Задача8
//Перепишите следующий код со Stream API:
//
//
//   List<String> result = new ArrayList<>();
//   for (String word : words) {
//       if (word.length() > 3) {
//           result.add(word.toUpperCase());
//       }
//   }

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stream8 {
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        String[] words = {"Word1","wod","The words","1234"};
        for (String word : words) {
            if (word.length() > 3) {
                result.add(word.toUpperCase());
            }
        }

        System.out.println(result);

        System.out.println(Arrays.stream(words).filter((word)-> word.length()>3).map(w->w.toUpperCase()).toList());
    }
}
