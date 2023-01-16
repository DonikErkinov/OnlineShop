package uz.pdp;

import uz.pdp.service.ModelService;
import uz.pdp.service.Payment;
import uz.pdp.model.Korzinka;
import uz.pdp.model.Tovar;
import uz.pdp.model.User;

import java.util.List;
import java.util.Scanner;

public class Main {
    Scanner scannerInt = new Scanner(System.in);
    Scanner scannerStr = new Scanner(System.in);
    Payment payment = new Payment();
    ModelService goodModelActivity = new ModelService();
    ModelService userModelActivity = new ModelService();
    int check=1;

    public static void main(String[] args) {
        Main main = new Main();

        User admin = new User("SuperAdmin", "Admin", "superAdmin", "1234");
        main.userModelActivity.addItem(admin);

        main.homePanel();

    }

    public void homePanel() {
        int stepCode = 1;

        while (stepCode != 0) {

            System.out.println("1. Sign in\t2. Sign up\t0. Exit");
            System.out.print("|> ");
            stepCode = scannerInt.nextInt();
            System.out.println("|⩶⩶⩶⩶⩶⩶⩶⩶⩶⩶⩶⩶⩶⩶\n");

            if (stepCode == 1) {
                System.out.print("Enter username: ");
                String username = scannerStr.nextLine();

                System.out.print("Enter password: ");
                String password = scannerStr.nextLine();

                User result = (User) userModelActivity.login(username, password);

                if (result != null) {
                    switch (result.getSortProperty()) {
                        case "Shop Owner": {
                            shopOwnerPanel(result);
                        }
                        break;
                        case "Customer": {
                            customerPanel(result);
                        }
                        break;
                        case "SuperAdmin": {
                            shopAvtorizatsiya();
                        }
                    }
                } else {
                    System.out.println("This User does not exist ❌");
                }
            } else if (stepCode == 2) {
                System.out.println("\nDo you want to create your Own Profile as Customer!");
                System.out.println("yes-1|no-0");
                System.out.print("|>");
                int option = scannerInt.nextInt();
                if (option == 1) {
                    customerSignUpPanel();
                }
            }
        }
    }

    public void shopAvtorizatsiya() {
        int stepCode2 = 1;
        while (stepCode2 != 0) {

            System.out.println("1. Create Shop\t0.Exit");
            System.out.print("|> ");
            stepCode2 = scannerInt.nextInt();
            System.out.println("|⩶⩶⩶⩶⩶⩶⩶⩶⩶⩶⩶⩶⩶⩶\n");

            switch (stepCode2) {
                case 1:{
                    if (check<2){
                        System.out.print("Enter shop owner name: ");
                        String name = scannerStr.nextLine();

                        System.out.print("Enter Username: ");
                        String username = scannerStr.nextLine();

                        System.out.print("Enter shop owner password: ");
                        String password1 = scannerStr.nextLine();

                        User user = new User("Shop Owner", name, username, password1);
                        check++;
                        int result = userModelActivity.addItem(user);
                        switch (result) {
                            case 0: {
                                System.out.println("Process Failed ❌");
                            }
                            break;
                            case 1: {
                                System.out.println("This Shop Already Exist ❗");
                            }
                            break;
                            case 2: {
                                System.out.println("Added Successfully ✔");
                            }
                        }
                    }else System.out.println("Shop has already been created!!! ");
                break;
                    }
            }
        }
    }

    public void shopOwnerPanel(User shopOwner) {
        int stepCode3 = 1;
        while (stepCode3 != 0) {

            System.out.println("1.Create Product\t2.Delete product \t3.Product List\t4.Customer List\t0. Exit");
            System.out.print("|> ");
            stepCode3 = scannerInt.nextInt();
            System.out.println("|⩶⩶⩶⩶⩶⩶⩶⩶⩶⩶⩶⩶⩶⩶\n");

            switch (stepCode3) {
                case 1: {
                    System.out.println("Enter Product Name: ");
                    String name = scannerStr.nextLine();

                    System.out.println("Enter Category: ");
                    String category = scannerStr.nextLine();

                    System.out.println("Enter Price: ");
                    double price = scannerInt.nextDouble();

                    Tovar good = new Tovar(shopOwner.getName(), name, category, price);
                    int result = goodModelActivity.addItem(good);

                    switch (result) {
                        case 0: {
                            System.out.println("Process Failed ❌");
                        }
                        break;
                        case 1: {
                            System.out.println("This Product Already Exist ❗");
                        }
                        break;
                        case 2: {
                            System.out.println("Added Successfully ✔");
                        }
                        break;
                    }

                }
                break;
                case 2: {
                    System.out.println("Enter Product Name: ");
                    String name = scannerStr.nextLine();
                    if (goodModelActivity.deleteItem(name)) {
                        System.out.println("Deleted Successfully ✔");
                    } else System.out.println("Process Failed ❌");
                }
                break;
                case 3: {
                    goodModelActivity.getElements(shopOwner.getName());
                }
                break;
                case 4: {
                    userModelActivity.getAllElements();
                }
                break;
            }
        }
    }

