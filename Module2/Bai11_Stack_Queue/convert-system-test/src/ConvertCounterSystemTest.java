import java.util.Scanner;

public class ConvertCounterSystemTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ConvertSystem convertSystem = new ConvertCounterSystem();
        int choice;
        do {
            System.out.println("Menu");
            System.out.println("1. Chuyen so thap phan sang nhi phan.");
            System.out.println("2. Chuyen so thap phan sang bat phan.");
            System.out.println("3. Chuyen so thap phan sang thap luc phan.");
            System.out.println("4. Chuyen so thap luc phan sang thap phan.");
            System.out.println("5. Exit");
            System.out.println("Nhap lua chon:");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Nhap so thap phan: ");
                    int number = sc.nextInt();
                    System.out.println("Gia tri nhi phan la: " + convertSystem.convertBinary(number));
                    break;
                case 2:
                    System.out.println("Nhap so thap phan: ");
                    int number1 = sc.nextInt();
                    System.out.println("Gia tri bat phan la: " + convertSystem.convertOctal(number1));
                    break;
                case 3:
                    System.out.println("Nhap so thap phan: ");
                    int number2 = sc.nextInt();
                    System.out.println("Gia tri thap luc phan la: "+convertSystem.convertHexadecimal(number2));
                    break;
                case 4:
                    System.out.println("Nhap so thap luc phan: ");
                    String hex = sc.nextLine();
                    System.out.println("Gia tri thap phan la: "+ convertSystem.convertDecimal(hex));
                    break;
                case 5:
                    System.exit(0);
            }
        } while (choice != 5);
    }
}
