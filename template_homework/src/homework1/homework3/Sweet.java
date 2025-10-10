package homework3;

public abstract class Sweet {
    private String name;
    private double weight;
    private double price;

    public Sweet(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }
    public String getName() {
        return name;
        toString();
    }

    public double getPrice() {
        return price;
    }
    public double getWeight() {
        return weight;
    }

    public abstract String uniqueParam();
}
