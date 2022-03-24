
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


public class Chapter4Section2 {
    public static void main(String[] args) {
        Consumer<String> myStringConsumer = (str) -> System.out.println(str);
        myStringConsumer.accept("hello");

        List<Integer> integers  = Arrays.asList(4,2,3);
        Consumer<Integer> myIntegerConsumer = (x) -> System.out.println("processing integer " + x);
        process(integers, myIntegerConsumer);

        List<Double> doubles  = Arrays.asList(4.1,2.2,3.3);
        Consumer<Double> myDoubleConsumer = (x) -> System.out.println("processing Double " + x);
        process(doubles, myDoubleConsumer);

    }

    public static <T> void process(List<T> inputs,
                               Consumer<T> processor){
        for (T input : inputs) {
             processor.accept(input);
        }
    }
}
