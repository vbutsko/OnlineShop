package by.expertsoft.butko.phone;

import by.expertsoft.butko.dao.GenericDao;

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

    public double getTotal(){
        double total = 0.0;
        for(CartItem cartItem: cartItemList){
            total += ((Phone)daoService.getById(cartItem.getProductId())).getPrice() * cartItem.getAmount();
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
