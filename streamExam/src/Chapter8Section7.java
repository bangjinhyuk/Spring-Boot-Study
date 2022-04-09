import model.NewUser;
import model.Order;
import model.Order.OrderStatus;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Chapter8Section7 {

    public static void main(String[] args) {

        Map<Integer, String> numberMap = Stream.of(3, 5, -4, 2, 6)
                .collect(Collectors.toMap(Function.identity(), x -> "Number is " + x));
        System.out.println(numberMap.get(3));

        NewUser user1 = new NewUser()
                .setId(101)
                .setName("Alice")
                .setVerified(true)
                .setEmailAddress("alice@fastcampus.co.kr");
        NewUser user2 = new NewUser()
                .setId(102)
                .setName("Bob")
                .setVerified(false)
                .setEmailAddress("bob@fastcampus.co.kr");
        NewUser user3 = new NewUser()
                .setId(103)
                .setName("Charlie")
                .setVerified(false)
                .setEmailAddress("charlie@fastcampus.co.kr");
        List<NewUser> users = Arrays.asList(user1, user2, user3);
        Map<Integer, NewUser> userIdToUserMap = users.stream()
                .collect(Collectors.toMap(NewUser::getId, Function.identity()));
        System.out.println(userIdToUserMap);
        System.out.println(userIdToUserMap.get(103));

        Order order1 = new Order()
                .setId(1001L)
                .setAmount(BigDecimal.valueOf(2000))
                .setStatus(OrderStatus.CREATED);
        Order order2 = new Order()
                .setId(1002L)
                .setAmount(BigDecimal.valueOf(4000))
                .setStatus(OrderStatus.ERROR);
        Order order3 = new Order()
                .setId(1003L)
                .setAmount(BigDecimal.valueOf(3000))
                .setStatus(OrderStatus.ERROR);
        Order order4 = new Order()
                .setId(1004L)
                .setAmount(BigDecimal.valueOf(7000))
                .setStatus(OrderStatus.PROCESSED);
        List<Order> orders = Arrays.asList(order1, order2, order3, order4);
        Map<Long, OrderStatus> collect = orders.stream()
                .collect(Collectors.toMap(Order::getId, Order::getStatus));

        System.out.println(collect);
    }
}
