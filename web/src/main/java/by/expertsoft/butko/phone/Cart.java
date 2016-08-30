package by.expertsoft.butko.phone;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class Cart {

    private BigDecimal totalCost = new BigDecimal(0);
    @Valid
    private List<CartItem> cartItemList;

    public void addCartItem(int productId, int amount){
        for(CartItem cartItem: cartItemList){
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

    public int getTotalAmount(){
        int amount = 0;
        for(CartItem cartItem: cartItemList){
            amount += cartItem.getAmount();
        }
        return amount;
    }

    public CartItem getCartItemById(int id){
        return cartItemList.get(id);
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost){
        this.totalCost = totalCost;
    }

    public void setCartItemList(List<CartItem> cartItemList){
        this.cartItemList = cartItemList;
    }

    public List<CartItem> getCartItemList(){
        return cartItemList;
    }

    public Cart(){
        cartItemList = new ArrayList<CartItem>();
    }
}
