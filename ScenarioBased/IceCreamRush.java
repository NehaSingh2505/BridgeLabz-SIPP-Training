public class IceCreamRush {
    public static void main(String[] args) {
        String[] iceCreamFlavors = {"Vanilla", "Chocolate", "Strawberry", "Mint", "Cookie Dough","Pistachio","Mango","blackberry"};
        int[] sales = {50, 70, 80,60, 90,110,50,85};
        for(int i = 0 ; i < sales.length-1 ; i++ ) {
            for(int j = 0 ; j < sales.length-1-i ; j++ ){
                if( sales[j] < sales[j+1]) {
                    int tempSales = sales[j];
                    sales[j] = sales[j+1];
                    sales[j+1] = tempSales; 
                    String tempFlavor = iceCreamFlavors[j];
                    iceCreamFlavors[j] = iceCreamFlavors[j+1];
                    iceCreamFlavors[j+1] = tempFlavor;
                }
            }
        }
        System.out.println("Sorted Ice Cream Flavors by Sales : " );
        System.out.println("===================================");
        
        for(int i = 0 ; i < iceCreamFlavors.length ; i++ ) {
            System.out.println(iceCreamFlavors[i] + " - " + sales[i] + " sales");
        }
    }
}