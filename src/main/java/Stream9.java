//*Задача9
//Для большого списка чисел (`List<Integer> largeList = ...`) вычислите сумму квадратов чисел, используя параллельный поток (`parallelStream`).
//    *Доп. вопрос*: В каких случаях это ускорит работу?

import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Stream9 {
    public static void main(String[] args) {
        List<Integer> largeList = new ArrayList<>();
        Random randomInteger = new Random();
        for (int i = 1; i < 30000001; i++) {
            largeList.add(randomInteger.nextInt(i));
        }
        Instant timeStart = Instant.now();
        System.out.println("Сумма квадратов " + largeList.size() + " чисел равна = " +
                largeList.parallelStream()
                        //.stream()
                        .map(a -> new BigInteger(String.valueOf(a)))
                        .map(bigA -> bigA.multiply(bigA))
                        .reduce((a, b) -> a.add(b))
                        .get());
        long secondsBetween = Duration.between(timeStart, Instant.now()).getSeconds();
        System.out.println("Длительность вычислений = " + secondsBetween + " секунд");
    }
}
