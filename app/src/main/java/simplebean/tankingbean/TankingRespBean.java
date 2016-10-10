package simplebean.tankingbean;

/**
 * Created by Hp on 10/3/2016.
 */
public class TankingRespBean {
    private int id;
    private int userId;
    private int tankId;
    private long preTankingMeasuredDip;
    private long preTankingCalculatedDip;
    private String deliveredBy;
    private long theoriticalTanked;
    private String platenumber;
    private long postTankingMeasuredDip;
    private long postTankingCalculatedDip;
    private long datetime;
    private long waterValue;

    public TankingRespBean(int id, int userId, int tankId, long preTankingMeasuredDip, long preTankingCalculatedDip, String deliveredBy, long theoriticalTanked, String platenumber, long postTankingMeasuredDip, long postTankingCalculatedDip, long datetime, long waterValue) {
        this.setId(id);
        this.setUserId(userId);
        this.setTankId(tankId);
        this.setPreTankingMeasuredDip(preTankingMeasuredDip);
        this.setPreTankingCalculatedDip(preTankingCalculatedDip);
        this.setDeliveredBy(deliveredBy);
        this.setTheoriticalTanked(theoriticalTanked);
        this.setPlatenumber(platenumber);
        this.setPostTankingMeasuredDip(postTankingMeasuredDip);
        this.setPostTankingCalculatedDip(postTankingCalculatedDip);
        this.setDatetime(datetime);
        this.setWaterValue(waterValue);
    }

    public TankingRespBean() {

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

    public long getPreTankingMeasuredDip() {
        return preTankingMeasuredDip;
    }

    public void setPreTankingMeasuredDip(long preTankingMeasuredDip) {
        this.preTankingMeasuredDip = preTankingMeasuredDip;
    }

    public long getPreTankingCalculatedDip() {
        return preTankingCalculatedDip;
    }

    public void setPreTankingCalculatedDip(long preTankingCalculatedDip) {
        this.preTankingCalculatedDip = preTankingCalculatedDip;
    }

    public String getDeliveredBy() {
        return deliveredBy;
    }

    public void setDeliveredBy(String deliveredBy) {
        this.deliveredBy = deliveredBy;
    }

    public long getTheoriticalTanked() {
        return theoriticalTanked;
    }

    public void setTheoriticalTanked(long theoriticalTanked) {
        this.theoriticalTanked = theoriticalTanked;
    }

    public String getPlatenumber() {
        return platenumber;
    }

    public void setPlatenumber(String platenumber) {
        this.platenumber = platenumber;
    }

    public long getPostTankingMeasuredDip() {
        return postTankingMeasuredDip;
    }

    public void setPostTankingMeasuredDip(long postTankingMeasuredDip) {
        this.postTankingMeasuredDip = postTankingMeasuredDip;
    }

    public long getPostTankingCalculatedDip() {
        return postTankingCalculatedDip;
    }

    public void setPostTankingCalculatedDip(long postTankingCalculatedDip) {
        this.postTankingCalculatedDip = postTankingCalculatedDip;
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
