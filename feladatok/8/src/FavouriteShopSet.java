import java.util.*;

public class FavouriteShopSet {
    private Set<String> shops;

    public FavouriteShopSet() {
        this.shops = new TreeSet<>();
    }

    public void addShop(String shop){
        this.shops.add(shop);
    }

    public int countShops(){
        return this.shops.size();
    }

    public boolean isFavourite(String shop){
        return this.shops.contains(shop);
    }

    public void printShops(){
        for (String shop : this.shops){
            System.out.println(shop);
        }
    }

    public void delete(String shop) {
        this.shops.remove(shop);
    }
}
