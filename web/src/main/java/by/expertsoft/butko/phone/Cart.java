package by.expertsoft.butko.phone;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class Cart {

    private BigDecimal totalCost = new BigDecimal(0);
    @Valid
    private List<CartItem> cartItemList;

    public void addCartItem(CartItem cartItem){
        cartItemList.add(cartItem);
    }

    public void deleteCartItem(int cartItemId){
        cartItemList.remove(cartItemId);
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
