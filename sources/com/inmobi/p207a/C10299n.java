package com.inmobi.p207a;

import com.inmobi.commons.core.utilities.p225b.C10691b;
import com.inmobi.commons.core.utilities.p225b.C10698h;

/* renamed from: com.inmobi.a.n */
/* compiled from: SessionManager */
public class C10299n {

    /* renamed from: g */
    private static final String f31205g = C10299n.class.getSimpleName();

    /* renamed from: h */
    private static C10299n f31206h;

    /* renamed from: i */
    private static final Object f31207i = new Object();

    /* renamed from: a */
    long f31208a = 0;

    /* renamed from: b */
    long f31209b = 0;

    /* renamed from: c */
    long f31210c = 0;

    /* renamed from: d */
    long f31211d = 0;

    /* renamed from: e */
    long f31212e = 0;

    /* renamed from: f */
    long f31213f = 0;

    /* renamed from: a */
    public static C10299n m33566a() {
        C10299n nVar = f31206h;
        if (nVar == null) {
            synchronized (f31207i) {
                nVar = f31206h;
                if (nVar == null) {
                    nVar = new C10299n();
                    f31206h = nVar;
                }
            }
        }
        return nVar;
    }

    private C10299n() {
    }

    /* renamed from: b */
    static C10698h m33567b() {
        if (!C10300o.m33571a().f31217a.f31222a.mo33677b()) {
            return null;
        }
        return C10698h.m35136a();
    }

    /* renamed from: a */
    public final void mo33663a(long j) {
        int a = C10691b.m35099a();
        if (a != 0) {
            if (a == 1) {
                this.f31208a += j;
            }
            return;
        }
        this.f31210c += j;
    }

    /* renamed from: b */
    public final void mo33664b(long j) {
        int a = C10691b.m35099a();
        if (a != 0) {
            if (a == 1) {
                this.f31209b += j;
            }
            return;
        }
        this.f31211d += j;
    }

    /* renamed from: c */
    public final void mo33665c(long j) {
        this.f31212e += j;
    }
}
