import model.NewUser;
import model.Order;
import model.Order.OrderStatus;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Chapter6Section4 {

    public static void main(String[] args) {

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

        List<String> collect = users.stream()
                .filter(newUser -> !newUser.isVerified())
                .map(NewUser::getEmailAddress)
                .collect(Collectors.toList());
        System.out.println(collect);


        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        Order order1 = new Order()
                .setId(1001)
                .setStatus(OrderStatus.CREATED)
                .setCreatedByUserId(101)
                .setCreatedAt(now.minusHours(4));
        Order order2 = new Order()
                .setId(1002)
                .setStatus(OrderStatus.ERROR)
                .setCreatedByUserId(103)
                .setCreatedAt(now.minusHours(1));
        Order order3 = new Order()
                .setId(1003)
                .setStatus(OrderStatus.PROCESSED)
                .setCreatedByUserId(102)
                .setCreatedAt(now.minusHours(36));
        Order order4 = new Order()
                .setId(1004)
                .setStatus(OrderStatus.ERROR)
                .setCreatedByUserId(104)
                .setCreatedAt(now.minusHours(40));
        Order order5 = new Order()
                .setId(1005)
                .setStatus(OrderStatus.IN_PROGRESS)
                .setCreatedByUserId(101)
                .setCreatedAt(now.minusHours(10));
        List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);


        // TODO: Find orders in Error status, and extract createdByUserIds as a list
        List<Long> collect1 = orders.stream()
                .filter(order -> order.getStatus().equals(OrderStatus.ERROR))
                .map(Order::getCreatedByUserId)
                .collect(Collectors.toList());
        System.out.println(collect1);

        // TODO: Find orders in ERROR status and created within 24 hours
        List<Order> collect2 = orders.stream()
                .filter(order -> order.getStatus().equals(OrderStatus.ERROR))
                .filter(order -> order.getCreatedAt().isAfter(now.minusHours(24)))
                .collect(Collectors.toList());
        System.out.println(collect2);


    }
}
