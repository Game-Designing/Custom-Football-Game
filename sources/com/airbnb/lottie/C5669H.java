package com.airbnb.lottie;

import com.airbnb.lottie.p095f.C5827d;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import p002b.p003c.p053g.p061f.C1255d;
import p002b.p003c.p053g.p061f.C1268l;

/* renamed from: com.airbnb.lottie.H */
/* compiled from: PerformanceTracker */
public class C5669H {

    /* renamed from: a */
    private boolean f9632a = false;

    /* renamed from: b */
    private final Set<C5670a> f9633b = new C1255d();

    /* renamed from: c */
    private final Map<String, C5827d> f9634c = new HashMap();

    /* renamed from: d */
    private final Comparator<C1268l<String, Float>> f9635d = new C5668G(this);

    /* renamed from: com.airbnb.lottie.H$a */
    /* compiled from: PerformanceTracker */
    public interface C5670a {
        /* renamed from: a */
        void mo17880a(float f);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo17879a(boolean enabled) {
        this.f9632a = enabled;
    }

    /* renamed from: a */
    public void mo17878a(String layerName, float millis) {
        if (this.f9632a) {
            C5827d meanCalculator = (C5827d) this.f9634c.get(layerName);
            if (meanCalculator == null) {
                meanCalculator = new C5827d();
                this.f9634c.put(layerName, meanCalculator);
            }
            meanCalculator.mo18185a(millis);
            if (layerName.equals("__container")) {
                for (C5670a listener : this.f9633b) {
                    listener.mo17880a(millis);
                }
            }
        }
    }
}
