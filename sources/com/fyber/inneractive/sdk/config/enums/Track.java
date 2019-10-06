package com.fyber.inneractive.sdk.config.enums;

import java.util.HashMap;
import java.util.Map;

public enum Track {
    ERRORS("errors"),
    NETWORKING("networking"),
    VIEWABILITY("viewability");
    
    private static final Map<String, Track> CONSTANTS = null;
    private final String stringValue;

    static {
        int i;
        Track[] values;
        CONSTANTS = new HashMap();
        for (Track track : values()) {
            CONSTANTS.put(track.stringValue, track);
        }
    }

    private Track(String str) {
        this.stringValue = str;
    }

    public final String toString() {
        return this.stringValue;
    }

    public final String value() {
        return this.stringValue;
    }

    public static Track fromValue(String str) {
        Track track = (Track) CONSTANTS.get(str);
        if (track != null) {
            return track;
        }
        throw new IllegalArgumentException(str);
    }
}
