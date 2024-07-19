import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<User> list = new ArrayList<User>();
        list.add(new User("Manh", 20, "manh@gmail.com", "Van Phong", RoleConst.Role_Admin));
        list.add(new User("Nguyen", 20, "nguyen@gmail.com", "Van Phong", RoleConst.Role_User));
        list.add(new User("Kien", 26, "kien@gmail.com", "Ke Toan", RoleConst.Role_Admin));

        int chon;
        do {
            System.out.println("Menu");
            System.out.println("1. Hien thi so luong cac phan tu role.");
            System.out.println("2. Tim phan tu user qua email.");
            System.out.println("3. Kien phan tu user qua name.");
            System.out.println("4. Exit.");
            System.out.println("Nhap lua chon:");
            chon = sc.nextInt();

            switch (chon) {
                case 1:
                    int roleAdmin = 0;
                    int roleUser = 0;
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getRole() == RoleConst.Role_Admin) {
                            roleAdmin++;
                        } else if (list.get(i).getRole() == RoleConst.Role_User) {
                            roleUser++;
                        }
                    }
                    System.out.println("So luong role Admin: " + roleAdmin);
                    System.out.println("So luong role User: " + roleUser);
                case 2:
                    System.out.println("Nhap email can tim: ");
                    String seachEmail = sc.nextLine();

                    int dem = 0;
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getEmail().equals(seachEmail)) {
                            System.out.println(list.get(i));
                        }else {
                            dem++;
                        }
                    }
                    if (dem == 0) {
                        System.out.println("Khong co email phu hop.");
                    }
                case 3:
                    System.out.println("Nhap ten user can tim: ");
                    String seachNameUser = sc.nextLine();

                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getName().equals(seachNameUser)) {
                            System.out.println(list.get(i));
                        }
                    }
                case 4:
                    System.exit(0);
            }
        } while (chon == 4);
    }
}
