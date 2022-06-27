public enum DiscountType {
    VIP (20),
    SecondVisit (10),
    None (0);

    int discount;

    DiscountType(int discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return 1 - 1.0 * discount / 100;
    }
}
