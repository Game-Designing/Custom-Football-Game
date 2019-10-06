package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.Zp */
final class C9283Zp extends IllegalArgumentException {
    C9283Zp(int i, int i2) {
        StringBuilder sb = new StringBuilder(54);
        sb.append("Unpaired surrogate at index ");
        sb.append(i);
        sb.append(" of ");
        sb.append(i2);
        super(sb.toString());
    }
}
