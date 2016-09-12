package by.expertsoft.butko.forms;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by wladek on 05.09.16.
 */
public class CartItemForm {
    private int productId;
    @Min(value=1,
            message = "amount must be greater than 0")
    @Pattern(regexp = "([0-9]*)",
            message = "amount must be integer greater than 0")
    private String amount;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
