package by.expertsoft.butko.phone;

import java.util.ArrayList;


public class Cart extends AbstractCart{

    public int getTotalAmount() {
        int amount = 0;
        for(AbstractCartItem cartItem: cartItemList){
            amount += cartItem.getAmount();
        }
        return amount;
    }
    public Cart(){
        cartItemList = new ArrayList<AbstractCartItem>();
    }
}
