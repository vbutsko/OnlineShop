package by.expertsoft.butko.cart;

import java.math.BigDecimal;

/**
 * Created by wladek on 03.09.16.
 */
public class Order extends AbstractCart {
    private BigDecimal deliveryCost = new BigDecimal(5);
    private int orderId;
    private PersonalInfo personalInfo;

    public BigDecimal getTotalCost() {
        return deliveryCost.add(totalCost);
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public Order(){
        personalInfo = new PersonalInfo();
    }


    public BigDecimal getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(BigDecimal deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
