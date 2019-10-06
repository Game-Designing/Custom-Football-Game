package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import java.util.HashSet;

public final class zzcyi implements zzaws, zzbro {

    /* renamed from: a */
    private final HashSet<zzawj> f27634a = new HashSet<>();

    /* renamed from: b */
    private final Context f27635b;

    /* renamed from: c */
    private final zzawu f27636c;

    public zzcyi(Context context, zzawu zzawu) {
        this.f27635b = context;
        this.f27636c = zzawu;
    }

    public final synchronized void onAdFailedToLoad(int i) {
        if (i != 3) {
            this.f27636c.mo30193a(this.f27634a);
        }
    }

    /* renamed from: a */
    public final synchronized void mo30185a(HashSet<zzawj> hashSet) {
        this.f27634a.clear();
        this.f27634a.addAll(hashSet);
    }

    /* renamed from: a */
    public final Bundle mo31307a() {
        return this.f27636c.mo30188a(this.f27635b, (zzaws) this);
    }
}
