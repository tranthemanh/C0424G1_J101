import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        //viet pattern dau vao co phai la email hay khong
        /*
        VD: 123@gmail.com
        huy23@gmail.com
        -Phan tich:
            -> email: 3 phần: x@gmail.com
                => phan dau tien x: ca chu va so: [a-zA-Z0-9]
                => phan duoi: @gmail.com
         */
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+@+[a-zA-Z]+(\\.[a-zA-Z]+)+$");
        Matcher matcher = pattern.matcher("abc@gmail.vn");
        boolean found = matcher.matches();
        System.out.println(found);


        /*
        vd: https://
         */
    }
}
