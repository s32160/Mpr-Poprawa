import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void displayProducts() {
        System.out.println("Dostępne produkty:");
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            System.out.println((i + 1) + ". " + p.getName() + " - " + p.getPrice() + " PLN");
        }
    }

    public Product getProduct(int index) {
        if (index >= 0 && index < products.size()) {
            return products.get(index);
        }
        return null;
    }
}
