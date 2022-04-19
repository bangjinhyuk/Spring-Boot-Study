import model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.logging.Handler;

public class Chapter5Section3 {

    public static void main(String[] args) {
        User user = new User(1, "Alice");
        BiFunction<Integer, String, User> userCreator = User::new;
        User user2 = userCreator.apply(2,"Charlie");
        System.out.println(user2);

        Map<String, BiFunction<String,String, Car>> carTypeToConstructorMap = new HashMap<>();

        String[][] inputs = new String[][]{
                {"sedan", "Sonata", "Hyundai"},
                {"van", "Sienna", "Toyota"},
                {"sedan", "Model S", "Tesla"},
                {"suv", "Sorento", "KIA"}
        };
        carTypeToConstructorMap.put("sedan", Sedan::new);
        carTypeToConstructorMap.put("suv", Suv::new);
        carTypeToConstructorMap.put("van", Van::new);
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < inputs.length; i++) {
            String[] input = inputs[i];
            String carType = input[0];
            String name = input[1];
            String brand = input[2];

            cars.add(carTypeToConstructorMap.get(carType).apply(name, brand));
        }
        cars.forEach(Car::drive);
    }
}
