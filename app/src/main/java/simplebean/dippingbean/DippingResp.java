package simplebean.dippingbean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Hp on 9/26/2016.
 */
public class DippingResp {
    @JsonProperty("Dipping")
    private
    DippingBean dippingBean;
    @JsonProperty("message")
    private String message;
    @JsonProperty("statusCode")
    private int statusCode;

    public DippingResp(DippingBean dippingBean, String message, int statusCode) {
        this.setDippingBean(dippingBean);
        this.setMessage(message);
        this.setStatusCode(statusCode);
    }

    public DippingResp() {

    }

    public DippingBean getDippingBean() {
        return dippingBean;
    }

    public void setDippingBean(DippingBean dippingBean) {
        this.dippingBean = dippingBean;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
