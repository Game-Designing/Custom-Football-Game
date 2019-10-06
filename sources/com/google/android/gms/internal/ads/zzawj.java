package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@zzard
public final class zzawj {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Clock f24876a;

    /* renamed from: b */
    private final zzawu f24877b;

    /* renamed from: c */
    private final LinkedList<C9164Ub> f24878c;

    /* renamed from: d */
    private final Object f24879d = new Object();

    /* renamed from: e */
    private final String f24880e;

    /* renamed from: f */
    private final String f24881f;

    /* renamed from: g */
    private long f24882g = -1;

    /* renamed from: h */
    private long f24883h = -1;

    /* renamed from: i */
    private boolean f24884i = false;

    /* renamed from: j */
    private long f24885j = -1;

    /* renamed from: k */
    private long f24886k = 0;

    /* renamed from: l */
    private long f24887l = -1;

    /* renamed from: m */
    private long f24888m = -1;

    zzawj(Clock clock, zzawu zzawu, String str, String str2) {
        this.f24876a = clock;
        this.f24877b = zzawu;
        this.f24880e = str;
        this.f24881f = str2;
        this.f24878c = new LinkedList<>();
    }

    /* renamed from: a */
    public final void mo30153a(zzxz zzxz) {
        synchronized (this.f24879d) {
            this.f24887l = this.f24876a.mo27934a();
            this.f24877b.mo30192a(zzxz, this.f24887l);
        }
    }

    /* renamed from: a */
    public final void mo30152a(long j) {
        synchronized (this.f24879d) {
            this.f24888m = j;
            if (this.f24888m != -1) {
                this.f24877b.mo30191a(this);
            }
        }
    }

    /* renamed from: b */
    public final void mo30155b() {
        synchronized (this.f24879d) {
            if (this.f24888m != -1 && this.f24883h == -1) {
                this.f24883h = this.f24876a.mo27934a();
                this.f24877b.mo30191a(this);
            }
            this.f24877b.mo30190a();
        }
    }

    /* renamed from: c */
    public final void mo30156c() {
        synchronized (this.f24879d) {
            if (this.f24888m != -1) {
                C9164Ub ub = new C9164Ub(this);
                ub.mo28629d();
                this.f24878c.add(ub);
                this.f24886k++;
                this.f24877b.mo30194b();
                this.f24877b.mo30191a(this);
            }
        }
    }

    /* renamed from: d */
    public final void mo30157d() {
        synchronized (this.f24879d) {
            if (this.f24888m != -1 && !this.f24878c.isEmpty()) {
                C9164Ub ub = (C9164Ub) this.f24878c.getLast();
                if (ub.mo28627b() == -1) {
                    ub.mo28628c();
                    this.f24877b.mo30191a(this);
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo30154a(boolean z) {
        synchronized (this.f24879d) {
            if (this.f24888m != -1) {
                this.f24885j = this.f24876a.mo27934a();
            }
        }
    }

    /* renamed from: a */
    public final Bundle mo30151a() {
        Bundle bundle;
        synchronized (this.f24879d) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.f24880e);
            bundle.putString("slotid", this.f24881f);
            bundle.putBoolean("ismediation", false);
            bundle.putLong("treq", this.f24887l);
            bundle.putLong("tresponse", this.f24888m);
            bundle.putLong("timp", this.f24883h);
            bundle.putLong("tload", this.f24885j);
            bundle.putLong("pcc", this.f24886k);
            bundle.putLong("tfetch", this.f24882g);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f24878c.iterator();
            while (it.hasNext()) {
                arrayList.add(((C9164Ub) it.next()).mo28626a());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }

    /* renamed from: e */
    public final String mo30158e() {
        return this.f24880e;
    }
}
