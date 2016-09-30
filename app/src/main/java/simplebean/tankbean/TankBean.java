package simplebean.tankbean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by Hp on 9/26/2016.
 */
public class TankBean {
    @JsonProperty("tankId")
    private int tankId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("maxCapacity")
    private Double maxCapacity;
    @JsonProperty("currentCapacity")
    private Double currentCapacity;
    @JsonIgnore
    private Date preCalibrationDate;
    @JsonIgnore
    private Date nextCalibrationDate;
    @JsonProperty("status")
    private long status;
    @JsonProperty("branchId")
    private int branchId;

    public TankBean(int tankId, String name, Double maxCapacity, Double currentCapacity, Date preCalibrationDate, Date nextCalibrationDate, long status, int branchId) {
        this.setTankId(tankId);
        this.setName(name);
        this.setMaxCapacity(maxCapacity);
        this.setCurrentCapacity(currentCapacity);
        this.setPreCalibrationDate(preCalibrationDate);
        this.setNextCalibrationDate(nextCalibrationDate);
        this.setStatus(status);
        this.setBranchId(branchId);
    }

    public TankBean() {

    }

    public int getTankId() {
        return tankId;
    }

    public void setTankId(int tankId) {
        this.tankId = tankId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Double maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Double getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(Double currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public Date getPreCalibrationDate() {
        return preCalibrationDate;
    }

    public void setPreCalibrationDate(Date preCalibrationDate) {
        this.preCalibrationDate = preCalibrationDate;
    }

    public Date getNextCalibrationDate() {
        return nextCalibrationDate;
    }

    public void setNextCalibrationDate(Date nextCalibrationDate) {
        this.nextCalibrationDate = nextCalibrationDate;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }
}
