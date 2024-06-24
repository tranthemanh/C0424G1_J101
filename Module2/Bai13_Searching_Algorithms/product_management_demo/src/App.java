import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductManagement productManagement = new ProductManagement();

        while(true) {
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa thông tin sản phẩm theo id");
            System.out.println("3. Xoá sản phẩm theo id");
            System.out.println("4. Hiển thị danh sách sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên");
            System.out.println("6. Sắp xếp sản phẩm tăng dần theo giá");
            System.out.println("7. Sắp xếp sản phẩm giảm dần theo giá");
            System.out.println("8. Thoát");
            System.out.print("Chọn một tùy chọn: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    System.out.print("Nhập ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nhập tên sản phẩm: ");
                    String name = sc.nextLine();
                    System.out.print("Nhập giá: ");
                    double price = sc.nextDouble();
                    Product product = new Product(id, name, price);
                    productManagement.addProduct(product);
                    break;
                case 2:
                    System.out.print("Nhập ID sản phẩm cần sửa: ");
                    id = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.print("Nhập tên mới: ");
                    name = sc.nextLine();
                    System.out.print("Nhập giá mới: ");
                    price = sc.nextDouble();
                    productManagement.updateProduct(id, name, price);
                    break;
                case 3:
                    System.out.print("Nhập ID sản phẩm cần xoá: ");
                    id = sc.nextInt();
                    productManagement.deleteProduct(id);
                    System.out.println("Xoa san pham thanh cong.");
                    break;
                case 4:
                    productManagement.displayProduct();
                    break;
                case 5:
                    System.out.print("Nhập tên sản phẩm cần tìm: ");
                    name = sc.nextLine();
                    productManagement.seachProductByName(name);
                    break;
                case 6:
                    productManagement.sortProductsByPriceAscending();
                    break;
                case 7:
                    productManagement.sortProductsByPriceDescending();
                    break;
                case 8:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
