package com.FlightsApp.flights.tos.couponsupport;

/**
 * Created by borisb on 23/02/2018.
 */
public class CouponSupportRes {
    private double discountPrice;
    private boolean isValidCoupon;

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public boolean isValidCoupon() {
        return isValidCoupon;
    }

    public void setValidCoupon(boolean validCoupon) {
        isValidCoupon = validCoupon;
    }

    @Override
    public String toString() {
        return "CouponSupportRes{" +
                "discountPrice=" + discountPrice +
                ", isValidCoupon=" + isValidCoupon +
                '}';
    }
}
