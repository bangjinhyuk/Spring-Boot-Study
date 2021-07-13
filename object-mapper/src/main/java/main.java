import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dto.Car;
import dto.User;

import java.util.Arrays;
import java.util.List;

public class main {

    public static void main(String[] args) throws JsonProcessingException {
        System.out.println("main");
        ObjectMapper objectMapper = new ObjectMapper();

        User user = new User();
        user.setName("qwer");
        user.setAge(12);

        Car car1 = new Car();
        car1.setName("k5");
        car1.setCarNumber("1234");
        car1.setType("sedan");

        Car car2 = new Car();
        car2.setName("Q5");
        car2.setCarNumber("2323");
        car2.setType("SUV");

        List<Car> carList = Arrays.asList(car1,car2);
        user.setCar(carList);

        System.out.println(user);
        String json = objectMapper.writeValueAsString(user);
        System.out.println(json);

        JsonNode jsonNode = objectMapper.readTree(json);
        String _name = jsonNode.get("name").asText();
        int _age = jsonNode.get("age").asInt();
        System.out.println(_name);
        System.out.println(_age);

        JsonNode cars = jsonNode.get("car");
        ArrayNode arrayNode = (ArrayNode) cars;
        List<Car> _cars = objectMapper.convertValue(arrayNode, new TypeReference<List<Car>>() {
        });
        System.out.println(_cars.get(1));

        System.out.println(jsonNode.toPrettyString());

        //값의 변화
        ObjectNode objectNode = (ObjectNode) jsonNode;
        objectNode.put("name","steve");
        objectNode.put("age",20);
        System.out.println(objectNode.toPrettyString());

    }
}
