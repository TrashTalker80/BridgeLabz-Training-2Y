public class ShoppingCart {
    public static void main(String[] args) {
        String[] prices = {"250", "499", "99", "abc", "150"};
        
        int totalPrice = 0;
        
        for (String priceStr : prices) {
            try {
                int price = Integer.parseInt(priceStr);
                totalPrice += price;
                System.out.println("Added item with price: " + price);
            } catch (NumberFormatException e) {
                System.out.println("Invalid price: " + priceStr + " - Skipped");
            }
        }
        
        System.out.println("\nTotal Price: " + totalPrice);
    }
}
