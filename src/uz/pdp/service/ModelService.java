package uz.pdp.service;

import uz.pdp.model.Model;
import uz.pdp.model.Tovar;
import uz.pdp.model.User;

import java.util.ArrayList;
import java.util.List;

public class ModelService {

    List<Model> list;
    public ModelService() {
        list=new ArrayList<>();
    }

    public Model checkItem(String  name){
        for (Model model1: list){
            if (name.equals(model1.getName()))
                return model1;
        }
        return null;
    }

    public int addItem(Model model){
        if (checkItem(model.getName())!=null)return 1;

        if (list.add(model))return 2;

        return 0;
    }

    public boolean deleteItem(String name){
       /* for (Model model1: list){
             if (model1.getName().equals(name))
                 return list.remove(model1);
        }*/
        for (int i = 0; i <list.size(); i++) {
            if (list.get(i).getName().equals(name)){
                list.remove(i);
                return true;
            }
        }
        return false;
    }

    public void getAllElements(){
        System.out.println("↱—————————————————{ List }—————————————————↰");

        for (Model model: list){
            System.out.println(model.toString());
            System.out.println("|——————————————————————————————————————————————————————————————————|");
        }
    }

    public void getElements(String sortBy){
        System.out.println("↱—————————————————{ List }—————————————————↰");
        for (Model model: list){
            if (model.getSortProperty().equals(sortBy)){
            System.out.println(model.toString());
            System.out.println("|——————————————————————————————————————————————————————————————————|");
            }
        }
    }

    public User login(String userName, String password){
        for (Model model: list){
            if (model instanceof User){
                if (((User) model).getUserName().equals(userName)&&((User) model).getPassword().equals(password)){
                    return (User) model;
                }
            }
        }
        return null;
    }

    public List<String> getMenuList(){
        List<String> categoryList=new ArrayList<>();
        for (Model model: list) {
            if (!categoryList.contains(((Tovar)model).getCategory()))
                categoryList.add(((Tovar)model).getCategory());
        }
        return categoryList;
    }

    public void getCategoryItems(String category){
        System.out.println("↱—————————————————{"+category+" Pruducts }—————————————————↰");
        for (Model model: list ){
            if (((Tovar)model).getCategory().equals(category)){
                System.out.println(model.toString());
                System.out.println("|———————————————————————————————————————————————————|");
            }
        }
    }
}
