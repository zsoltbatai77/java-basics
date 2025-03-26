import java.util.*;

public class BestPriceFinder {
    private Map<String, String> bestBuys;

    public BestPriceFinder() {
        this.bestBuys = new HashMap<>();
    }

    public void addProduct(Product product, String shop) {
        this.bestBuys.put(product.getName(), shop);
    }

    public String getShopFor(String product) {
        return this.bestBuys.getOrDefault(product, null);
    }

    public void printBestBuys() {
        for (Map.Entry<String, String> entry : this.bestBuys.entrySet()) {
            System.out.println("Buy " + entry.getKey() + " at " + entry.getValue() + ".");
        }
    }

    public int deleteShop(String shop) {
        int count = 0;
        Iterator<Map.Entry<String, String>> iterator = this.bestBuys.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            if (entry.getValue().equals(shop)) {
                iterator.remove();
                count++;
            }
        }
        return count;
    }
}
