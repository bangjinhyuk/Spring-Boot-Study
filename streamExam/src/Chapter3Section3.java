import java.util.function.BiFunction;
import java.util.function.Function;

public class Chapter3Section3 {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> add = (Integer x, Integer y) -> x+y;
        System.out.println(add.apply(3,5));
    }
}
