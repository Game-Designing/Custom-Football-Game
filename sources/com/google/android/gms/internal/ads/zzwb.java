package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.ads.internal.zzk;
import java.io.InputStream;
import java.util.concurrent.Future;

@zzard
public final class zzwb {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public zzvu f29559a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f29560b;

    /* renamed from: c */
    private final Context f29561c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Object f29562d = new Object();

    zzwb(Context context) {
        this.f29561c = context;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final Future<InputStream> mo32328a(zzvv zzvv) {
        C8885Gt gt = new C8885Gt(this);
        C8906Ht ht = new C8906Ht(this, zzvv, gt);
        C8990Lt lt = new C8990Lt(this, gt);
        synchronized (this.f29562d) {
            this.f29559a = new zzvu(this.f29561c, zzk.zzlu().mo30298b(), ht, lt);
            this.f29559a.checkAvailabilityAndConnect();
        }
        return gt;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m31323a() {
        synchronized (this.f29562d) {
            if (this.f29559a != null) {
                this.f29559a.disconnect();
                this.f29559a = null;
                Binder.flushPendingCommands();
            }
        }
    }
}
