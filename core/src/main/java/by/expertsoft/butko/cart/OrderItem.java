package by.expertsoft.butko.cart;

import by.expertsoft.butko.cart.AbstractCartItem;

/**
 * Created by wladek on 03.09.16.
 */
public class OrderItem extends AbstractCartItem {
    private boolean isDelivered = false;
    private int orderId;

    public boolean getIsDelivered() {
        return isDelivered;
    }

    public void setIsDelivered(boolean delivered) {
        isDelivered = delivered;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
