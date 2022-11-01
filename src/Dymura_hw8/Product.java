package Dymura_hw8;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Product {
    private final int id;
    private final String type;
    private double price;
    private final boolean isDisc;
    private final LocalDate localDate;

    public Product(int id, String type, double price, boolean isDisc, LocalDate localDate) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.isDisc = isDisc;
        this.localDate = localDate;
    }

    static List<Product> getByTypeAndPrice(List<Product> products) {
        return products.stream()
                .filter(p -> p.type.equals("Book") && p.price > 250)
                .collect(Collectors.toList());
    }

    static List<Product> getByTypeAndDiscount(List<Product> products) {
        return products.stream()
                .filter(p -> p.type.equals("Book") && p.isDisc)
                .peek(p -> p.price = p.price * 0.9)
                .collect(Collectors.toList());
    }

    static Product getLowestPrice(List<Product> products) {
        return products.stream()
                .filter(p -> p.type.equals("Book"))
                .min(Comparator.comparing(p -> p.price))
                .orElseThrow(() -> new NoSuchElementException("There is no such book."));
    }

    static List<Product> getByDate(List<Product> products) {
        return products.stream()
                .sorted((p1, p2) -> p2.localDate.compareTo(p1.localDate))
                .limit(3)
                .collect(Collectors.toList());
    }

    static double getFullPrice(List<Product> products) {
        LocalDate localNow = LocalDate.now();
        return products.stream()
                .filter(p -> p.localDate.getYear() == localNow.getYear() && p.type.equals("Book") && p.price < 75)
                .mapToDouble(p -> p.price)
                .sum();
    }

    static Map<String, List<Product>> getGroupByType(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(p -> p.type));
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", isDisc=" + isDisc +
                ", localDate=" + localDate +
                '}';
    }
}
