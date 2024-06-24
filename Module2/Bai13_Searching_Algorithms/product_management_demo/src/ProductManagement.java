import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductManagement {
    List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(int id, String name, double price) {
        for (Product product : products) {
            if (product.getId() == id) {
                product.setName(name);
                product.setPrice(price);
                return;
            }
        }
        System.out.println("Khong co san pham nao co id tren.");
    }

    public void deleteProduct(int id) {
        products.removeIf(product -> product.getId() == id);
    }

    public void displayProduct() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void seachProductByName(String name) {
        boolean resluts = false;
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                System.out.println(product);
                resluts = true;
            }
        }
        if (!resluts) {
            System.out.println("Khong co sinh vien nao phu hop.");
        }
    }

    public void sortProductsByPriceAscending() {
        products.sort(Comparator.comparingDouble(Product::getPrice));
        displayProduct();
    }

    public void sortProductsByPriceDescending() {
        products.sort((p1,p2) -> Double.compare(p2.getPrice(), p1.getPrice()));
        displayProduct();
    }
}
