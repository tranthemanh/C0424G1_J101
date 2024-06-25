import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 7, 9, 10, 2, 8, 5};

//        //Sắp xếp nổi bọt
//        boolean check = true;
//        for (int i = 1; i < arr.length && check; i++) {
//            check = false;
//            for (int j = 0; j < arr.length-i; j++) {
//                if (arr[j] > arr[j+1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//                    check = true;
//                    System.out.println(Arrays.toString(arr));
//                }
//            }
//        }

//        //Sắp xếp chọn
//        for (int i = 0; i < arr.length-1; i++) {
//            int min = i;
//            int valueMin = arr[i];
//            for (int j = i+1; j < arr.length; j++) {
//                if(valueMin > arr[j]) {
//                    valueMin = arr[j];
//                    min = j;
//                }
//            }
//            if(min != i) {
//                arr[min] = arr[i];
//                arr[i] = valueMin;
//            }
//            System.out.println(Arrays.toString(arr));
//        }

        //Sắp xếp chèn
        for (int i = 1; i < arr.length; i++){
            int value = arr[i];
            int j = i - 1;
            while ((j>-1) && (arr[j]>value)){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = value;
            System.out.println(Arrays.toString(arr));
        }

    }
}
