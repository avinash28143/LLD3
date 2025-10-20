package com.scaler.lld_naman.parkinglot.models;

import java.util.Date;

public class Ticket extends BaseModel{

    private ParkingSpot parkingSopt;
    private Date entryTime;
    private Vehicle vehicle;
    private Gate gate;
    private Operator operator;

    public ParkingSpot getParkingSopt() {
        return parkingSopt;
    }

    public void setParkingSopt(ParkingSpot parkingSopt) {
        this.parkingSopt = parkingSopt;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
}
