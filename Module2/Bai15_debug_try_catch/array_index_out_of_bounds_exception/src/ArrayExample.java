import java.util.Random;
import java.util.Scanner;

public class ArrayExample {
    public Integer[] createRandom() {
        Random rand = new Random();
        Integer[] arr = new Integer[10];
        System.out.println("Danh sách phần tử của mảng: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt();
            System.out.println(arr[i]+" ");
        }
        return arr;
    }

    public static void main(String[] args) {
        ArrayExample example = new ArrayExample();
        Integer[] arr = example.createRandom();
        Scanner scan = new Scanner(System.in);
        System.out.println("Vui lòng nhập 1 số phần tử bất kỳ: ");
        int x = scan.nextInt();
        try {
            System.out.println("Chỉ số của "+x+ " là "+arr[x]);
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Chỉ số vượt quá giới hạn của mảng.");
        }
    }
}
