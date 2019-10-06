package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.mopub.volley.DefaultRetryPolicy;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: com.google.android.gms.internal.ads.Hq */
final class C8903Hq implements zzge {

    /* renamed from: a */
    private final Handler f21223a;

    /* renamed from: b */
    private final C8945Jq f21224b;

    /* renamed from: c */
    private final CopyOnWriteArraySet<zzgh> f21225c = new CopyOnWriteArraySet<>();

    /* renamed from: d */
    private final boolean[] f21226d = new boolean[2];

    /* renamed from: e */
    private boolean f21227e = false;

    /* renamed from: f */
    private int f21228f = 1;

    /* renamed from: g */
    private int f21229g;

    @SuppressLint({"HandlerLeak"})
    public C8903Hq(int i, int i2, int i3) {
        Log.i("ExoPlayerImpl", "Init 1.3.1");
        int i4 = 0;
        while (true) {
            boolean[] zArr = this.f21226d;
            if (i4 < zArr.length) {
                zArr[i4] = true;
                i4++;
            } else {
                this.f21223a = new C8924Iq(this);
                C8945Jq jq = new C8945Jq(this.f21223a, this.f21227e, this.f21226d, DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, 5000);
                this.f21224b = jq;
                return;
            }
        }
    }

    /* renamed from: a */
    public final void mo28333a(zzgh zzgh) {
        this.f21225c.add(zzgh);
    }

    /* renamed from: i */
    public final int mo28341i() {
        return this.f21228f;
    }

    /* renamed from: a */
    public final void mo28335a(zzhp... zzhpArr) {
        this.f21224b.mo28392a(zzhpArr);
    }

    /* renamed from: a */
    public final void mo28329a(int i, boolean z) {
        boolean[] zArr = this.f21226d;
        if (zArr[0] != z) {
            zArr[0] = z;
            this.f21224b.mo28388a(0, z);
        }
    }

    /* renamed from: a */
    public final void mo28334a(boolean z) {
        if (this.f21227e != z) {
            this.f21227e = z;
            this.f21229g++;
            this.f21224b.mo28391a(z);
            Iterator it = this.f21225c.iterator();
            while (it.hasNext()) {
                ((zzgh) it.next()).mo28309a(z, this.f21228f);
            }
        }
    }

    /* renamed from: d */
    public final boolean mo28339d() {
        return this.f21227e;
    }

    /* renamed from: a */
    public final void mo28330a(long j) {
        this.f21224b.mo28389a(j);
    }

    public final void stop() {
        this.f21224b.mo28396d();
    }

    /* renamed from: a */
    public final void mo28328a() {
        this.f21224b.mo28395c();
        this.f21223a.removeCallbacksAndMessages(null);
    }

    /* renamed from: b */
    public final void mo28337b(zzgf zzgf, int i, Object obj) {
        this.f21224b.mo28390a(zzgf, 1, obj);
    }

    /* renamed from: a */
    public final void mo28332a(zzgf zzgf, int i, Object obj) {
        this.f21224b.mo28394b(zzgf, 1, obj);
    }

    public final long getDuration() {
        return this.f21224b.mo28393b();
    }

    /* renamed from: c */
    public final long mo28338c() {
        return this.f21224b.mo28397e();
    }

    /* renamed from: b */
    public final long mo28336b() {
        return this.f21224b.mo28387a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo28331a(Message message) {
        int i = message.what;
        if (i != 1) {
            if (i == 2) {
                this.f21229g--;
                if (this.f21229g == 0) {
                    Iterator it = this.f21225c.iterator();
                    while (it.hasNext()) {
                        ((zzgh) it.next()).mo28306a();
                    }
                    return;
                }
            } else if (i == 3) {
                zzgd zzgd = (zzgd) message.obj;
                Iterator it2 = this.f21225c.iterator();
                while (it2.hasNext()) {
                    ((zzgh) it2.next()).mo28307a(zzgd);
                }
            }
            return;
        }
        this.f21228f = message.arg1;
        Iterator it3 = this.f21225c.iterator();
        while (it3.hasNext()) {
            ((zzgh) it3.next()).mo28309a(this.f21227e, this.f21228f);
        }
    }
}
