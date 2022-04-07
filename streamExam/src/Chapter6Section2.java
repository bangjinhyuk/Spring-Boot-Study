import model.NewUser;
import model.Order;
import model.Order.OrderStatus;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Chapter6Section2 {

    public static void main(String[] args) {
        Stream<Integer> numberStream = Stream.of(3, -5,2,5,1);
        List<Integer> positiveNum = numberStream.filter(x -> x > 0).collect(Collectors.toList());
        System.out.println(positiveNum);

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
        List<NewUser> verifiedUsers = users.stream()
                .filter(NewUser::isVerified)
                .collect(Collectors.toList());
        System.out.println(verifiedUsers);

        List<NewUser> unverifiedUsers = users.stream()
                .filter(user -> !user.isVerified())
                .collect(Collectors.toList());
        System.out.println(unverifiedUsers);

        Order order1 = new Order()
                .setId(1001)
                .setStatus(OrderStatus.CREATED);
        Order order2 = new Order()
                .setId(1002)
                .setStatus(OrderStatus.ERROR);
        Order order3 = new Order()
                .setId(1003)
                .setStatus(OrderStatus.PROCESSED);
        Order order4 = new Order()
                .setId(1004)
                .setStatus(OrderStatus.ERROR);
        Order order5 = new Order()
                .setId(1005)
                .setStatus(OrderStatus.IN_PROGRESS);

        List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);

        List<Order> errorOrders = orders.stream()
                .filter(order -> order.getStatus().equals(OrderStatus.ERROR))
                .collect(Collectors.toList());

        System.out.println(errorOrders);

    }
}
