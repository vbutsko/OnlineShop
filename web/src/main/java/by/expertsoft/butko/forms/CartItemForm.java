package by.expertsoft.butko.forms;

import javax.validation.constraints.Min;

/**
 * Created by wladek on 05.09.16.
 */
public class CartItemForm {
    private int productId;
    @Min(value = 1, message = "amount must be integer greater than 0")
    private int amount;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
