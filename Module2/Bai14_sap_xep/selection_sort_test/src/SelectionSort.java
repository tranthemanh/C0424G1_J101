import java.util.Arrays;

public class SelectionSort {
    static double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5};

    public static void selectionSort(double[] list) {
        for (int i = 0; i < list.length-1; i++) {
            int minIndex = i;
            double valueMin = list[i];
            for (int j = i + 1; j < list.length; j++) {
                if (valueMin > list[j]) {
                    valueMin = list[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                list[minIndex] = list[i];
                list[i] = valueMin;
            }
        }
    }

    public static void main(String[] args) {
        selectionSort(list);
        System.out.println(Arrays.toString(list));
    }
}
