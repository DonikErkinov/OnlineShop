package uz.pdp.model;

import java.util.ArrayList;
import java.util.List;

public class User extends Model{

    private String userName;
    private String password;
    private List<Korzinka> korzinka;


    public User(String sortProperty, String name, String userName, String password) {
        super(sortProperty, name);
        this.userName = userName;
        this.password = password;
        korzinka=new ArrayList<>();

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int addCart(Korzinka korzinka){
        if (isProductExsist(korzinka.getTovar())) return 1;

        return this.korzinka.add(korzinka) ? 2: 0;
    }

    public boolean removeFromCart(Tovar product){
        for (int i = 0; i <korzinka.size(); i++) {
            if(korzinka.get(i).getTovar().equals(product)){
                korzinka.remove(i);
                return true;
            }
        }
        return false;

    }
    public boolean clearCart(){
       korzinka =new ArrayList<>();
       return true;
    }


    public boolean isProductExsist(Tovar product){
        for (Korzinka korzinka : this.korzinka) {
            if (korzinka.getTovar().getName().equals(product.getName()))return true;
        }
        return false;
    }

    public void getProductList(){
        System.out.println("↱—————————————————{ Your Cart }—————————————————↰");
        double summa=0;
        for (int i = 0; i <this.korzinka.size(); i++) {
            System.out.println((i+1)+". "+korzinka.get(i));
            summa+=korzinka.get(i).getQuant()*korzinka.get(i).getTovar().getPrice();
        }
        System.out.println("\nTotal: "+summa+"$ ");
    }

    @Override
    public String toString() {
        return "||" +
                "id='" + super.getId() + '\'' +
                "| Name='" + super.getName() + '\'' +
                "| userName='" + userName + '\'' +
                "| password='" + password + '\'' +
                '|';
    }
}
