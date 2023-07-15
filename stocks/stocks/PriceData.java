package stocks;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class PriceData implements Subject{

   private Map<String, Double> prices;
   private ArrayList<Observer> observers;

   public PriceData() {
       prices = new HashMap<String, Double>();
       observers = new ArrayList<Observer>();
   }

   public void pricesChanged()
   {
       notifyObserver();
   }
   @Override
   public void registerObserver(Observer o) {
       observers.add(o);
     
   }
   @Override
   public void removeObserver(Observer o) {
       int i= observers.indexOf(o);
       if(i>=0)
           observers.remove(i);
     
   }
   @Override
   public void notifyObserver() {
       for(int i=0; i<observers.size(); i++)
       {
           Observer observer = (Observer) observers.get(i);
           observer.update(prices);
       }
     
   }

   public void setPrices(Map<String, Double> newPrices)
   {
       this.prices = newPrices;
       pricesChanged();
   }

   public Map<String, Double> getPrices()
   {
       return prices;
   }
}
