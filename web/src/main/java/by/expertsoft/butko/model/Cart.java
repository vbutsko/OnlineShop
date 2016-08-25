package by.expertsoft.butko.model;

import by.expertsoft.butko.dao.DAO;

import java.util.ArrayList;
import java.util.List;


public class Cart {

    private DAO daoService;

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
            total += ((Mobile)daoService.getById(cartItem.getProductId())).getCost() * cartItem.getAmount();
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

    public void setDaoService(DAO daoService) {
        this.daoService = daoService;
    }
}
