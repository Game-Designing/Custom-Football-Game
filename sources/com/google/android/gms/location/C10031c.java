package com.google.android.gms.location;

import java.util.Comparator;

/* renamed from: com.google.android.gms.location.c */
final class C10031c implements Comparator<ActivityTransition> {
    C10031c() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        ActivityTransition activityTransition = (ActivityTransition) obj;
        ActivityTransition activityTransition2 = (ActivityTransition) obj2;
        int a = activityTransition.mo32990a();
        int a2 = activityTransition2.mo32990a();
        if (a != a2) {
            return a < a2 ? -1 : 1;
        }
        int c = activityTransition.mo32991c();
        int c2 = activityTransition2.mo32991c();
        if (c == c2) {
            return 0;
        }
        return c < c2 ? -1 : 1;
    }
}
