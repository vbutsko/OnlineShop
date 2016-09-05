package by.expertsoft.butko.phone;

import java.math.BigDecimal;

/**
 * Created by wladek on 03.09.16.
 */
public class Order extends AbstractCart {
    private BigDecimal deliveryCost = new BigDecimal(5);
    private boolean isDelivered = false;
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

    public boolean isDelivered() {
        return isDelivered;
    }

    public void setDelivered(boolean delivered) {
        isDelivered = delivered;
    }

    public Order(){
        personalInfo = new PersonalInfo();
    }
}
