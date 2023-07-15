package stocks;
import java.util.HashMap;
import java.util.Map;

public class PricesDisplay implements Observer, DisplayElement{
   private String tickerSymbols[];
   private String portfolio;
   private Subject priceData;
   private Map<String, Double> prices;


   public PricesDisplay(String portfolio, PriceData pricedata)
   {
       this.portfolio = portfolio;
       this.priceData = pricedata;
       prices = new HashMap<String, Double>();
       priceData.registerObserver(this);
   }

   @Override
   public void display() {
     
       System.out.print("Portfolio #" + portfolio + ", ");
       for(int i=0; i<tickerSymbols.length; i++){
          System.out.print(tickerSymbols[i] + " = " + prices.get(tickerSymbols[i]) + ", ");
       }
       System.out.println();
   }

   @Override
   public void update(Map<String, Double> prices) {
       this.prices = prices;
       display();
   }

   public void setStocks(String[] strings) {
       this.tickerSymbols = strings;
     
   }

}