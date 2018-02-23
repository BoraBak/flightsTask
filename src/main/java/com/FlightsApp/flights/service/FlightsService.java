package com.FlightsApp.flights.service;

import com.FlightsApp.flights.dao.IFlightsDao;
import com.FlightsApp.flights.tos.baggagecheckin.BaggageCheckInReq;
import com.FlightsApp.flights.tos.couponsupport.CouponSupportReq;
import com.FlightsApp.flights.tos.couponsupport.CouponSupportRes;
import com.FlightsApp.flights.utils.TicketsCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by borisb on 23/02/2018.
 */
@Service
public class FlightsService implements IFlightsService {

    @Autowired
    IFlightsDao flightsDao;
    @Autowired
    TicketsCache ticketsCache;

    private int[] discount = new int[]{10,50,60};

    @Override
    public boolean isTicketAvailable(int ticketId) {
        //check caching
        Boolean isCacheExists = (Boolean) ticketsCache.get(ticketId);
        if (isCacheExists != null && isCacheExists)
            return true;

        //check against DB
        boolean isTicketAvailable = flightsDao.isTicketAvailable(ticketId);

        //add to cache
        ticketsCache.put(ticketId, isCacheExists);

        return isTicketAvailable;
    }

    @Override
    public boolean baggageCheckIn(BaggageCheckInReq baggageCheckInReq) {

        int destinationId = baggageCheckInReq.getDestinationId();
        String baggageId = baggageCheckInReq.getBaggageId();

        //TODO: check against CACHE

        return flightsDao.baggageCheckIn(destinationId, baggageId);
    }

    @Override
    public CouponSupportRes couponSupport(CouponSupportReq couponSupportReq) {
        int couponId = couponSupportReq.getCouponId();

        //TODO: check against CACHE

        CouponSupportRes couponSupportRes = new CouponSupportRes();

        boolean isValidCoupon = flightsDao.isValidCoupon(couponId);

        if (isValidCoupon) {
            double price = couponSupportReq.getPrice();
            couponSupportRes.setValidCoupon(true);
            couponSupportRes.setDiscountPrice(calculateCouponDiscount(price));
        } else
            couponSupportRes.setValidCoupon(false);

        return couponSupportRes;
    }

    /**
     * Calculates Coupon Discount
     * @param price - original price
     * @return price after discount
     */
    private double calculateCouponDiscount(double price) {
        int rnd = new Random().nextInt(discount.length);
        return price * (discount[rnd] / 100);
    }
}
