package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Collections;
import java.util.Map;

public abstract class zzr<T> implements Comparable<zzr<T>> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C9869a f29197a;

    /* renamed from: b */
    private final int f29198b;

    /* renamed from: c */
    private final String f29199c;

    /* renamed from: d */
    private final int f29200d;

    /* renamed from: e */
    private final Object f29201e;

    /* renamed from: f */
    private zzz f29202f;

    /* renamed from: g */
    private Integer f29203g;

    /* renamed from: h */
    private zzv f29204h;

    /* renamed from: i */
    private boolean f29205i;

    /* renamed from: j */
    private boolean f29206j;

    /* renamed from: k */
    private boolean f29207k;

    /* renamed from: l */
    private boolean f29208l;

    /* renamed from: m */
    private zzac f29209m;

    /* renamed from: n */
    private zzc f29210n;

    /* renamed from: o */
    private C9244Xs f29211o;

    public zzr(int i, String str, zzz zzz) {
        this.f29197a = C9869a.f24302a ? new C9869a() : null;
        this.f29201e = new Object();
        this.f29205i = true;
        int i2 = 0;
        this.f29206j = false;
        this.f29207k = false;
        this.f29208l = false;
        this.f29210n = null;
        this.f29198b = i;
        this.f29199c = str;
        this.f29202f = zzz;
        this.f29209m = new zzh();
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String host = parse.getHost();
                if (host != null) {
                    i2 = host.hashCode();
                }
            }
        }
        this.f29200d = i2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract zzy<T> mo30196a(zzp zzp);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo29242a(T t);

    /* renamed from: f */
    public final int mo32130f() {
        return this.f29198b;
    }

    /* renamed from: j */
    public final int mo32133j() {
        return this.f29200d;
    }

    /* renamed from: a */
    public final void mo32126a(String str) {
        if (C9869a.f24302a) {
            this.f29197a.mo29704a(str, Thread.currentThread().getId());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo32128b(String str) {
        zzv zzv = this.f29204h;
        if (zzv != null) {
            zzv.mo32303b(this);
        }
        if (C9869a.f24302a) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new C9181Us(this, str, id));
            } else {
                this.f29197a.mo29704a(str, id);
                this.f29197a.mo29703a(toString());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo32122a(int i) {
        zzv zzv = this.f29204h;
        if (zzv != null) {
            zzv.mo32302a(this, i);
        }
    }

    /* renamed from: a */
    public final zzr<?> mo32121a(zzv zzv) {
        this.f29204h = zzv;
        return this;
    }

    /* renamed from: b */
    public final zzr<?> mo32127b(int i) {
        this.f29203g = Integer.valueOf(i);
        return this;
    }

    /* renamed from: g */
    public final String mo32131g() {
        return this.f29199c;
    }

    /* renamed from: s */
    public final String mo32134s() {
        String str = this.f29199c;
        int i = this.f29198b;
        if (i == 0 || i == -1) {
            return str;
        }
        String num = Integer.toString(i);
        StringBuilder sb = new StringBuilder(String.valueOf(num).length() + 1 + String.valueOf(str).length());
        sb.append(num);
        sb.append('-');
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: a */
    public final zzr<?> mo32120a(zzc zzc) {
        this.f29210n = zzc;
        return this;
    }

    /* renamed from: t */
    public final zzc mo32135t() {
        return this.f29210n;
    }

    /* renamed from: i */
    public final boolean mo32132i() {
        synchronized (this.f29201e) {
        }
        return false;
    }

    /* renamed from: e */
    public Map<String, String> mo29244e() throws zza {
        return Collections.emptyMap();
    }

    /* renamed from: u */
    public byte[] mo29245u() throws zza {
        return null;
    }

    /* renamed from: v */
    public final boolean mo32137v() {
        return this.f29205i;
    }

    /* renamed from: w */
    public final int mo32138w() {
        return this.f29209m.mo29576G();
    }

    /* renamed from: x */
    public final zzac mo32139x() {
        return this.f29209m;
    }

    /* renamed from: y */
    public final void mo32140y() {
        synchronized (this.f29201e) {
            this.f29207k = true;
        }
    }

    /* renamed from: z */
    public final boolean mo32141z() {
        boolean z;
        synchronized (this.f29201e) {
            z = this.f29207k;
        }
        return z;
    }

    /* renamed from: a */
    public final void mo32124a(zzaf zzaf) {
        zzz zzz;
        synchronized (this.f29201e) {
            zzz = this.f29202f;
        }
        if (zzz != null) {
            zzz.mo29229a(zzaf);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo32123a(C9244Xs xs) {
        synchronized (this.f29201e) {
            this.f29211o = xs;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo32125a(zzy<?> zzy) {
        C9244Xs xs;
        synchronized (this.f29201e) {
            xs = this.f29211o;
        }
        if (xs != null) {
            xs.mo28245a(this, zzy);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: A */
    public final void mo32119A() {
        C9244Xs xs;
        synchronized (this.f29201e) {
            xs = this.f29211o;
        }
        if (xs != null) {
            xs.mo28244a(this);
        }
    }

    public String toString() {
        String valueOf = String.valueOf(Integer.toHexString(this.f29200d));
        String str = "0x";
        String concat = valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
        mo32132i();
        String str2 = "[ ] ";
        String str3 = this.f29199c;
        String valueOf2 = String.valueOf(zzu.NORMAL);
        String valueOf3 = String.valueOf(this.f29203g);
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 3 + String.valueOf(str3).length() + String.valueOf(concat).length() + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length());
        sb.append(str2);
        sb.append(str3);
        String str4 = " ";
        sb.append(str4);
        sb.append(concat);
        sb.append(str4);
        sb.append(valueOf2);
        sb.append(str4);
        sb.append(valueOf3);
        return sb.toString();
    }

    public /* synthetic */ int compareTo(Object obj) {
        zzr zzr = (zzr) obj;
        zzu zzu = zzu.NORMAL;
        return zzu == zzu ? this.f29203g.intValue() - zzr.f29203g.intValue() : zzu.ordinal() - zzu.ordinal();
    }
}
