import collection.Array;
import collection.MultiDimensionalArray;

public class Main {
    public static void main(String[] args) {
        Array<Integer> multiArray = new MultiDimensionalArray<>(3);
        multiArray.add(null, 0);
    }
}