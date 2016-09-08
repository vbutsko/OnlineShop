package by.expertsoft.butko.cart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wladek on 03.09.16.
 */
public abstract class AbstractCart<T extends AbstractCartItem> {
    protected BigDecimal totalCost = new BigDecimal(0);
    protected List<T> cartItemList = new ArrayList<>();
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
    public BigDecimal getTotalCost(){
        return totalCost;
    }
    public void setCartItemList(List<T> cartItemList){
        this.cartItemList = cartItemList;
    }
    public List<T> getCartItemList(){
        return cartItemList;
    }
}
