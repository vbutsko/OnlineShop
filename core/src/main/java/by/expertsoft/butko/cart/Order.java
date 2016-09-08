package by.expertsoft.butko.cart;

import java.math.BigDecimal;

/**
 * Created by wladek on 03.09.16.
 */
public class Order extends AbstractCart<OrderItem> {
    private BigDecimal deliveryPrice = new BigDecimal(5);
    private String orderId;
    private boolean deliveredStatus = false;
    private PersonalInfo personalInfo;

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public Order(){
        personalInfo = new PersonalInfo();
    }

    public Order(BigDecimal total_cost){
        this();
        this.totalCost = total_cost;
    }

    public BigDecimal getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(BigDecimal deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public boolean getDeliveredStatus() {
        return deliveredStatus;
    }

    public void setDeliveredStatus(boolean deliveredStatus) {
        this.deliveredStatus = deliveredStatus;
    }

}
