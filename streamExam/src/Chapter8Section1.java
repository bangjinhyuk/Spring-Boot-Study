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


public class Chapter8Section1 {

    public static void main(String[] args) {
        Optional<Integer> max = Stream.of(5, 2, 6, 2, 3)
                .max(Integer::compareTo);
        System.out.println(max.orElse(0));

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

        NewUser firstUser = users.stream()
                .min(Comparator.comparing(NewUser::getName))
                .get();
        System.out.println(firstUser);

        long positiveIntegerCount = Stream.of(1, -4, 5, -3, 6)
                .filter(x -> x > 0)
                .count();
        System.out.println("Positive integers: " + positiveIntegerCount);

        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        user1.setCreatedAt(now.minusDays(2));
        user2.setCreatedAt(now.minusHours(10));
        user3.setCreatedAt(now.minusHours(1));
        NewUser user4 = new NewUser()
                .setId(104)
                .setName("David")
                .setVerified(true)
                .setEmailAddress("david@fastcampus.co.kr")
                .setCreatedAt(now.minusHours(27));

        users = Arrays.asList(user1, user2, user3, user4);

        long count = users.stream()
                .filter(user -> user.getCreatedAt().isAfter(now.minusDays(1)))
                .filter(user -> !user.isVerified())
                .count();
        System.out.println(count);

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

        Optional<Order> max1 = orders.stream()
                .filter(order -> order.getStatus().equals(Order.OrderStatus.ERROR))
                .max(Comparator.comparing(Order::getAmount));

        System.out.println(max1);


    }
}
