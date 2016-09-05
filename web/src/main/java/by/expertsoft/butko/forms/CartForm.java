package by.expertsoft.butko.forms;

import by.expertsoft.butko.forms.CartItemForm;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by wladek on 05.09.16.
 */
public class CartForm {
    @Valid
    private List<CartItemForm> cartItemFormList;

    public List<CartItemForm> getCartItemFormList() {
        return cartItemFormList;
    }

    public void setCartItemFormList(List<CartItemForm> cartItemFormList) {
        this.cartItemFormList = cartItemFormList;
    }
}
