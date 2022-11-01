package Dymura_hw8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product pr1 = new Product(1, "Book", 40, false, LocalDate.of(2022, 1, 15));
        Product pr2 = new Product(2, "Book", 60, true, LocalDate.of(2022, 3, 21));
        Product pr3 = new Product(3, "NewsPaper", 400, false, LocalDate.of(2021, 9, 28));
        Product pr4 = new Product(4, "Book", 260, true, LocalDate.of(2022, 7, 1));
        Product pr5 = new Product(5, "Magazine", 500, true, LocalDate.of(2023, 11, 30));

        List<Product> products = new ArrayList<>(Arrays.asList(pr1, pr2, pr3, pr4, pr5));

        System.out.println(Product.getByTypeAndPrice(products));
        System.out.println(Product.getByDate(products));
        System.out.println(Product.getByTypeAndDiscount(products));
        System.out.println(Product.getFullPrice(products));
        System.out.println(Product.getGroupByType(products));
        System.out.println(Product.getLowestPrice(products));
    }
}
