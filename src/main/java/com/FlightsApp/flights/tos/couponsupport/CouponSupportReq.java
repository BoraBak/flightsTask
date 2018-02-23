package com.FlightsApp.flights.tos.couponsupport;

/**
 * Created by borisb on 23/02/2018.
 */
public class CouponSupportReq {

    private int couponId;
    private double price;

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CouponSupportReq{" +
                "couponId=" + couponId +
                ", price=" + price +
                '}';
    }
}
