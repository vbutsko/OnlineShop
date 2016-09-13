package by.expertsoft.butko.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

/**
 * Created by wladek on 13.09.16.
 */
public class ThankYouTag extends BodyTagSupport {
    private String order_id;

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }
    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().println("<h2 style=\"color: green\">");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EVAL_BODY_INCLUDE;
    }
    @Override
    public int doAfterBody() throws JspException {
        try{
            pageContext.getOut().println("Your order id: " + order_id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;

    }

    public int doEndTag() throws JspException{
        try {
            pageContext.getOut().print( "</h2>" );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
