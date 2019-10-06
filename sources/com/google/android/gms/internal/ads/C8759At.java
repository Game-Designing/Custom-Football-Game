package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* renamed from: com.google.android.gms.internal.ads.At */
final class C8759At implements Comparator<zzvi> {
    C8759At(zzvb zzvb) {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzvi zzvi = (zzvi) obj;
        zzvi zzvi2 = (zzvi) obj2;
        int i = zzvi.f29532c - zzvi2.f29532c;
        return i != 0 ? i : (int) (zzvi.f29530a - zzvi2.f29530a);
    }
}
