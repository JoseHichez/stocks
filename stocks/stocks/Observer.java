package stocks;
import java.util.Map;

public interface Observer {

   public void update(Map<String, Double> priceData);
}