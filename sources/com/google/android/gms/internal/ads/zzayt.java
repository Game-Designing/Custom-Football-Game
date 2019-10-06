package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

public final class zzayt {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final List<String> f25003a = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final List<Double> f25004b = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final List<Double> f25005c = new ArrayList();

    /* renamed from: a */
    public final zzayt mo30293a(String str, double d, double d2) {
        int i = 0;
        while (i < this.f25003a.size()) {
            double doubleValue = ((Double) this.f25005c.get(i)).doubleValue();
            double doubleValue2 = ((Double) this.f25004b.get(i)).doubleValue();
            if (d < doubleValue || (doubleValue == d && d2 < doubleValue2)) {
                break;
            }
            i++;
        }
        this.f25003a.add(i, str);
        this.f25005c.add(i, Double.valueOf(d));
        this.f25004b.add(i, Double.valueOf(d2));
        return this;
    }

    /* renamed from: a */
    public final zzayq mo30292a() {
        return new zzayq(this);
    }
}
