import model.NewUser;
import model.Order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


public class Chapter8Section2 {

    public static void main(String[] args) {
        boolean b = Stream.of(5, 2, 6, 2, -3)
                .allMatch(integer -> integer > 0);
        System.out.println(b);
        boolean c = Stream.of(5, 2, 6, 2, -3)
                .anyMatch(integer -> integer < 0);
        System.out.println(c);

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
                .setVerified(true)
                .setEmailAddress("charlie@fastcampus.co.kr");
        List<NewUser> users = Arrays.asList(user1, user2, user3);

        boolean b1 = users.stream()
                .allMatch(NewUser::isVerified);
        System.out.println(b1);

        Order order1 = new Order()
                .setId(1001L)
                .setAmount(BigDecimal.valueOf(2000))
                .setStatus(Order.OrderStatus.CREATED);
        Order order2 = new Order()
                .setId(1002L)
                .setAmount(BigDecimal.valueOf(4000))
                .setStatus(Order.OrderStatus.ERROR);
        Order order3 = new Order()
                .setId(1003L)
                .setAmount(BigDecimal.valueOf(3000))
                .setStatus(Order.OrderStatus.ERROR);
        Order order4 = new Order()
                .setId(1004L)
                .setAmount(BigDecimal.valueOf(7000))
                .setStatus(Order.OrderStatus.PROCESSED);
        List<Order> orders = Arrays.asList(order1, order2, order3, order4);

        boolean b2 = orders.stream()
                .anyMatch(order -> order.getStatus().equals(Order.OrderStatus.ERROR));
        System.out.println(b2);




    }
}
