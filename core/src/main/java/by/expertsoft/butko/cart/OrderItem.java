package by.expertsoft.butko.cart;


import java.math.BigDecimal;

/**
 * Created by wladek on 03.09.16.
 */
public class OrderItem extends AbstractCartItem {
    private BigDecimal priceForOne;

    public BigDecimal getPriceForOne() {
        return priceForOne;
    }

    public OrderItem(BigDecimal priceForOne){
        this.priceForOne = priceForOne;
    }
}
