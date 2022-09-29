package ru.homeworke.context;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;

@Component
public class ProductRepository {

    private ArrayList<Product> listProducts;


    public ProductRepository() {
    }

    public ProductRepository(ArrayList<Product> listProducts) {
        this.listProducts = listProducts;
    }

    @PostConstruct
    public void initRepo() {
        listProducts = new ArrayList<>(Arrays.asList(
                new Product(1, "Валенки", 500.00),
                new Product(2, "Кросовки", 1500.00),
                new Product(3, "Туфли", 5000.00),
                new Product(4, "Берцы", 3000.00),
                new Product(5, "Балетки", 1200.00)
        ));
    }

    public void showAll() {
        for (int i = 0; i < listProducts.size(); i++) {
            System.out.println(listProducts.get(i).toString());
        }
    }

    public void showThis(int id) {
        System.out.println(listProducts.get(id).toString());
    }

    public Product getProduct(int id) {
        for (Product p : listProducts) {
            if (p.getId() == id)
                return p;
        }
        System.out.println("Нет такого товара");
        return null;
    }

    public void manual() {
        System.out.println("Чтобы положить товар в корзину введите номер товара");
        System.out.println("Чтобы удалить товар из корзины введите - delete + номер товара");
    }

}
