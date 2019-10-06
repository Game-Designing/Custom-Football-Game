package com.google.android.gms.location;

import java.util.Comparator;

/* renamed from: com.google.android.gms.location.d */
final class C10032d implements Comparator<DetectedActivity> {
    C10032d() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        DetectedActivity detectedActivity = (DetectedActivity) obj;
        DetectedActivity detectedActivity2 = (DetectedActivity) obj2;
        int compareTo = Integer.valueOf(detectedActivity2.mo33011a()).compareTo(Integer.valueOf(detectedActivity.mo33011a()));
        return compareTo == 0 ? Integer.valueOf(detectedActivity.mo33012c()).compareTo(Integer.valueOf(detectedActivity2.mo33012c())) : compareTo;
    }
}
