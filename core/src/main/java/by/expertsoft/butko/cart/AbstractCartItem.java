package by.expertsoft.butko.cart;


/**
 * Created by wladek on 03.09.16.
 */
public abstract class AbstractCartItem {
    protected int amount;
    protected int productId;

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
