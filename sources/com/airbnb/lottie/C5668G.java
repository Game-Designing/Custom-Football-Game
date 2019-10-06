package com.airbnb.lottie;

import java.util.Comparator;
import p002b.p003c.p053g.p061f.C1268l;

/* renamed from: com.airbnb.lottie.G */
/* compiled from: PerformanceTracker */
class C5668G implements Comparator<C1268l<String, Float>> {

    /* renamed from: a */
    final /* synthetic */ C5669H f9631a;

    C5668G(C5669H this$0) {
        this.f9631a = this$0;
    }

    /* renamed from: a */
    public int compare(C1268l<String, Float> o1, C1268l<String, Float> o2) {
        float r1 = ((Float) o1.f4070b).floatValue();
        float r2 = ((Float) o2.f4070b).floatValue();
        if (r2 > r1) {
            return 1;
        }
        if (r1 > r2) {
            return -1;
        }
        return 0;
    }
}
