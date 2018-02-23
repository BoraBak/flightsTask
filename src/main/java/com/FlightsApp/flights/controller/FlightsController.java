package com.FlightsApp.flights.controller;

import com.FlightsApp.flights.service.IFlightsService;
import com.FlightsApp.flights.tos.baggagecheckin.BaggageCheckInReq;
import com.FlightsApp.flights.tos.couponsupport.CouponSupportReq;
import com.FlightsApp.flights.tos.couponsupport.CouponSupportRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by borisb on 23/02/2018.
 */
@RestController
@RequestMapping(value = "/flights")
public class FlightsController {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    IFlightsService flightsService;

    /**
     * Check if ticket is available
     * @param ticketId - ticket ID
     * @return TRUE - if ticket is available, FALSE - otherwise
     */
    @RequestMapping(value = "/isTicketAvailable", method = RequestMethod.GET)
    public ResponseEntity isTicketAvailable(@RequestBody int ticketId) {
        LOGGER.info("Started scenario: Is Ticket Available.");
        String badRequestResult = null;

        boolean isTicketAvailable = false;
        try {
            if (ticketId < 1)
                throw new RuntimeException("Bad input data");

            isTicketAvailable = flightsService.isTicketAvailable(ticketId);

        } catch (Exception e) {
            badRequestResult = "Error: in scenario Is Ticket Available. Ticket ID: " + ticketId + "\n";
            LOGGER.error(badRequestResult ,e);
        }

        LOGGER.info("Finished scenario: Is Ticket Available. Result is: " + isTicketAvailable);
        return badRequestResult != null ? ResponseEntity.badRequest().body(badRequestResult) : ResponseEntity.ok(isTicketAvailable);
    }

    /**
     * Baggage Check-In
     * @param baggageCheckInReq - {@link BaggageCheckInReq}
     * @return TRUE - if baggage check-in process succeeded, FALSE - otherwise
     */
    @RequestMapping(value = "/baggageCheckIn", method = RequestMethod.POST)
    public ResponseEntity baggageCheckIn(@RequestBody BaggageCheckInReq baggageCheckInReq) {
        LOGGER.info("Started scenario: Baggage Check-In.");
        String badRequestResult = null;

        boolean isCheckInSucceeded = false;
        try {
            if (baggageCheckInReq == null)
                throw new RuntimeException("Bad input data");

            isCheckInSucceeded = flightsService.baggageCheckIn(baggageCheckInReq);

        } catch (Exception e) {
            badRequestResult = "Error: in scenario Baggage Check-In. BaggageCheckInReq: " + baggageCheckInReq + "\n";
            LOGGER.error(badRequestResult ,e);
        }

        LOGGER.info("Finished scenario: Baggage Check-In. Result is: " + isCheckInSucceeded);
        return badRequestResult != null ? ResponseEntity.badRequest().body(badRequestResult) : ResponseEntity.ok(isCheckInSucceeded);
    }

    /**
     * Coupon Support - checking if coupon is valid & calculating its discount
     * @param couponSupportReq - {@link CouponSupportReq}
     * @return if coupon is valid, then return new price after discount. Otherwise, not valid, and no discount
     */
    @RequestMapping(value = "/couponSupport", method = RequestMethod.GET)
    public ResponseEntity couponSupport(@RequestBody CouponSupportReq couponSupportReq) {
        LOGGER.info("Started scenario: Coupon Support.");
        String badRequestResult = null;

        CouponSupportRes couponSupportRes = null;
        try {
            if (couponSupportReq == null)
                throw new RuntimeException("Bad input data");

            couponSupportRes = flightsService.couponSupport(couponSupportReq);

        } catch (Exception e) {
            badRequestResult = "Error: in scenario Coupon Support. BaggageCheckInReq: " + couponSupportReq + "\n";
            LOGGER.error(badRequestResult ,e);
        }

        LOGGER.info("Finished scenario: Baggage Coupon Support. Result is: " + couponSupportRes);
        return badRequestResult != null ? ResponseEntity.badRequest().body(badRequestResult) : ResponseEntity.ok(couponSupportRes);
    }

}
