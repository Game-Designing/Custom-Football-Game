package com.google.android.gms.ads.mediation.customevent;

import com.google.ads.mediation.C8092e;
import java.util.HashMap;

@Deprecated
public final class CustomEventExtras implements C8092e {

    /* renamed from: a */
    private final HashMap<String, Object> f19232a = new HashMap<>();

    public final Object getExtra(String str) {
        return this.f19232a.get(str);
    }

    public final void setExtra(String str, Object obj) {
        this.f19232a.put(str, obj);
    }
}
