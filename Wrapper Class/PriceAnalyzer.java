import java.util.ArrayList;
import java.util.Collections;

public class PriceAnalyzer {
    public static void main(String[] args) {
        double[] prices = {10.5, 20.0, 35.75, 5.5};
        
        ArrayList<Double> priceList = new ArrayList<>();
        for (double price : prices) {
            priceList.add(price);
        }
        
        double highestPrice = Collections.max(priceList);
        
        double sum = 0.0;
        for (Double price : priceList) {
            sum += price;
        }
        double averagePrice = sum / priceList.size();
        
        System.out.println("The highest price: " + highestPrice);
        System.out.println("The average price: " + averagePrice);
    }
}
