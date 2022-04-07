import model.*;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chapter6Section1 {

    public static void main(String[] args) {
        Stream<String> nameStream = Stream.of("Alice","Bob","Charlie");
        List<String> names = nameStream.collect(Collectors.toList());
        System.out.println(names);

        String[] nameArray = new String[] {"Alice","Bob","Charlie"};
        Stream<String> nameStream2 = Arrays.stream(nameArray);
        List<String> cityList = nameStream2.collect(Collectors.toList());
        System.out.println(cityList);

        Set<Integer> numberSet = new HashSet<>(Arrays.asList(3,5,7));
        Stream<Integer> numberStream = numberSet.stream();
        List<Integer> numberList = numberStream.collect(Collectors.toList());
        System.out.println(numberList);

    }
}
