import java.util.*;

public class ExtremeShopping {
    private Map<String, List<Product>> extremeList;

    public ExtremeShopping() {
        this.extremeList = new HashMap<>();
    }

    public void addShoppingList(String shop, List<Product> productList) {
        this.extremeList.put(shop, productList);
    }

    public void printShoppingLists() {
        for (Map.Entry<String, List<Product>> entry : this.extremeList.entrySet()) {
            System.out.println(entry.getKey());
            List<Product> products = entry.getValue();
            for (int i = 0; i < products.size(); i++) {
                System.out.print(products.get(i).getName());
                if (i < products.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
