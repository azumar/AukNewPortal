

package cart;

import entity.Payitem;


public class RegistrationCartItem {
    Payitem payitem;

    public Payitem getPayitem() {
        return payitem;
    }
    public  RegistrationCartItem (Payitem payitem) {
  this.payitem =payitem;
}
     public double getTotal() {
        double amount = 0;
        amount = this.payitem.getItemamount().doubleValue();//(this.getQuantity() * product.getPrice().doubleValue());
        return amount;
    }
}
