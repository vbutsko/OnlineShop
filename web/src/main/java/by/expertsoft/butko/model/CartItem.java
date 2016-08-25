package by.expertsoft.butko.model;

import com.sun.xml.internal.ws.dump.MessageDumping;
import org.jetbrains.annotations.NotNull;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Min;

/**
 * Created by wladek on 17.08.16.
 */
public class CartItem {
    @NotNull
    @Min(value = 1, message = "amount must be positive integer")
    private int amount;
    private int productId;
    private String name;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


}
