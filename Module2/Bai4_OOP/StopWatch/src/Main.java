import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[100000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10000);
        }

        StopWatch stopWatch = new StopWatch();

        stopWatch.star();
        selectionSort(arr);
        stopWatch.stop();
        long elapsedTime = stopWatch.getElapsedTime();
        System.out.println("Thời gian thực thi của thuật toán sắp xếp chọn là: "+elapsedTime+ " milliseconds");
    }

    //Thuat toan sap xep chon
    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}