package com.google.android.exoplayer2.audio;

import android.annotation.TargetApi;
import java.util.Arrays;

@TargetApi(21)
/* renamed from: com.google.android.exoplayer2.audio.k */
/* compiled from: AudioCapabilities */
public final class C8127k {

    /* renamed from: a */
    public static final C8127k f16676a = new C8127k(new int[]{2}, 8);

    /* renamed from: b */
    private final int[] f16677b;

    /* renamed from: c */
    private final int f16678c;

    public C8127k(int[] supportedEncodings, int maxChannelCount) {
        if (supportedEncodings != null) {
            this.f16677b = Arrays.copyOf(supportedEncodings, supportedEncodings.length);
            Arrays.sort(this.f16677b);
        } else {
            this.f16677b = new int[0];
        }
        this.f16678c = maxChannelCount;
    }

    /* renamed from: a */
    public boolean mo25090a(int encoding) {
        return Arrays.binarySearch(this.f16677b, encoding) >= 0;
    }

    /* renamed from: a */
    public int mo25089a() {
        return this.f16678c;
    }

    public boolean equals(Object other) {
        boolean z = true;
        if (this == other) {
            return true;
        }
        if (!(other instanceof C8127k)) {
            return false;
        }
        C8127k audioCapabilities = (C8127k) other;
        if (!Arrays.equals(this.f16677b, audioCapabilities.f16677b) || this.f16678c != audioCapabilities.f16678c) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return this.f16678c + (Arrays.hashCode(this.f16677b) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AudioCapabilities[maxChannelCount=");
        sb.append(this.f16678c);
        sb.append(", supportedEncodings=");
        sb.append(Arrays.toString(this.f16677b));
        sb.append("]");
        return sb.toString();
    }
}
