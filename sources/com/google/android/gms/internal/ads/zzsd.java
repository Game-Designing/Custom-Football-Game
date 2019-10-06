package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzsd {

    /* renamed from: a */
    private final Map<String, String> f29305a = new HashMap();

    /* renamed from: b */
    private Map<String, String> f29306b;

    /* renamed from: a */
    public final synchronized Map<String, String> mo32181a() {
        if (this.f29306b == null) {
            this.f29306b = Collections.unmodifiableMap(new HashMap(this.f29305a));
        }
        return this.f29306b;
    }
}
