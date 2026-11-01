package org.example;

// A PhysicalProduct IS-A Product because it can be used anywhere a Product
// is expected: it has an id, name and price, and is simply shipped as well.
// A ShoppingCart would NOT pass this test: a cart is not a kind of product,
// it contains products (HAS-A), so it needs a List<Product> field, not extends.
public class PhysicalProduct extends Product implements Discountable {

    private double weightKg;
    private String dimensions;
    private double discountedPrice;

    public PhysicalProduct() {
    }

    public PhysicalProduct(Long id, String name, double price,
                           double weightKg, String dimensions) {
        super(id, name, price);   // MUST be the first statement
        this.weightKg = weightKg;
        this.dimensions = dimensions;
        this.discountedPrice = price;
    }

    @Override
    public String getSummary() {
        return "Physical: " + getName()
                + " | Weight: " + weightKg + "kg";
    }

    @Override
    public void applyDiscount(double rate) {
        // Shipping is never discounted, so the rate is capped at 20%.
        double capped = Math.min(rate, 0.20);
        this.discountedPrice = getPrice() * (1 - capped);
    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public String getDimensions() {
        return dimensions;
    }
}