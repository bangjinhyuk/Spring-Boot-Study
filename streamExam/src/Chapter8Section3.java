import model.NewUser;
import model.Order;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


public class Chapter8Section3 {

    public static void main(String[] args) {
        Optional<Integer> anyNegativeInteger = Stream.of(3, 2, -5, 6)
                .filter(x -> x < 0)
                .findAny();
        System.out.println(anyNegativeInteger.get());

        Optional<Integer> firstPositiveInteger = Stream.of(-3, -2, -5, 6)
                .filter(x -> x > 0)
                .findFirst();
        System.out.println(firstPositiveInteger.get());
    }
}
