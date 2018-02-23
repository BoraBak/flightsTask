package com.FlightsApp.flights.service;

import com.FlightsApp.flights.tos.baggagecheckin.BaggageCheckInReq;
import com.FlightsApp.flights.tos.couponsupport.CouponSupportReq;
import com.FlightsApp.flights.tos.couponsupport.CouponSupportRes;

/**
 * Created by borisb on 23/02/2018.
 */
public interface IFlightsService {

    /**
     * Check if ticket is available
     * @param ticketId - ticket ID
     * @return TRUE - if ticket is available, FALSE - otherwise
     */
    boolean isTicketAvailable(int ticketId);

    /**
     * Baggage Check-In
     * @param baggageCheckInReq - {@link BaggageCheckInReq}
     * @return TRUE - if check-in process succeeded, FALSE - otherwise
     */
    boolean baggageCheckIn(BaggageCheckInReq baggageCheckInReq);

    /**
     * Coupon Support - checking if coupon is valid & calculating its discount
     * @param couponSupportReq - {@link CouponSupportReq}
     * @return if coupon is valid, then return new price after discount. Otherwise, not valid, and no discount
     */
    CouponSupportRes couponSupport(CouponSupportReq couponSupportReq);
}
