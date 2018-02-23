package com.FlightsApp.flights.dao.staticdata;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by borisb on 23/02/2018.
 */
@Repository
public class StaticData {
    private List<Integer> tickets = new ArrayList<>();
    private List<Integer> coupons = new ArrayList<>();


    public boolean isTicketAvailable(int ticketId) {
        tickets.add(1);
        tickets.add(2);
        tickets.add(3);
        tickets.add(4);
        tickets.add(5);

        for (int t : tickets)
            if (t == ticketId)
                return true;

        return false;
    }

    public boolean baggageCheckIn(int destinationId, String baggageId) {
        //some logic of baggage check-in.... and then to insert to DB

        return true;
    }

    public boolean isValidCoupon(int couponId) {
        coupons.add(1);
        coupons.add(2);
        coupons.add(3);
        coupons.add(4);
        coupons.add(5);

        for (int c : coupons)
            if (c == couponId)
                return true;

        return false;
    }
}
