package com.fasterxml.jackson.databind.ser;

public abstract class FilterProvider {
    public abstract PropertyFilter findPropertyFilter(Object obj, Object obj2);
}
