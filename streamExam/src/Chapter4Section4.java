
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;


public class Chapter4Section4 {
    public static void main(String[] args) {
        Predicate<Integer> isPositive = (x) -> x > 0;
        Predicate<Integer> isThree = (x) -> x == 3;

        List<Integer> integers = Arrays.asList(-5,-4,-3,-2,-1,0,1,2,3,4);
        System.out.println("PositiveNum: "+ filter(integers,isPositive));
        System.out.println("NegativeAndThreeNum: "+ filter(integers,isPositive.negate().or(isThree)));
        System.out.println("PositiveEvenNum: "+ filter(integers,isPositive.and(x -> x/2 == 0)));

    }

    public static <T> List<T> filter(List<T> inputs, Predicate<T> condition) {
        List<T> output = new ArrayList<>();
        for (T input : inputs) {
            if(condition.test(input)){
                output.add(input);
            }
        }
        return output;
    }

}
