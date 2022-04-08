import model.NewUser;

import java.util.Optional;


public class Chapter7Section2 {

    public static void main(String[] args) {
        Optional<NewUser> newUser = Optional.ofNullable(maybeGetUser(true));
        newUser.ifPresent(System.out::println);
        Optional<Integer> integer = Optional.ofNullable(maybeGetUser(true))
                .map(user -> user.getId());
        integer.ifPresent(System.out::println);

        String userName = Optional.ofNullable(maybeGetUser(false))
                .map(NewUser::getName)
                .map(name -> "The name is " + name)
                .orElse("Name is empty");
        System.out.println(userName);

        Optional<String> maybeEmail = Optional.ofNullable(maybeGetUser(true))
                .flatMap(NewUser::getEmailAddressOptional);
        maybeEmail.ifPresent(System.out::println);

    }
    public static NewUser maybeGetUser(boolean returnUser){
        if(returnUser){
            return new NewUser()
                    .setId(1001)
                    .setName("Alice")
                    .setEmailAddress("alice@fastcampus.co.kr")
                    .setVerified(false);
        }
        return null;
    }
}
