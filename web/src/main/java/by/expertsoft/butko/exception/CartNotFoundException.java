package by.expertsoft.butko.exception;

/**
 * Created by wladek on 13.09.16.
 */
public class CartNotFoundException extends RuntimeException {
    private String exceptionMsg;

    public CartNotFoundException(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    public String getExceptionMsg(){
        return this.exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }
}
