import model.NewUser;
import model.Order;
import model.Order.OrderStatus;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Chapter8Section10 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(3, 5, 2, 1);
        numbers.stream().forEach(number -> System.out.println("The number is " + number));
        numbers.forEach(number -> System.out.println("The number is " + number));
    }
}
