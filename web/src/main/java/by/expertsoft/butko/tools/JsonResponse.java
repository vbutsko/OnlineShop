package by.expertsoft.butko.tools;


/**
 * Created by wladek on 25.08.16.
 * TODO: move to web
 */
public class JsonResponse {
    private String status = null;
    private Object result = null;
    private String statusBar = null;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Object getResult() {
        return result;
    }
    public void setResult(Object result) {
        this.result = result;
    }

    public String getStatusBar() {
        return statusBar;
    }

    public void setStatusBar(String statusBar) {
        this.statusBar = statusBar;
    }
}