package simplebean.tankingbean;

/**
 * Created by Hp on 9/26/2016.
 */
public class TankingBean {
    private int userId;
    private int tankID;
    private long waterValue;
    private long postTankedValue;
    private long preTankedValue;
    private long theoreticalTanked;
    private String plateNumber;
    private String deliveredBy;

    public TankingBean(int userId, int tankID, long waterValue, long postTankedValue, long preTankedValue, long theoreticalTanked, String plateNumber, String deliveredBy) {
        this.setUserId(userId);
        this.setTankID(tankID);
        this.setWaterValue(waterValue);
        this.setPostTankedValue(postTankedValue);
        this.setPreTankedValue(preTankedValue);
        this.setTheoreticalTanked(theoreticalTanked);
        this.setPlateNumber(plateNumber);
        this.setDeliveredBy(deliveredBy);
    }

    public TankingBean() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTankID() {
        return tankID;
    }

    public void setTankID(int tankID) {
        this.tankID = tankID;
    }

    public long getWaterValue() {
        return waterValue;
    }

    public void setWaterValue(long waterValue) {
        this.waterValue = waterValue;
    }

    public long getPostTankedValue() {
        return postTankedValue;
    }

    public void setPostTankedValue(long postTankedValue) {
        this.postTankedValue = postTankedValue;
    }

    public long getPreTankedValue() {
        return preTankedValue;
    }

    public void setPreTankedValue(long preTankedValue) {
        this.preTankedValue = preTankedValue;
    }

    public long getTheoreticalTanked() {
        return theoreticalTanked;
    }

    public void setTheoreticalTanked(long theoreticalTanked) {
        this.theoreticalTanked = theoreticalTanked;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getDeliveredBy() {
        return deliveredBy;
    }

    public void setDeliveredBy(String deliveredBy) {
        this.deliveredBy = deliveredBy;
    }
}
