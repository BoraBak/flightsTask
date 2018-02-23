package com.FlightsApp.flights.utils;

/**
 * Created by borisb on 23/02/2018.
 */
public abstract class AbsCache {

    abstract Object get(final Object key);

    abstract Object put(final Object key, final Object value);

    abstract boolean isExpired(Object key);
}
