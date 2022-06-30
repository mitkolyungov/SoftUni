import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {

    static class Product {
        private String name;
        private double price;
        private int quantity;

        public Product(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<Product, Double> productsInfo = new LinkedHashMap<> ();

        String command = scanner.nextLine ();

        while (!command.equals ("buy")) {
            String[] tokens = command.split ("\\s+");

            String name = tokens[0];
            double price = Double.parseDouble (tokens[1]);
            int quantity = Integer.parseInt (tokens[2]);


            if (productsInfo.keySet ().stream ().map (Product::getName).anyMatch (n -> n.equals (name))) {

                int currentQuantity = productsInfo.keySet ().stream ()
                        .filter (e -> e.getName ().equals (name))
                        .findFirst ().get ().getQuantity ();

                Product product = productsInfo.keySet ().stream ()
                        .filter (e -> e.getName ().equals (name))
                        .findFirst ().get ();

                product.setPrice (price);
                product.setQuantity (currentQuantity + quantity);

                productsInfo.put (product, product.getPrice () * product.getQuantity ());
            } else {
                Product product = new Product (name, price, quantity);
                productsInfo.put (product, price * quantity);
            }
            command = scanner.nextLine ();
        }

        for (Map.Entry<Product, Double> productDoubleEntry : productsInfo.entrySet ()) {
            System.out.printf ("%s -> %.2f%n"
                    , productDoubleEntry.getKey ().getName (), productDoubleEntry.getValue ());
        }
    }
}
