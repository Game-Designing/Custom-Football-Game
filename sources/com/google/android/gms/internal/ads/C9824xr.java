package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: com.google.android.gms.internal.ads.xr */
final class C9824xr implements zzkv {

    /* renamed from: a */
    private final zzlo[] f23481a;

    /* renamed from: b */
    private final zzrp f23482b;

    /* renamed from: c */
    private final zzro f23483c;

    /* renamed from: d */
    private final Handler f23484d;

    /* renamed from: e */
    private final C9866zr f23485e;

    /* renamed from: f */
    private final CopyOnWriteArraySet<zzkw> f23486f;

    /* renamed from: g */
    private final zzlu f23487g;

    /* renamed from: h */
    private final zzlt f23488h;

    /* renamed from: i */
    private boolean f23489i;

    /* renamed from: j */
    private boolean f23490j;

    /* renamed from: k */
    private int f23491k;

    /* renamed from: l */
    private int f23492l;

    /* renamed from: m */
    private int f23493m;

    /* renamed from: n */
    private int f23494n;

    /* renamed from: o */
    private boolean f23495o;

    /* renamed from: p */
    private zzlr f23496p;

    /* renamed from: q */
    private Object f23497q;

    /* renamed from: r */
    private zzrb f23498r;

    /* renamed from: s */
    private zzro f23499s;

    /* renamed from: t */
    private zzln f23500t;

    /* renamed from: u */
    private zzle f23501u;

    /* renamed from: v */
    private int f23502v;

    /* renamed from: w */
    private int f23503w;

    /* renamed from: x */
    private long f23504x;

    @SuppressLint({"HandlerLeak"})
    public C9824xr(zzlo[] zzloArr, zzrp zzrp, zzll zzll) {
        String str = zzsy.f29349e;
        String str2 = "Init ExoPlayerLib/2.4.2 [";
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(str).length());
        sb.append(str2);
        sb.append(str);
        sb.append("]");
        Log.i("ExoPlayerImpl", sb.toString());
        zzsk.m31082b(zzloArr.length > 0);
        zzsk.m31078a(zzloArr);
        this.f23481a = zzloArr;
        zzsk.m31078a(zzrp);
        this.f23482b = zzrp;
        this.f23490j = false;
        this.f23491k = 0;
        this.f23492l = 1;
        this.f23486f = new CopyOnWriteArraySet<>();
        this.f23483c = new zzro(new zzrm[zzloArr.length]);
        this.f23496p = zzlr.f28815a;
        this.f23487g = new zzlu();
        this.f23488h = new zzlt();
        this.f23498r = zzrb.f29215a;
        this.f23499s = this.f23483c;
        this.f23500t = zzln.f28809a;
        this.f23484d = new C9845yr(this, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        this.f23501u = new zzle(0, 0);
        C9866zr zrVar = new C9866zr(zzloArr, zzrp, zzll, this.f23490j, 0, this.f23484d, this.f23501u, this);
        this.f23485e = zrVar;
    }

    /* renamed from: b */
    public final void mo29278b(zzkw zzkw) {
        this.f23486f.add(zzkw);
    }

    /* renamed from: a */
    public final void mo29273a(zzkw zzkw) {
        this.f23486f.remove(zzkw);
    }

    /* renamed from: i */
    public final int mo29284i() {
        return this.f23492l;
    }

    /* renamed from: a */
    public final void mo29274a(zzql zzql) {
        if (!this.f23496p.mo31960a() || this.f23497q != null) {
            this.f23496p = zzlr.f28815a;
            this.f23497q = null;
            Iterator it = this.f23486f.iterator();
            while (it.hasNext()) {
                ((zzkw) it.next()).mo30513a(this.f23496p, this.f23497q);
            }
        }
        if (this.f23489i) {
            this.f23489i = false;
            this.f23498r = zzrb.f29215a;
            this.f23499s = this.f23483c;
            this.f23482b.mo32161a((Object) null);
            Iterator it2 = this.f23486f.iterator();
            while (it2.hasNext()) {
                ((zzkw) it2.next()).mo30515a(this.f23498r, this.f23499s);
            }
        }
        this.f23494n++;
        this.f23485e.mo29336a(zzql, true);
    }

    /* renamed from: a */
    public final void mo29275a(boolean z) {
        if (this.f23490j != z) {
            this.f23490j = z;
            this.f23485e.mo29337a(z);
            Iterator it = this.f23486f.iterator();
            while (it.hasNext()) {
                ((zzkw) it.next()).mo30522a(z, this.f23492l);
            }
        }
    }

    /* renamed from: d */
    public final boolean mo29281d() {
        return this.f23490j;
    }

    /* renamed from: a */
    public final void mo29271a(long j) {
        int f = m24280f();
        if (f < 0 || (!this.f23496p.mo31960a() && f >= this.f23496p.mo28172b())) {
            throw new zzlk(this.f23496p, f, j);
        }
        this.f23493m++;
        this.f23502v = f;
        if (this.f23496p.mo31960a()) {
            this.f23503w = 0;
        } else {
            this.f23496p.mo31959a(f, this.f23487g, false);
            if (j != -9223372036854775807L) {
                zzkt.m30597b(j);
            }
            this.f23496p.mo28170a(0, this.f23488h, false);
            this.f23503w = 0;
        }
        if (j == -9223372036854775807L) {
            this.f23504x = 0;
            this.f23485e.mo29335a(this.f23496p, f, -9223372036854775807L);
            return;
        }
        this.f23504x = j;
        this.f23485e.mo29335a(this.f23496p, f, zzkt.m30597b(j));
        Iterator it = this.f23486f.iterator();
        while (it.hasNext()) {
            ((zzkw) it.next()).mo30502a();
        }
    }

