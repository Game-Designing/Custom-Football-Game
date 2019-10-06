package com.crashlytics.android;

import com.crashlytics.android.p124a.C6378b;
import com.crashlytics.android.p125b.C6405a;
import com.crashlytics.android.p126c.C6472aa;
import com.crashlytics.android.p126c.C6472aa.C6473a;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import p024io.fabric.sdk.android.C0102l;
import p024io.fabric.sdk.android.C0103m;
import p024io.fabric.sdk.android.C13920f;

/* renamed from: com.crashlytics.android.a */
/* compiled from: Crashlytics */
public class C0075a extends C0102l<Void> implements C0103m {

    /* renamed from: g */
    public final C6378b f86g;

    /* renamed from: h */
    public final C6405a f87h;

    /* renamed from: i */
    public final C6472aa f88i;

    /* renamed from: j */
    public final Collection<? extends C0102l> f89j;

    /* renamed from: com.crashlytics.android.a$a */
    /* compiled from: Crashlytics */
    public static class C0076a {

        /* renamed from: a */
        private C6378b f90a;

        /* renamed from: b */
        private C6405a f91b;

        /* renamed from: c */
        private C6472aa f92c;

        /* renamed from: d */
        private C6473a f93d;

        /* renamed from: a */
        public C0076a mo2537a(C6472aa core) {
            if (core == null) {
                throw new NullPointerException("CrashlyticsCore Kit must not be null.");
            } else if (this.f92c == null) {
                this.f92c = core;
                return this;
            } else {
                throw new IllegalStateException("CrashlyticsCore Kit already set.");
            }
        }

        /* renamed from: a */
        public C0075a mo2538a() {
            C6473a aVar = this.f93d;
            if (aVar != null) {
                if (this.f92c == null) {
                    this.f92c = aVar.mo19524a();
                } else {
                    throw new IllegalStateException("Must not use Deprecated methods delay(), disabled(), listener(), pinningInfoProvider() with core()");
                }
            }
            if (this.f90a == null) {
                this.f90a = new C6378b();
            }
            if (this.f91b == null) {
                this.f91b = new C6405a();
            }
            if (this.f92c == null) {
                this.f92c = new C6472aa();
            }
            return new C0075a(this.f90a, this.f91b, this.f92c);
        }
    }

    public C0075a() {
        this(new C6378b(), new C6405a(), new C6472aa());
    }

    C0075a(C6378b answers, C6405a beta, C6472aa core) {
        this.f86g = answers;
        this.f87h = beta;
        this.f88i = core;
        this.f89j = Collections.unmodifiableCollection(Arrays.asList(new C0102l[]{answers, beta, core}));
    }

    /* renamed from: w */
    public String mo2536w() {
        return "2.10.0.33";
    }

    /* renamed from: u */
    public String mo2535u() {
        return "com.crashlytics.sdk.android:crashlytics";
    }

    /* renamed from: f */
    public Collection<? extends C0102l> mo2533f() {
        String str = "!SDK-VERSION-STRING!:com.crashlytics.sdk.android:crashlytics:2.10.0.33";
        return this.f89j;
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public Void m542g() {
        return null;
    }

    /* renamed from: A */
    public static C0075a m536A() {
        return (C0075a) C13920f.m44237a(C0075a.class);
    }

    /* renamed from: a */
    public static void m539a(Throwable throwable) {
        m537B();
        m536A().f88i.mo19521a(throwable);
    }

    /* renamed from: a */
    public static void m538a(String key, String value) {
        m537B();
        m536A().f88i.mo19520a(key, value);
    }

    /* renamed from: B */
    private static void m537B() {
        if (m536A() == null) {
            throw new IllegalStateException("Crashlytics must be initialized by calling Fabric.with(Context) prior to calling Crashlytics.getInstance()");
        }
    }
}
