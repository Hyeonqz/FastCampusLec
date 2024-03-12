package api.utility;

public class Main {
    public static void main(String[] args) {
        int[] arr = {5,4,3,215125,436,43534,523};
        int min = MinMaxFinder.findMin(arr);
        int max = MinMaxFinder.findMax(arr);

        System.out.println("max = " + max);
        System.out.println("min = " + min);
        System.out.println("arr = " + arr.toString());
        System.out.println("arr = " + arr.hashCode());



    }
}