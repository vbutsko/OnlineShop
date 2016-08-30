package by.expertsoft.butko.service;

import by.expertsoft.butko.dao.phone.PhoneDao;
import by.expertsoft.butko.phone.Cart;
import by.expertsoft.butko.phone.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.format.IntegerNumberFormatFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wladek on 25.08.16.
 */
@Service
public class CartService {
    public final String cartName = getClass().getName().toString() + "_cart";
    @Autowired
    private PhoneDao daoService;
    // addCartItem(request, productId, int quantity) ??
    // updateItems(req, Map<productId, quantity) ??
    public void addCartItem(HttpServletRequest request, int productId, int amount){
        Cart cart = getCart(request);
        cart.addCartItem(productId, amount);
        setTotalCost(cart);
        setCart(request, cart);
    }
    public Cart getCart(HttpServletRequest request){
        Cart cart = (Cart)request.getSession().getAttribute(cartName);
        if(cart == null){
            cart = new Cart();
            setCart(request, cart);
        }
        return cart;
    }
    public void setCart(HttpServletRequest request ,Cart cart){
        request.getSession().setAttribute(cartName, cart);
    }
    public void deleteCartItem(HttpServletRequest request, int cartItemProductId){
        Cart cart = getCart(request);
        cart.deleteCartItem(cartItemProductId);
        setTotalCost(cart);
        setCart(request, cart);
    }
    private void setTotalCost(Cart cart){
        BigDecimal totalCost = new BigDecimal(0);
        for(CartItem cartItem: cart.getCartItemList()){
            totalCost = totalCost.add((daoService.getById(cartItem.getProductId())).getPrice().multiply(BigDecimal.valueOf(cartItem.getAmount())));
        }
        cart.setTotalCost(totalCost);
    }
    public String getCartItemName(int productId){
        return daoService.getById(productId).getName();
    }
    public List getCartItemNamesList(Cart cart){
        List result = new ArrayList(cart.getCartSize());
        for(CartItem cartItem: cart.getCartItemList()){
            result.add(getCartItemName(cartItem.getProductId()));
        }
        return result;
    }

    public void updateCart(HttpServletRequest request, Map<Integer, Integer> cartMap){
        Cart cart = getCart(request);
        for(CartItem cartItem: cart.getCartItemList()){
            cartItem.setAmount(cartMap.get(cartItem.getProductId()));
        }
        setCart(request, cart);
    }
}
