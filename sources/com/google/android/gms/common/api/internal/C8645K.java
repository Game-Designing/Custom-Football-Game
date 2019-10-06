package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.google.android.gms.common.api.zac;
import java.lang.ref.WeakReference;
import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.common.api.internal.K */
final class C8645K implements DeathRecipient, C8646L {

    /* renamed from: a */
    private final WeakReference<BasePendingResult<?>> f19692a;

    /* renamed from: b */
    private final WeakReference<zac> f19693b;

    /* renamed from: c */
    private final WeakReference<IBinder> f19694c;

    private C8645K(BasePendingResult<?> basePendingResult, zac zac, IBinder iBinder) {
        this.f19693b = new WeakReference<>(zac);
        this.f19692a = new WeakReference<>(basePendingResult);
        this.f19694c = new WeakReference<>(iBinder);
    }

    /* renamed from: a */
    public final void mo27507a(BasePendingResult<?> basePendingResult) {
        m21313a();
    }

    public final void binderDied() {
        m21313a();
    }

    /* renamed from: a */
    private final void m21313a() {
        BasePendingResult basePendingResult = (BasePendingResult) this.f19692a.get();
        zac zac = (zac) this.f19693b.get();
        if (!(zac == null || basePendingResult == null)) {
            zac.mo27646a(basePendingResult.mo27456d().intValue());
        }
        IBinder iBinder = (IBinder) this.f19694c.get();
        if (iBinder != null) {
            try {
                iBinder.unlinkToDeath(this, 0);
            } catch (NoSuchElementException e) {
            }
        }
    }

    /* synthetic */ C8645K(BasePendingResult basePendingResult, zac zac, IBinder iBinder, C8644J j) {
        this(basePendingResult, null, iBinder);
    }
}
