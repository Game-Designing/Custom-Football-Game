package com.google.android.gms.internal.measurement;

import java.io.IOException;

public class zzuv extends IOException {

    /* renamed from: a */
    private zzvv f30347a = null;

    public zzuv(String str) {
        super(str);
    }

    /* renamed from: a */
    static zzuv m32550a() {
        return new zzuv("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* renamed from: b */
    static zzuv m32551b() {
        return new zzuv("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* renamed from: c */
    static zzuw m32552c() {
        return new zzuw("Protocol message tag had invalid wire type.");
    }
}
