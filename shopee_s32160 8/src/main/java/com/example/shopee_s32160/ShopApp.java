import java.util.Scanner;

public class ShopApp {
    public static void main(String[] args) {
        Shop shop = new Shop();
        shop.addProduct(new Product("Mleko", 2.5));
        shop.addProduct(new Product("Piwo", 5.0));
        shop.addProduct(new Product("Chleb", 3.0));

        Client client = new Client("Jan", 20.0);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWitaj, " + client.getName() + "! Twoje saldo: " + client.getBalance() + " PLN");
            shop.displayProducts();
            System.out.print("Wybierz numer produktu do zakupu (0 aby zakończyć): ");
            
            int choice = scanner.nextInt();
            if (choice == 0) break;

            Product product = shop.getProduct(choice - 1);
            if (product != null && client.canAfford(product.getPrice())) {
                client.deductBalance(product.getPrice());
                System.out.println("✅ Zakupiono: " + product.getName());
            } else {
                System.out.println("❌ Brak środków lub zły wybór!");
            }
        }

        System.out.println("🛒 Zakupy zakończone! Pozostałe saldo: " + client.getBalance() + " PLN");
    }
}
