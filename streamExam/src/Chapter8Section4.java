import model.NewUser;
import model.Order;
import model.OrderLine;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


public class Chapter8Section4 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 4, -2, -5, 3);
        int sum = numbers.stream()
                .reduce((x, y) -> x + y)
                .get();
        System.out.println(sum);

        int min = numbers.stream()
                .reduce((x, y) -> x > y ? x : y)
                .get();
        System.out.println(min);

        int product = numbers.stream()
                .reduce(1, (x, y) -> x * y);
        System.out.println(product);

        List<String> numberStrList = Arrays.asList("2","3","5","-2");
        Integer reduce = numberStrList.stream()
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
        System.out.println(reduce);

        Integer reduce2 = numberStrList.stream()
                .reduce(0, (number, str) -> number + Integer.parseInt(str), Integer::sum);
        System.out.println(reduce2);

        NewUser user1 = new NewUser()
                .setId(101)
                .setName("Alice")
                .setFriendUserIds(Arrays.asList(201, 202, 203, 204));
        NewUser user2 = new NewUser()
                .setId(102)
                .setName("Bob")
                .setFriendUserIds(Arrays.asList(204, 205, 206));
        NewUser user3 = new NewUser()
                .setId(103)
                .setName("Charlie")
                .setFriendUserIds(Arrays.asList(204, 205, 207));
        List<NewUser> users = Arrays.asList(user1, user2, user3);

        long count = users.stream()
                .flatMap(newUser -> newUser.getFriendUserIds().stream())
                .count();
        System.out.println(count);
        Integer integer = users.stream()
                .map(NewUser::getFriendUserIds)
                .map(List::size)
                .reduce(Integer::sum).get();
        System.out.println(integer);

        Order order1 = new Order()
                .setId(1001L)
                .setOrderLines(Arrays.asList(
                        new OrderLine().setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine().setAmount(BigDecimal.valueOf(2000))));
        Order order2 = new Order()
                .setId(1002L)
                .setOrderLines(Arrays.asList(
                        new OrderLine().setAmount(BigDecimal.valueOf(2000)),
                        new OrderLine()
                                .setAmount(BigDecimal.valueOf(3000))));
        Order order3 = new Order()
                .setId(1002L)
                .setOrderLines(Arrays.asList(
                        new OrderLine().setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine().setAmount(BigDecimal.valueOf(2000))));
        List<Order> orders = Arrays.asList(order1, order2, order3);

        BigDecimal reduce1 = orders.stream()
                .flatMap(order -> order.getOrderLines().stream())
                .map(orderLine -> orderLine.getAmount())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(reduce1);


    }
}
