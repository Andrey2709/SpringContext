package ru.homeworke.context;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Component
@Scope("prototype")
public class Cart {

    private ArrayList<Product> products;


    public Cart() {
    }

    @PostConstruct
    public ArrayList<Product> create() {
        return products = new ArrayList<Product>();
    }

    public void stack(Product p){
        products.add(p);
        System.out.println("Товар: ("+p.getTitle()+ ")добавлен в корзину");
    }


    public void removeProduct(Product p){
        products.remove(p);
        System.out.println("Товар: ("+p.getTitle()+") убран из вашей корзины");
    }

    public void showAll(){
        for (int i = 0; i < products.size(); i++) {
            if(products.isEmpty()){
                System.out.println("Пусто");
            }
            System.out.println(products.get(i).toString());
        }
    }

}
