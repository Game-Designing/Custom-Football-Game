package com.inmobi.ads;

import android.util.Base64;
import com.inmobi.commons.core.network.C10677d;
import com.inmobi.commons.core.utilities.p224a.C10687b;

/* renamed from: com.inmobi.ads.r */
/* compiled from: BidManager */
public final class C10595r {

    /* renamed from: d */
    private static final String f32275d = C10595r.class.getSimpleName();

    /* renamed from: a */
    public byte[] f32276a = C10687b.m35080a(16);

    /* renamed from: b */
    public final byte[] f32277b = C10687b.m35079a();

    /* renamed from: c */
    public final byte[] f32278c = C10687b.m35080a(8);

    C10595r() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final String mo34405a(String str, String str2) {
        try {
            byte[] a = C10687b.m35081a(this.f32277b);
            return new String(Base64.encode(C10687b.m35082a(C10687b.m35083a(C10687b.m35083a(a, C10687b.m35081a(this.f32278c)), C10687b.m35081a(this.f32276a)), str2, str), 8));
        } catch (Exception e) {
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final String mo34404a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return C10677d.m35056a(C10687b.m35084a(Base64.decode(str, 0), this.f32277b, this.f32276a));
        } catch (Exception e) {
            return null;
        }
    }
}
