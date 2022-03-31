import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class Chapter5Section2 {

    public static void main(String[] args) {
        Function<String, Integer> strLength = String::length;
        int length = strLength.apply("hello world");
        System.out.println(length);

        BiPredicate<String, String> strEquals = String::equals;
        boolean helloEqualsWorld = strEquals.test("test", "world");
        System.out.println(helloEqualsWorld);
    }
}
