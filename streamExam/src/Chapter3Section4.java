import util.TriFunction;


public class Chapter3Section4 {
    public static void main(String[] args) {
        TriFunction<Integer, Integer, Integer, Integer> add = (x, y, z) -> x+y+z;
        System.out.println(add.apply(3,5, 5));
    }
}
