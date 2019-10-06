package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.google.android.gms.internal.ads.is */
final class C9503is extends C9481hs {

    /* renamed from: Qa */
    public final long f22576Qa;

    /* renamed from: Ra */
    public final List<C9525js> f22577Ra = new ArrayList();

    /* renamed from: Sa */
    public final List<C9503is> f22578Sa = new ArrayList();

    public C9503is(int i, long j) {
        super(i);
        this.f22576Qa = j;
    }

    /* renamed from: d */
    public final C9525js mo29010d(int i) {
        int size = this.f22577Ra.size();
        for (int i2 = 0; i2 < size; i2++) {
            C9525js jsVar = (C9525js) this.f22577Ra.get(i2);
            if (jsVar.f22524Pa == i) {
                return jsVar;
            }
        }
        return null;
    }

    /* renamed from: e */
    public final C9503is mo29011e(int i) {
        int size = this.f22578Sa.size();
        for (int i2 = 0; i2 < size; i2++) {
            C9503is isVar = (C9503is) this.f22578Sa.get(i2);
            if (isVar.f22524Pa == i) {
                return isVar;
            }
        }
        return null;
    }

    public final String toString() {
        String c = C9481hs.m23683c(this.f22524Pa);
        String arrays = Arrays.toString(this.f22577Ra.toArray());
        String arrays2 = Arrays.toString(this.f22578Sa.toArray());
        StringBuilder sb = new StringBuilder(String.valueOf(c).length() + 22 + String.valueOf(arrays).length() + String.valueOf(arrays2).length());
        sb.append(c);
        sb.append(" leaves: ");
        sb.append(arrays);
        sb.append(" containers: ");
        sb.append(arrays2);
        return sb.toString();
    }
}
