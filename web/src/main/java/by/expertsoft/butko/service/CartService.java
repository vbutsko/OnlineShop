package by.expertsoft.butko.service;

import by.expertsoft.butko.dao.GenericDao;
import by.expertsoft.butko.phone.Cart;
import by.expertsoft.butko.phone.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wladek on 25.08.16.
 */
@Service
public class CartService {

    private GenericDao daoService;

    @Autowired
    public void setDaoService(GenericDao daoService){
        this.daoService = daoService;
    }

    public void addCartItem(HttpServletRequest request, CartItem cartItem){
        Cart cart = getCart(request);
        cart.addCartItem(cartItem);
        setCart(request, cart);
    }
    public Cart getCart(HttpServletRequest request){
        Cart cart = (Cart)request.getSession().getAttribute("cart");
        if(cart == null){
            cart = new Cart();
            cart.setDaoService(daoService);
            setCart(request, cart);
        }
        return cart;
    }
    public void setCart(HttpServletRequest request ,Cart cart){
        request.getSession().setAttribute("cart", cart);
    }
    public void deleteCartItem(HttpServletRequest request, int cartItemId){
        Cart cart = getCart(request);
        cart.deleteCartItem(cartItemId);
        setCart(request, cart);
    }
}
