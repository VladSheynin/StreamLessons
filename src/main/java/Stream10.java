//*Задача10
//Напишите свой Collector,
// который объединяет строки в формате: "[str1, str2, str3]" (аналог Collectors.joining, но с квадратными скобками).

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class Stream10 {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("1", "2", "3", "4", "5");

        /* Производим конкатенацию значений с помощью функции reduce */
        String joinReduceTest = list.stream()
                .reduce(new StringCombiner(", ", "[", "]"),
                        StringCombiner::add,
                        StringCombiner::merge
                ).toString();

        System.out.println("С помощью reduce: " + joinReduceTest);

        /* Производим конкатенацию значений с помощью функции collect */
        String joinCollectTest = list.stream()
                .collect(new StringCollector(", ", "[", "]"));

        System.out.println("С помощью collect: " + joinCollectTest);
    }
}

/**
 * Коллектор конкатеницаии строк
 */
class StringCollector implements Collector<String, StringCombiner, String> {
    private String delim;
    private String prefix;
    private String suffix;

    public StringCollector(String delim, String prefix, String suffix) {
        this.delim = delim;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    @Override
    public Supplier<StringCombiner> supplier() {
        return () -> new StringCombiner(delim, prefix, suffix);
    }

    @Override
    public BiConsumer<StringCombiner, String> accumulator() {
        return StringCombiner::add;
    }

    @Override
    public BinaryOperator<StringCombiner> combiner() {
        return StringCombiner::merge;
    }

    @Override
    public Function<StringCombiner, String> finisher() {
        return StringCombiner::toString;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(Characteristics.UNORDERED);
    }
}


/**
 * Вспомогательный класс-контейнер
 */
class StringCombiner {
    private String delim;
    private String prefix;
    private String suffix;

    private boolean areAtStart = true;
    private StringBuilder sb = new StringBuilder();

    public StringCombiner(String delim, String prefix, String suffix) {
        this.delim = delim;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    /**
     * Функция для добавления элемента для конкатенации
     *
     * @param elem Элемента для добавления
     * @return текущий объект класса
     */
    public StringCombiner add(String elem) {
        if (areAtStart) {
            sb.append(prefix);
            areAtStart = false;
        } else {
            sb.append(delim);
        }
        sb.append(elem);

        return this;
    }

    /**
     * Функция объединения контейнеров
     *
     * @param other Контейнер для объединения с текущим контейнером
     * @return текущий объект класса
     */
    public StringCombiner merge(StringCombiner other) {
        sb.append(other.sb);
        return this;
    }

    /**
     * Функция для добавления форматированного вывода контейнера
     *
     * @return Строка
     */
    @Override
    public String toString() {
        sb.append(suffix);
        return sb.toString();
    }
}