    public final void stop() {
        this.f23485e.mo29341c();
    }

    /* renamed from: a */
    public final void mo29270a() {
        this.f23485e.mo29339b();
        this.f23484d.removeCallbacksAndMessages(null);
    }

    /* renamed from: a */
    public final void mo29276a(zzky... zzkyArr) {
        this.f23485e.mo29338a(zzkyArr);
    }

    /* renamed from: b */
    public final void mo29279b(zzky... zzkyArr) {
        this.f23485e.mo29340b(zzkyArr);
    }

    /* renamed from: f */
    private final int m24280f() {
        if (this.f23496p.mo31960a() || this.f23493m > 0) {
            return this.f23502v;
        }
        this.f23496p.mo28170a(this.f23501u.f28770a, this.f23488h, false);
        return 0;
    }

    public final long getDuration() {
        if (this.f23496p.mo31960a()) {
            return -9223372036854775807L;
        }
        return zzkt.m30596a(this.f23496p.mo31959a(m24280f(), this.f23487g, false).f28830i);
    }

    /* renamed from: c */
    public final long mo29280c() {
        if (this.f23496p.mo31960a() || this.f23493m > 0) {
            return this.f23504x;
        }
        this.f23496p.mo28170a(this.f23501u.f28770a, this.f23488h, false);
        return this.f23488h.mo31961a() + zzkt.m30596a(this.f23501u.f28772c);
    }

    /* renamed from: b */
    public final long mo29277b() {
        if (this.f23496p.mo31960a() || this.f23493m > 0) {
            return this.f23504x;
        }
        this.f23496p.mo28170a(this.f23501u.f28770a, this.f23488h, false);
        return this.f23488h.mo31961a() + zzkt.m30596a(this.f23501u.f28773d);
    }

    /* renamed from: e */
    public final int mo29282e() {
        return this.f23481a.length;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo29272a(Message message) {
        boolean z = true;
        switch (message.what) {
            case 0:
                this.f23494n--;
                return;
            case 1:
                this.f23492l = message.arg1;
                Iterator it = this.f23486f.iterator();
                while (it.hasNext()) {
                    ((zzkw) it.next()).mo30522a(this.f23490j, this.f23492l);
                }
                return;
            case 2:
                if (message.arg1 == 0) {
                    z = false;
                }
                this.f23495o = z;
                Iterator it2 = this.f23486f.iterator();
                while (it2.hasNext()) {
                    ((zzkw) it2.next()).mo30521a(this.f23495o);
                }
                return;
            case 3:
                if (this.f23494n == 0) {
                    zzrr zzrr = (zzrr) message.obj;
                    this.f23489i = true;
                    this.f23498r = zzrr.f29257a;
                    this.f23499s = zzrr.f29258b;
                    this.f23482b.mo32161a(zzrr.f29259c);
                    Iterator it3 = this.f23486f.iterator();
                    while (it3.hasNext()) {
                        ((zzkw) it3.next()).mo30515a(this.f23498r, this.f23499s);
                    }
                    return;
                }
                break;
            case 4:
                int i = this.f23493m - 1;
                this.f23493m = i;
                if (i == 0) {
                    this.f23501u = (zzle) message.obj;
                    if (message.arg1 != 0) {
                        Iterator it4 = this.f23486f.iterator();
                        while (it4.hasNext()) {
                            ((zzkw) it4.next()).mo30502a();
                        }
                        return;
                    }
                }
                break;
            case 5:
                if (this.f23493m == 0) {
                    this.f23501u = (zzle) message.obj;
                    Iterator it5 = this.f23486f.iterator();
                    while (it5.hasNext()) {
                        ((zzkw) it5.next()).mo30502a();
                    }
                    return;
                }
                break;
            case 6:
                zzlg zzlg = (zzlg) message.obj;
                this.f23493m -= zzlg.f28777d;
                if (this.f23494n == 0) {
                    this.f23496p = zzlg.f28774a;
                    this.f23497q = zzlg.f28775b;
                    this.f23501u = zzlg.f28776c;
                    Iterator it6 = this.f23486f.iterator();
                    while (it6.hasNext()) {
                        ((zzkw) it6.next()).mo30513a(this.f23496p, this.f23497q);
                    }
                    return;
                }
                break;
            case 7:
                zzln zzln = (zzln) message.obj;
                if (!this.f23500t.equals(zzln)) {
                    this.f23500t = zzln;
                    Iterator it7 = this.f23486f.iterator();
                    while (it7.hasNext()) {
                        ((zzkw) it7.next()).mo30512a(zzln);
                    }
                    return;
                }
                break;
            case 8:
                zzku zzku = (zzku) message.obj;
                Iterator it8 = this.f23486f.iterator();
                while (it8.hasNext()) {
                    ((zzkw) it8.next()).mo30510a(zzku);
                }
                return;
            default:
                throw new IllegalStateException();
        }
    }
}
