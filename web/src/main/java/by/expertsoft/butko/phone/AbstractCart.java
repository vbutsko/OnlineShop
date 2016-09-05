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

    public void addCartItem(int productId, int amount){
        for(AbstractCartItem cartItem: cartItemList){
            if(productId == cartItem.getProductId()){
                cartItem.setAmount(cartItem.getAmount() + amount);
                return;
            }
        }
        CartItem cartItem = new CartItem();
        cartItem.setAmount(amount);
        cartItem.setProductId(productId);
        cartItemList.add(cartItem);
    }

    public void deleteCartItem(int cartItemProductId) {
        for (int i = 0; i < cartItemList.size(); i++) {
            if(cartItemList.get(i).getProductId() == cartItemProductId) {
                cartItemList.remove(i);
                return;
            }
        }
    }

    public int getCartSize(){
        return cartItemList.size();
    }

    public abstract int getTotalAmount();

    public CartItem getCartItemById(int id){
        return (CartItem) cartItemList.get(id);
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost){
        this.totalCost = totalCost;
    }

    public void setCartItemList(List<AbstractCartItem> cartItemList){
        this.cartItemList = cartItemList;
    }

    public List<? extends AbstractCartItem> getCartItemList(){
        return cartItemList;
    }
}
