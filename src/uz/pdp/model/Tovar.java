package uz.pdp.model;

public class Tovar extends Model{

    private String category;
    private double price;


    public Tovar(String sortProperty, String name, String category, double price) {
        super(sortProperty, name);
        this.category = category;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "||" +
                " | " + super.getId() + '\'' +
                " | " + super.getName() + '\'' +
                " | " + this.category + '\'' +
                " | " + this.price +
                "$ |";
    }
}
