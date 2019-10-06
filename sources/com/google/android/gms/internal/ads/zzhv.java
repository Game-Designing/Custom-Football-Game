package com.google.android.gms.internal.ads;

public final class zzhv extends Exception {

    /* renamed from: a */
    private final int f28563a;

    public zzhv(int i) {
        StringBuilder sb = new StringBuilder(36);
        sb.append("AudioTrack write failed: ");
        sb.append(i);
        super(sb.toString());
        this.f28563a = i;
    }
}
