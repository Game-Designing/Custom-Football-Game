package com.flurry.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* renamed from: com.flurry.sdk.ob */
public class C7570ob extends BroadcastReceiver {

    /* renamed from: a */
    public static final String f14968a = C7570ob.class.getSimpleName();

    /* renamed from: b */
    private static C7570ob f14969b;

    /* renamed from: c */
    boolean f14970c;

    /* renamed from: d */
    public boolean f14971d;

    /* renamed from: e */
    private boolean f14972e = false;

    /* renamed from: f */
    private final C7452Sb<C7395Ib> f14973f = new C7559mb(this);

    /* renamed from: com.flurry.sdk.ob$a */
    public enum C7571a {
        ;
        

        /* renamed from: a */
        public static final int f14974a = 0;

        /* renamed from: b */
        public static final int f14975b = 0;

        /* renamed from: c */
        public static final int f14976c = 0;

        /* renamed from: d */
        public static final int f14977d = 0;

        static {
            f14974a = 1;
            f14975b = 2;
            f14976c = 3;
            f14977d = 4;
            f14978e = new int[]{f14974a, f14975b, f14976c, f14977d};
        }
    }

    private C7570ob() {
        boolean z = false;
        Context context = C7379Fb.m16300a().f14432d;
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
            z = true;
        }
        this.f14972e = z;
        this.f14971d = m16756a(context);
        if (this.f14972e) {
            m16758c();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m16756a(Context context) {
        if (!this.f14972e || context == null) {
            return true;
        }
        NetworkInfo activeNetworkInfo = m16759d().getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    private synchronized void m16758c() {
        if (!this.f14970c) {
            Context context = C7379Fb.m16300a().f14432d;
            this.f14971d = m16756a(context);
            context.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            C7462Ub.m16528a().mo23910a("com.flurry.android.sdk.ActivityLifecycleEvent", this.f14973f);
            this.f14970c = true;
        }
    }

    /* renamed from: d */
    private static ConnectivityManager m16759d() {
        return (ConnectivityManager) C7379Fb.m16300a().f14432d.getSystemService("connectivity");
    }

    /* renamed from: a */
    public static synchronized C7570ob m16755a() {
        C7570ob obVar;
        synchronized (C7570ob.class) {
            if (f14969b == null) {
                f14969b = new C7570ob();
            }
            obVar = f14969b;
        }
        return obVar;
    }

    public void onReceive(Context context, Intent intent) {
        boolean a = m16756a(context);
        if (this.f14971d != a) {
            this.f14971d = a;
            C7553lb lbVar = new C7553lb();
            lbVar.f14932b = a;
            lbVar.f14933c = mo23982b();
            C7462Ub.m16528a().mo23908a((C7447Rb) lbVar);
        }
    }

    /* renamed from: b */
    public final int mo23982b() {
        if (!this.f14972e) {
            return C7571a.f14974a;
        }
        NetworkInfo activeNetworkInfo = m16759d().getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return C7571a.f14974a;
        }
        int type = activeNetworkInfo.getType();
        if (type != 0) {
            if (type == 1) {
                return C7571a.f14976c;
            }
            if (!(type == 2 || type == 3 || type == 4 || type == 5)) {
                if (type == 8) {
                    return C7571a.f14974a;
                }
                if (activeNetworkInfo.isConnected()) {
                    return C7571a.f14975b;
                }
                return C7571a.f14974a;
            }
        }
        return C7571a.f14977d;
    }
}
