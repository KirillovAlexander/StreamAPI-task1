import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);

        List<Integer> positiveList = new ArrayList<>();
        for (int x : intList) {
            if (x > 0) {
                positiveList.add(x);
            }
        }

        List<Integer> evenList = new ArrayList<>();
        for (int x : positiveList) {
            if (x % 2 == 0) {
                evenList.add(x);
            }
        }

        int[] evenListAsArray = evenList.stream().mapToInt(i -> i).toArray();

        mySort(evenListAsArray, 0, evenListAsArray.length - 1);

        System.out.println(Arrays.toString(evenListAsArray));
    }

    private static void mySort(int[] array, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = array[(leftMarker + rightMarker) / 2];

        do {
            while (array[leftMarker] < pivot) {
                leftMarker++;
            }
            while (array[rightMarker] > pivot) {
                rightMarker--;
            }
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    int temp = array[leftMarker];
                    array[leftMarker] = array[rightMarker];
                    array[rightMarker] = temp;
                }
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        if (leftMarker < rightBorder) {
            mySort(array, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            mySort(array, leftBorder, rightMarker);
        }
    }
}
