import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.homeworke.context.Cart;
import ru.homeworke.context.Product;
import ru.homeworke.context.ProductRepository;

import java.util.Scanner;

public class MainService {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.homeworke.context");
        Product p = context.getBean(Product.class);
        Cart cart = context.getBean(Cart.class);
        ProductRepository repo = context.getBean(ProductRepository.class);
        System.out.println("Добро пожаловать в секретный обувной магазин!");
        Scanner scanner = new Scanner(System.in);
        repo.manual();
        int id;
        String title;

        while (true) {
            System.out.println("Наш товар :");
            repo.showAll();
            System.out.println("Корзина: ");
            cart.showAll();
            System.out.println("Введиет номер товара или 0 если хотите удалить товар из корзины:");
            id = scanner.nextInt();
            if (id == 0) {
                System.out.println("Введите номер товара для удаления:");
                id = scanner.nextInt();
                cart.removeProduct(repo.getProduct(id));
            } else {
                cart.stack(repo.getProduct(id));
            }
        }

    }


}
