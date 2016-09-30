package simplebean.tankingbean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Hp on 9/26/2016.
 */
public class TankingResp {
    @JsonProperty("Tanking")
    private TankingBean tankingBean;
    @JsonProperty("message")
    private String message;
    @JsonProperty("statusCode")
    private int statusCode;

    public TankingResp(TankingBean tankingBean, String message, int statusCode) {
        this.setTankingBean(tankingBean);
        this.setMessage(message);
        this.setStatusCode(statusCode);
    }

    public TankingResp() {

    }

    public TankingBean getTankingBean() {
        return tankingBean;
    }

    public void setTankingBean(TankingBean tankingBean) {
        this.tankingBean = tankingBean;
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
