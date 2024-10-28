import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> numberSet = new HashSet<>();

        numberSet.add(111);
        numberSet.add(221);
        numberSet.add(333);
        numberSet.add(444);
        numberSet.add(554);
        numberSet.add(667);

        Set<Integer> divideByThree = new HashSet<>();

        for (Integer number : numberSet) {
            if (DivisibleByThree(number)) {
                divideByThree.add(number);
            }
        }

        System.out.println("Divide By Three :");
        for (Integer number : divideByThree) {
            System.out.println(number);
        }
    }

    private static boolean DivisibleByThree(int num) {
        while (num >= 3) {
            num -= 3;
        }
        return num == 0;
    }
}