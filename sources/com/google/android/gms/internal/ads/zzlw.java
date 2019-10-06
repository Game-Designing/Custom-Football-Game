package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import java.util.Arrays;

@TargetApi(21)
public final class zzlw {

    /* renamed from: a */
    private static final zzlw f28838a = new zzlw(new int[]{2}, 2);

    /* renamed from: b */
    private final int[] f28839b;

    /* renamed from: c */
    private final int f28840c = 2;

    private zzlw(int[] iArr, int i) {
        this.f28839b = Arrays.copyOf(iArr, iArr.length);
        Arrays.sort(this.f28839b);
    }

    /* renamed from: a */
    public final boolean mo31963a(int i) {
        return Arrays.binarySearch(this.f28839b, i) >= 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzlw)) {
            return false;
        }
        zzlw zzlw = (zzlw) obj;
        if (!Arrays.equals(this.f28839b, zzlw.f28839b) || this.f28840c != zzlw.f28840c) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f28840c + (Arrays.hashCode(this.f28839b) * 31);
    }

    public final String toString() {
        int i = this.f28840c;
        String arrays = Arrays.toString(this.f28839b);
        StringBuilder sb = new StringBuilder(String.valueOf(arrays).length() + 67);
        sb.append("AudioCapabilities[maxChannelCount=");
        sb.append(i);
        sb.append(", supportedEncodings=");
        sb.append(arrays);
        sb.append("]");
        return sb.toString();
    }
}
