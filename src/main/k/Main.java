package k;

import java.util.List;

import k.frogsort.FrogSort;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 7, 9, 0, 4, 3, 2, 9, 1, 0, 3, 6, 3);

        FrogSort frogSort = new FrogSort(numbers);
        List<Integer> sorted = frogSort.sort();

        System.out.print("[ ");
        for (int number : sorted) {
            System.out.printf("%d ", number);
        }
        System.out.println("]");
    }
}
