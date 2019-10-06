package com.google.android.gms.internal.ads;

public final class zzmm extends Exception {

    /* renamed from: a */
    private final int f28902a;

    public zzmm(int i, int i2, int i3, int i4) {
        StringBuilder sb = new StringBuilder(82);
        sb.append("AudioTrack init failed: ");
        sb.append(i);
        sb.append(", Config(");
        sb.append(i2);
        String str = ", ";
        sb.append(str);
        sb.append(i3);
        sb.append(str);
        sb.append(i4);
        sb.append(")");
        super(sb.toString());
        this.f28902a = i;
    }
}
