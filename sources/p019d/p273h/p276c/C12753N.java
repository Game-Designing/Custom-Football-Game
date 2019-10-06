package p019d.p273h.p276c;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import p005cm.aptoide.p006pt.account.AndroidAccountManagerPersistence;
import p019d.p273h.p274a.C12729f;
import p019d.p273h.p274a.C12729f.C12730a;
import p019d.p273h.p276c.C12741D.C12742a;
import p019d.p273h.p276c.C12747I.C12748a;
import p019d.p273h.p276c.p277a.C12773b;
import p019d.p273h.p276c.p280d.C12800c.C12801a;
import p019d.p273h.p276c.p280d.C12802d;
import p019d.p273h.p276c.p282f.C12887na;
import p019d.p273h.p276c.p284h.C12913g;
import p019d.p273h.p276c.p284h.C12916j;
import p019d.p273h.p276c.p284h.C12917k;

/* renamed from: d.h.c.N */
/* compiled from: MediationInitializer */
class C12753N implements C12730a {

    /* renamed from: a */
    private static C12753N f39147a;

    /* renamed from: A */
    private C12755b f39148A;

    /* renamed from: b */
    private final String f39149b;

    /* renamed from: c */
    private final String f39150c;

    /* renamed from: d */
    private final String f39151d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f39152e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f39153f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f39154g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f39155h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f39156i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f39157j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f39158k;

    /* renamed from: l */
    private HandlerThread f39159l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public Handler f39160m;

    /* renamed from: n */
    private boolean f39161n;

    /* renamed from: o */
    private AtomicBoolean f39162o;

    /* renamed from: p */
    private C12729f f39163p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public CountDownTimer f39164q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public List<C12756c> f39165r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public Activity f39166s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public String f39167t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public String f39168u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public C12917k f39169v;

    /* renamed from: w */
    private C12754a f39170w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public String f39171x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public C12887na f39172y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public boolean f39173z;

    /* renamed from: d.h.c.N$a */
    /* compiled from: MediationInitializer */
    enum C12754a {
        NOT_INIT,
        INIT_IN_PROGRESS,
        INIT_FAILED,
        INITIATED
    }

    /* renamed from: d.h.c.N$b */
    /* compiled from: MediationInitializer */
    abstract class C12755b implements Runnable {

        /* renamed from: a */
        boolean f39179a = true;

        /* renamed from: b */
        String f39180b;

        /* renamed from: c */
        protected C12748a f39181c = new C12757O(this);

        C12755b() {
        }
    }

    /* renamed from: d.h.c.N$c */
    /* compiled from: MediationInitializer */
    interface C12756c {
        /* renamed from: a */
        void mo41204a();

        /* renamed from: a */
        void mo41212a(String str);

        /* renamed from: a */
        void mo41214a(List<C12742a> list, boolean z);
    }

    /* renamed from: b */
    public static synchronized C12753N m41255b() {
        C12753N n;
        synchronized (C12753N.class) {
            if (f39147a == null) {
                f39147a = new C12753N();
            }
            n = f39147a;
        }
        return n;
    }

    private C12753N() {
        this.f39149b = AndroidAccountManagerPersistence.ACCOUNT_ID;
        this.f39150c = "appKey";
        this.f39151d = getClass().getSimpleName();
        this.f39158k = false;
        this.f39159l = null;
        this.f39161n = false;
        this.f39165r = new ArrayList();
        this.f39148A = new C12750K(this);
        this.f39170w = C12754a.NOT_INIT;
        this.f39159l = new HandlerThread("IronSourceInitiatorHandler");
        this.f39159l.start();
        this.f39160m = new Handler(this.f39159l.getLooper());
        this.f39152e = 1;
        this.f39153f = 0;
        this.f39154g = 62;
        this.f39155h = 12;
        this.f39156i = 5;
        this.f39162o = new AtomicBoolean(true);
        this.f39157j = false;
        this.f39173z = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m41251a(C12754a status) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append("setInitStatus(old status: ");
        sb.append(this.f39170w);
        sb.append(", new status: ");
        sb.append(status);
        sb.append(")");
        c.mo41427b(aVar, sb.toString(), 0);
        this.f39170w = status;
    }

    /* renamed from: a */
    public synchronized void mo41248a(Activity activity, String appKey, String userId, C12742a... adUnits) {
        try {
            if (this.f39162o == null || !this.f39162o.compareAndSet(true, false)) {
                C12802d c = C12802d.m41613c();
                C12801a aVar = C12801a.API;
                StringBuilder sb = new StringBuilder();
                sb.append(this.f39151d);
                sb.append(": Multiple calls to init are not allowed");
                c.mo41427b(aVar, sb.toString(), 2);
            } else {
                m41251a(C12754a.INIT_IN_PROGRESS);
                this.f39166s = activity;
                this.f39167t = userId;
                this.f39168u = appKey;
                if (C12916j.m41982c((Context) activity)) {
                    this.f39160m.post(this.f39148A);
                } else {
                    this.f39161n = true;
                    if (this.f39163p == null) {
                        this.f39163p = new C12729f(activity, this);
                    }
                    activity.getApplicationContext().registerReceiver(this.f39163p, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    new Handler(Looper.getMainLooper()).post(new C12752M(this));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    /* renamed from: a */
    public void mo41148a(boolean connected) {
        if (this.f39161n && connected) {
            CountDownTimer countDownTimer = this.f39164q;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.f39161n = false;
            this.f39157j = true;
            this.f39160m.post(this.f39148A);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean m41264e() {
        return this.f39157j;
    }

    /* renamed from: a */
    public synchronized C12754a mo41247a() {
        return this.f39170w;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo41251d() {
        m41251a(C12754a.INIT_FAILED);
    }

    /* renamed from: c */
    public synchronized boolean mo41250c() {
        return this.f39173z;
    }

    /* renamed from: a */
    public void mo41249a(C12756c listener) {
        if (listener != null) {
            this.f39165r.add(listener);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public C12773b m41247a(String userId) {
        C12773b result = new C12773b();
        String str = AndroidAccountManagerPersistence.ACCOUNT_ID;
        if (userId == null) {
            result.mo41314a(C12913g.m41921a(str, userId, "it's missing"));
        } else if (!m41254a(userId, 1, 64)) {
            result.mo41314a(C12913g.m41921a(str, userId, null));
        }
        return result;
    }

    /* renamed from: a */
    private boolean m41254a(String key, int minLength, int maxLength) {
        boolean z = false;
        if (key == null) {
            return false;
        }
        if (key.length() >= minLength && key.length() <= maxLength) {
            z = true;
        }
        return z;
    }
}
