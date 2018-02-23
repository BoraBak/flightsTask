package com.FlightsApp.flights.dao;

/**
 * Created by borisb on 23/02/2018.
 */
public interface IFlightsDao {

    /**
     * Check against the DB if ticket is available
     * @param ticketId - ticket ID
     * @return TRUE - if ticket is available, FALSE - otherwise
     */
    boolean isTicketAvailable(int ticketId);

    /**
     * Executing against the DB process of Baggage Check-In
     * @param destinationId - destination ID
     * @param baggageId - baggage ID
     * @return TRUE - if check-in process succeeded, FALSE - otherwise
     */
    boolean baggageCheckIn(int destinationId, String baggageId);

    /**
     * Check against the DB if coupon is valid
     * @param couponId - coupon ID
     * @return TRUE - if coupon is valid, FALSE - otherwise
     */
    boolean isValidCoupon(int couponId);
}
