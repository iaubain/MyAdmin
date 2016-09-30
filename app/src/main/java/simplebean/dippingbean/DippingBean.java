package simplebean.dippingbean;

/**
 * Created by Hp on 9/26/2016.
 */
public class DippingBean {
    private long userId;
    private long tankId;
    private long calculatedDip;
    private long waterValue;

    public DippingBean(long userId, long tankId, long calculatedDip, long waterValue) {
        this.setUserId(userId);
        this.setTankId(tankId);
        this.setCalculatedDip(calculatedDip);
        this.setWaterValue(waterValue);
    }

    public DippingBean() {

    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getTankId() {
        return tankId;
    }

    public void setTankId(long tankId) {
        this.tankId = tankId;
    }

    public long getCalculatedDip() {
        return calculatedDip;
    }

    public void setCalculatedDip(long calculatedDip) {
        this.calculatedDip = calculatedDip;
    }

    public long getWaterValue() {
        return waterValue;
    }

    public void setWaterValue(long waterValue) {
        this.waterValue = waterValue;
    }
}
