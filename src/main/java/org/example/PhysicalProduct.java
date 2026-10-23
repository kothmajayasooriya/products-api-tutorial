package org.example;

// A PhysicalProduct IS-A Product because it can be used anywhere a Product
// is expected: it has an id, name and price, and is simply shipped as well.
// A ShoppingCart would NOT pass this test: a cart is not a kind of product,
// it contains products (HAS-A), so it needs a List<Product> field, not extends.
public class PhysicalProduct extends Product {

    private double weightKg;
    private String dimensions;

    public PhysicalProduct() {
    }

    public PhysicalProduct(Long id, String name, double price,
                           double weightKg, String dimensions) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public String getDimensions() {
        return dimensions;
    }
}