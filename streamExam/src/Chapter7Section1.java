import model.NewUser;

import java.util.Optional;


public class Chapter7Section1 {

    public static void main(String[] args) {
        NewUser user1 = new NewUser()
                .setId(1001)
                .setName("Alice")
                .setVerified(false);

        NewUser user2 = new NewUser()
                .setId(1001)
                .setName("Alice")
                .setEmailAddress("alice@fastcampus.co.kr")
                .setVerified(false);

//        System.out.println("Same? :" + usersEquals(user2, user1));
//        System.out.println("Same? :" + usersEquals(user1, user2));

        String someEmail = "some@email.com";
        String nullEmail = null;

        Optional<String> maybeEmail = Optional.of(someEmail);
        Optional<String> maybeEmail2 = Optional.empty();
        Optional<String> maybeEmail3 = Optional.ofNullable(someEmail);
        Optional<String> maybeEmail4 = Optional.ofNullable(nullEmail);

        String email = maybeEmail.get();
        System.out.println(email);

        if (maybeEmail2.isPresent()) {
            System.out.println(maybeEmail2.get());
        }

        String defaultEmail = "default@email.com";
        String email3 = maybeEmail2.orElse(defaultEmail);
        System.out.println(email3);
        String email4 = maybeEmail2.orElseGet(() -> defaultEmail);
        System.out.println(email4);
        String email5 = maybeEmail2.orElseThrow(() -> new RuntimeException("email not present"));
        System.out.println(email5);



    }
    public static boolean usersEquals(NewUser u1, NewUser u2){
        return u1.getId() == u2.getId()
                && u1.getName().equals(u2.getName())
                && u1.getEmailAddress().equals(u2.getEmailAddress())
                && u1.isVerified() == u2.isVerified();
    }
}
