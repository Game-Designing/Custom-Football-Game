package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.zac;
import com.google.android.gms.signin.internal.zaj;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.common.api.internal.m */
final class C8673m extends zac {

    /* renamed from: b */
    private final WeakReference<zaak> f19764b;

    C8673m(zaak zaak) {
        this.f19764b = new WeakReference<>(zaak);
    }

    /* renamed from: a */
    public final void mo27573a(zaj zaj) {
        zaak zaak = (zaak) this.f19764b.get();
        if (zaak != null) {
            zaak.f19791a.mo27606a((C8683w) new C8674n(this, zaak, zaak, zaj));
        }
    }
}
