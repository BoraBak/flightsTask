package com.FlightsApp.flights.utils;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by borisb on 23/02/2018.
 */
@Service
public class TicketsCache extends AbsCache {

    private static Map<Integer, Boolean> ticketsAvailable = new HashMap<>();

    @Override
    public Object get(Object key) {
        return ticketsAvailable.get(key) && isExpired(key);
    }

    @Override
    public Object put(Object key, Object value) {
        return ticketsAvailable.put((Integer) key, (Boolean) value);
    }

    @Override
    public boolean isExpired(Object key) {
        //TODO: logic not implemented, due to lack of time
        return false;
    }
}
