package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.IOException;

public class zzbb extends zzdsu implements Closeable {

    /* renamed from: j */
    private static zzdtc f25062j = zzdtc.m30099a(zzbb.class);

    public zzbb(zzdsw zzdsw, zzba zzba) throws IOException {
        mo31684a(zzdsw, zzdsw.size(), zzba);
    }

    public void close() throws IOException {
        this.f28275d.close();
    }

    public String toString() {
        String obj = this.f28275d.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 7);
        sb.append("model(");
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }
}
