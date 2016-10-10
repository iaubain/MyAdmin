package simplebean.dippingbean;

/**
 * Created by Hp on 10/3/2016.
 */
public class DippingRespBean {
    private int id;
    private int userId;
    private int tankId;
    private long measuredDip;
    private long calculatedDip;
    private long datetime;
    private long waterValue;

    public DippingRespBean(int id, int userId, int tankId, long measuredDip, long calculatedDip, long datetime, long waterValue) {
        this.setId(id);
        this.setUserId(userId);
        this.setTankId(tankId);
        this.setMeasuredDip(measuredDip);
        this.setCalculatedDip(calculatedDip);
        this.setDatetime(datetime);
        this.setWaterValue(waterValue);
    }

    public DippingRespBean() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTankId() {
        return tankId;
    }

    public void setTankId(int tankId) {
        this.tankId = tankId;
    }

    public long getMeasuredDip() {
        return measuredDip;
    }

    public void setMeasuredDip(long measuredDip) {
        this.measuredDip = measuredDip;
    }

    public long getCalculatedDip() {
        return calculatedDip;
    }

    public void setCalculatedDip(long calculatedDip) {
        this.calculatedDip = calculatedDip;
    }

    public long getDatetime() {
        return datetime;
    }

    public void setDatetime(long datetime) {
        this.datetime = datetime;
    }

    public long getWaterValue() {
        return waterValue;
    }

    public void setWaterValue(long waterValue) {
        this.waterValue = waterValue;
    }
}
