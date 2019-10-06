package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

@KeepForSdk
public class ListenerHolders {

    /* renamed from: a */
    private final Set<ListenerHolder<?>> f19702a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: a */
    public final void mo27531a() {
        for (ListenerHolder a : this.f19702a) {
            a.mo27526a();
        }
        this.f19702a.clear();
    }
}
