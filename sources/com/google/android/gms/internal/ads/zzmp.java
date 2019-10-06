package com.google.android.gms.internal.ads;

public final class zzmp extends Exception {

    /* renamed from: a */
    private final int f28903a;

    public zzmp(int i) {
        StringBuilder sb = new StringBuilder(36);
        sb.append("AudioTrack write failed: ");
        sb.append(i);
        super(sb.toString());
        this.f28903a = i;
    }
}
