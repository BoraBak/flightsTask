package com.FlightsApp.flights.dao;

import com.FlightsApp.flights.dao.staticdata.StaticData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by borisb on 23/02/2018.
 */
@Repository
public class FlightsDao implements IFlightsDao {

    @Autowired
    StaticData staticData;

    @Override
    public boolean isTicketAvailable(int ticketId) {
        return staticData.isTicketAvailable(ticketId);
    }

    @Override
    public boolean baggageCheckIn(int destinationId, String baggageId) {
        return staticData.baggageCheckIn(destinationId, baggageId);
    }

    @Override
    public boolean isValidCoupon(int couponId) {
        return staticData.isValidCoupon(couponId);
    }
}
