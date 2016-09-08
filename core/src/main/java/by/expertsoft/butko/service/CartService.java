package by.expertsoft.butko.service;

import by.expertsoft.butko.dao.phone.PhoneDao;
import by.expertsoft.butko.cart.AbstractCartItem;
import by.expertsoft.butko.cart.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wladek on 25.08.16.
 * move to core?
 */
@Service
@Scope("session")
// TODO: session scope, remove request dependency
public class CartService {
    private Cart cart;

    @Autowired
    private PhoneDao jdbcPhoneDao;

    public void addCartItem(int productId, int amount){
        Cart cart = getCart();
        cart.addCartItem(productId, amount);
        setTotalCost();
        setCart(cart);
    }
    public Cart getCart(){
        if(cart == null){
            cart = new Cart();
            setCart(cart);
        }
        return cart;
    }
    public void setCart(Cart cart){
        this.cart = cart;
    }
    public void deleteCartItem(int cartItemProductId){
        Cart cart = getCart();
        cart.deleteCartItem(cartItemProductId);
        setTotalCost();
        setCart(cart);
    }
    private void setTotalCost(){
        BigDecimal totalCost = new BigDecimal(0);
        for(AbstractCartItem cartItem: cart.getCartItemList()){
            totalCost = totalCost.add((jdbcPhoneDao.getById(cartItem.getProductId())).getPrice().multiply(BigDecimal.valueOf(cartItem.getAmount())));
        }
        cart.setTotalCost(totalCost);
    }
    public String getCartItemName(int productId){
        return jdbcPhoneDao.getById(productId).getName();
    }
    public List getCartItemNamesList(Cart cart){
        List result = new ArrayList(cart.getCartSize());
        for(AbstractCartItem cartItem: cart.getCartItemList()){
            result.add(getCartItemName(cartItem.getProductId()));
        }
        return result;
    }
    public void clearCart(){
        cart.getCartItemList().clear();
    }
    public void updateCartItem(Map<Integer, Integer> cartMap){
        Cart cart = getCart();
        for(AbstractCartItem cartItem: cart.getCartItemList()){
            cartItem.setAmount(cartMap.get(cartItem.getProductId()));
        }
        setTotalCost();
        setCart(cart);
    }
}
