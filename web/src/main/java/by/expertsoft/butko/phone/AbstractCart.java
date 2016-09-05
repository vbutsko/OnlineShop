package by.expertsoft.butko.phone;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by wladek on 03.09.16.
 */
public abstract class AbstractCart {
    protected BigDecimal totalCost = new BigDecimal(0);
    @Valid
    protected List<AbstractCartItem> cartItemList;
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
