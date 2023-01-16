package uz.pdp.model;

public class Korzinka {

    Tovar good;
    private double amount;

    public Korzinka(Tovar good, double amount) {
        this.good = good;
        this.amount = amount;
    }

    public Korzinka() {
    }

    public Tovar getTovar() {
        return good;
    }

    public void setTovar(Tovar good) {
        this.good = good;
    }

    public double getQuant() {
        return amount;
    }

    public void setQuant(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return  " | " + good +
                ", | " + amount +
                " |";
    }
}
