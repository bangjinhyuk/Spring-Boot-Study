import model.NewUser;
import model.Order;
import model.Order.OrderStatus;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Chapter6Section3 {

    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(2,6,-4);
        List<Integer> collect = numberList.stream().map(x -> x * 2).collect(Collectors.toList());
        System.out.println(collect);

        List<String> collect1 = numberList.stream().map(x -> "Number is " + x).collect(Collectors.toList());
        System.out.println(collect1);

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

        List<String> collect2 = users.stream().map(NewUser::getEmailAddress).collect(Collectors.toList());
        System.out.println(collect2);

        Order order1 = new Order()
                .setId(1001)
                .setStatus(OrderStatus.CREATED)
                .setCreatedByUserId(101);
        Order order2 = new Order()
                .setId(1002)
                .setStatus(OrderStatus.ERROR)
                .setCreatedByUserId(103);
        Order order3 = new Order()
                .setId(1003)
                .setStatus(OrderStatus.PROCESSED)
                .setCreatedByUserId(102);
        Order order4 = new Order()
                .setId(1004)
                .setStatus(OrderStatus.ERROR)
                .setCreatedByUserId(104);
        Order order5 = new Order()
                .setId(1005)
                .setStatus(OrderStatus.IN_PROGRESS)
                .setCreatedByUserId(101);

        List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);
        List<Long> collect3 = orders.stream().map(Order::getCreatedByUserId).collect(Collectors.toList());
        System.out.println(collect3);


    }
}
