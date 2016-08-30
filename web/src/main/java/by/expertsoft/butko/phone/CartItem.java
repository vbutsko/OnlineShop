package by.expertsoft.butko.phone;

import com.sun.xml.internal.ws.dump.MessageDumping;
import org.intellij.lang.annotations.RegExp;
import org.jetbrains.annotations.NotNull;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

/**
 * Created by wladek on 17.08.16.
 */
public class CartItem {
    @Min(value = 1, message = "amount must be integer >= 1")
    private int amount;
    private int productId;

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
