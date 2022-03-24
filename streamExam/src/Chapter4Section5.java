
import model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class Chapter4Section5 {
    public static void main(String[] args) {
        List<User> users  = new ArrayList<>();
        users.add(new User(3,"Alice"));
        users.add(new User(1,"Charlie"));
        users.add(new User(5,"Bob"));
        System.out.println(users);
        Collections.sort(users, (u1, u2) -> u1.getId() - u2.getId());
        System.out.println(users);
        Collections.sort(users, (u1, u2) -> u1.getName().compareTo(u2.getName()));
        System.out.println(users);
    }
}
