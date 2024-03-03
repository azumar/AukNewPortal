

package cart;

import entity.Payitem;
import java.util.*;


public class RegistrationCart {
  public   List<RegistrationCartItem> items ;
  public    int numberOfItems;
    double total;
    
    public RegistrationCart() {
         items = new ArrayList<RegistrationCartItem>();
        numberOfItems = 0;
        total = 0;
        
    }
    public synchronized void addItem(Payitem payitem) {

        boolean newItem = true;

        for (RegistrationCartItem regItem : items) {

            if (regItem.payitem.getPayitemPK().getId() == payitem.getPayitemPK().getId() ) {

                newItem = false;
               //send erro item already exist
            }
        }

        if (newItem) {
            RegistrationCartItem regItem = new RegistrationCartItem(payitem);
            items.add(regItem);
        }
    }
    public synchronized int getNumberOfItems() {

        numberOfItems = 0;

        for (RegistrationCartItem scItem : items) {

            numberOfItems += 1;
        }

        return numberOfItems;
    }
     public synchronized void clear() {
        items.clear();
        numberOfItems = 0;
        total = 0;
    }
     public synchronized double getSubtotal() {

        double amount = 0;

        for (RegistrationCartItem scItem : items) {

            Payitem service= (Payitem) scItem.getPayitem();
            amount += service.getItemamount().doubleValue();//(scItem.getQuantity() * product.getPrice().doubleValue());
        }

        return amount;
    }
      public synchronized List<RegistrationCartItem> getItems() {

        return items;
    }

    
}
