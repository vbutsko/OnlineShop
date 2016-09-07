package by.expertsoft.butko.cart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wladek on 03.09.16.
 */
public abstract class AbstractCart {
    protected BigDecimal totalCost = new BigDecimal(0);
    protected List<AbstractCartItem> cartItemList = new ArrayList<>();
    public int getCartSize(){
        return cartItemList.size();
    }
    public int getTotalAmount() {
        int amount = 0;
        for(AbstractCartItem cartItem: cartItemList){
            amount += cartItem.getAmount();
        }
        return amount;
    }
    public abstract BigDecimal getTotalCost();
    public void setCartItemList(List<AbstractCartItem> cartItemList){
        this.cartItemList = cartItemList;
    }
    public List<AbstractCartItem> getCartItemList(){
        return cartItemList;
    }
}
