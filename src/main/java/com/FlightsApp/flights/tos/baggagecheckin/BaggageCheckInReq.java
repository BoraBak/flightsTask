package com.FlightsApp.flights.tos.baggagecheckin;

/**
 * Created by borisb on 23/02/2018.
 */
public class BaggageCheckInReq {

    private int destinationId;
    private String baggageId;

    public int getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }

    public String getBaggageId() {
        return baggageId;
    }

    public void setBaggageId(String baggageId) {
        this.baggageId = baggageId;
    }

    @Override
    public String toString() {
        return "BaggageCheckInReq{" +
                "destinationId=" + destinationId +
                ", baggageId='" + baggageId + '\'' +
                '}';
    }
}
