package by.expertsoft.butko.phone;

import by.expertsoft.butko.dao.GenericDao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class Cart {

    private GenericDao daoService;

    private List<CartItem> cartItemList;

    public void setCartItemList(List<CartItem> cartItemList){
        this.cartItemList = cartItemList;
    }

    public List<CartItem> getCartItemList(){
        return cartItemList;
    }
    public Cart(){
        cartItemList = new ArrayList<CartItem>();
    }
    public void addCartItem(CartItem cartItem){
        cartItemList.add(cartItem);
    }

    public void deleteCartItem(int cartItemId){
        cartItemList.remove(cartItemId);
    }

    public int getCartSize(){
        return cartItemList.size();
    }

    public CartItem getCartItemById(int id){
        return cartItemList.get(id);
    }

    public BigDecimal getTotal(){
        BigDecimal total = new BigDecimal(0);
        for(CartItem cartItem: cartItemList){
            total = total.add(((Phone)daoService.getById(cartItem.getProductId())).getPrice().multiply(BigDecimal.valueOf(cartItem.getAmount())));
        }
        return total;
    }
    public int getTotalAmount(){
        int amount = 0;
        for(CartItem cartItem: cartItemList){
            amount += cartItem.getAmount();
        }
        return amount;
    }

    public void setDaoService(GenericDao daoService) {
        this.daoService = daoService;
    }
}
