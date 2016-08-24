package by.expertsoft.butko.model;

import java.util.ArrayList;
import java.util.List;


public class Cart {
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
    public void addOrder(CartItem order){
        cartItemList.add(order);
    }

    public void deleteOrder(int order_id){
        cartItemList.remove(order_id);
    }

    public int getOrdersSize(){
        return cartItemList.size();
    }

    public CartItem getOrderById(int id){
        return cartItemList.get(id);
    }

    public double getTotal(){
        double total = 0.0;
        for(CartItem order: cartItemList){
            total += order.getCost() * order.getAmount();
        }
        return total;
    }
}
