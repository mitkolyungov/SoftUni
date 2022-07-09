import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName (name);
        setMoney (money);
        this.products = new ArrayList<> ();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.trim ().isEmpty ()) {
            throw new IllegalArgumentException ("Name cannot be empty");
        } else {
            this.name = name;
        }
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException ("Money cannot be negative");
        } else {
            this.money = money;
        }
    }

    public void buyProduct(Product product) {
        if (this.money >= product.getCost ()) {
            products.add (product);
            this.money -= product.getCost ();
        } else {
            String message = getName () + " can't afford " + product.getName ();
            throw new IllegalArgumentException (message);
        }
    }

    @Override
    public String toString() {
        String postfix = this.products.size () > 0 ?
                products.stream ()
                        .map (Product::getName)
                        .collect (Collectors.joining (", "))
                : "Nothing bought";
        return this.name + " - " + postfix;
    }
}
