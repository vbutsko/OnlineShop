package by.expertsoft.butko.forms;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
/**
 * Created by wladek on 05.09.16.
 */
public class CartItemForm {
    private int productId;
    @NotNull
    @Min(value=1,
            message = "amount must be greater than 0")
    private Integer amount;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
