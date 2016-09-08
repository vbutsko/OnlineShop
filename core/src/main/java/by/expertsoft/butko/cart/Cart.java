package by.expertsoft.butko.cart;

import java.math.BigDecimal;
import java.util.ArrayList;


public class Cart extends AbstractCart<CartItem>{

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
    public CartItem getCartItemById(int id){
        return (CartItem) cartItemList.get(id);
    }
    public Cart(){
        cartItemList = new ArrayList<CartItem>();
    }
    public void setTotalCost(BigDecimal totalCost){
        this.totalCost = totalCost;
    }
}
