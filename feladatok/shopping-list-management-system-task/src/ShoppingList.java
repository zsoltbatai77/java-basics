import java.util.*;

public class ShoppingList{
    private List<Product> items;

    public ShoppingList() {
        this.items = new ArrayList<>();
    }

    public void addProduct(Product product){
        this.items.add(product);
    }

    public int countProducts(){
        return this.items.size();
    }

    public Product getProduct(int index){
        if (index > countProducts()-1 || index < 0) return null;
        return this.items.get(index);
    }

    public void printProducts() {
        for (Product product : this.items) {
            System.out.println(product.getName());
        }
    }

    public void delete(Product product){
        this.items.remove(product);
    }

    public int deleteUnimportant(){
        int torolt = 0;
        Iterator<Product> iterator = this.items.iterator();

        while(iterator.hasNext()){
            Product product = iterator.next();
            if (!product.isImportant()){
                iterator.remove();
                torolt++;
            }
        }

        return torolt;
    }
}