    public void customerSignUpPanel() {

        System.out.print("Enter Name: ");
        String name = scannerStr.nextLine();

        System.out.print("Enter Username: ");
        String username = scannerStr.nextLine();

        System.out.print("Create Password: ");
        String password = scannerStr.nextLine();

        System.out.print("Retype Password: ");
        String password1 = scannerStr.nextLine();

        if (password.equals(password1)) {
            User customer = new User("Customer", name, username, password);
            int result = userModelActivity.addItem(customer);
            switch (result) {
                case 0: {
                    System.out.println("Process failed ❌");
                }
                break;
                case 1: {
                    System.out.println("This customer already exist ❗");
                }
                break;
                case 2: {
                    System.out.println("Completed Successfully ✔");
                }
                break;
            }
        } else {
            System.out.println("Something is wrong ❗");
            System.out.println("\nProcess failded ❌ Try again!");
        }

    }

    public void customerPanel(User user) {

        int stepCode1 = 3;

        while (stepCode1 != 0) {
            List<String> categories = goodModelActivity.getMenuList();
            for (int i = 0; i < categories.size(); i++) {
                System.out.print(i + 1 + "." + categories.get(i) + "\t");
            }

            System.out.println("0.Exit");
            System.out.print("|> ");
            stepCode1 = scannerInt.nextInt();
            System.out.println("|⩶⩶⩶⩶⩶⩶⩶⩶⩶⩶⩶⩶⩶⩶\n");

            int stepcode2 = 0;
            if (stepCode1 != 0) {
                goodModelActivity.getCategoryItems(categories.get(stepCode1 - 1));
                stepcode2 = 1;
            }

            while (stepcode2 != 0) {

                System.out.println("1. Add Cart \t2.Cart List \t0.Exit");
                System.out.print("|> ");
                stepcode2 = scannerInt.nextInt();
                System.out.println("|⩶⩶⩶⩶⩶⩶⩶⩶⩶⩶⩶⩶⩶⩶\n");
                Tovar good;
                switch (stepcode2) {
                    case 1: {
                        System.out.print("Enter Product Name|> ");
                        String productName = scannerStr.nextLine();
                        good = (Tovar) goodModelActivity.checkItem(productName);

                        if (good != null) {
                            System.out.print("Enter amount: ");
                            double amount = scannerInt.nextDouble();
                            int result = user.addCart(new Korzinka(good, amount));

                            switch (result) {
                                case 0: {
                                    System.out.println("Process Failed ❌");
                                }
                                break;
                                case 1: {
                                    System.out.println("This Product Already Exist ❗");
                                }
                                break;
                                case 2: {
                                    System.out.println("Added Successfully ✔");
                                }
                                break;
                            }
                        } else System.out.println(" This product does not exist ❗");

                    }
                    break;
                    case 2: {
                        user.getProductList();

                        int stepcode3 = 1;
                        while (stepcode3 != 0) {
                            System.out.println("1.Remove Product\t2.Buy now\t0.Exit");
                            System.out.print("|> ");
                            stepcode3 = scannerInt.nextInt();
                            System.out.println("|⩶⩶⩶⩶⩶⩶⩶⩶⩶⩶⩶⩶⩶⩶\n");

                            switch (stepcode3) {
                                case 1: {
                                    System.out.print("Enter Product Name|> ");
                                    String productName = scannerStr.nextLine();
                                    good = (Tovar) goodModelActivity.checkItem(productName);

                                    if (good != null) {

                                        boolean result = user.removeFromCart(good);
                                        if (result) {
                                            System.out.println("Completed Successfully ✔");
                                        } else System.out.println("Process Failed ❌");
                                    }
                                    break;

                                }
                                case 2: {
                                    payment.pay(user);
                                }
                                break;
                            }
                        }
                    }
                    break;
                }


            }
        }
    }

}
