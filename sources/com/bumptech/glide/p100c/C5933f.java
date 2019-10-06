package com.bumptech.glide.p100c;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.bumptech.glide.p100c.C5929c.C5930a;
import com.bumptech.glide.p107h.C6024i;

/* renamed from: com.bumptech.glide.c.f */
/* compiled from: DefaultConnectivityMonitor */
final class C5933f implements C5929c {

    /* renamed from: a */
    private final Context f10447a;

    /* renamed from: b */
    final C5930a f10448b;

    /* renamed from: c */
    boolean f10449c;

    /* renamed from: d */
    private boolean f10450d;

    /* renamed from: e */
    private final BroadcastReceiver f10451e = new C5932e(this);

    C5933f(Context context, C5930a listener) {
        this.f10447a = context.getApplicationContext();
        this.f10448b = listener;
    }

    /* renamed from: a */
    private void m10946a() {
        if (!this.f10450d) {
            this.f10449c = mo18598a(this.f10447a);
            try {
                this.f10447a.registerReceiver(this.f10451e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                this.f10450d = true;
            } catch (SecurityException e) {
                String str = "ConnectivityMonitor";
                if (Log.isLoggable(str, 5)) {
                    Log.w(str, "Failed to register", e);
                }
            }
        }
    }

    /* renamed from: b */
    private void m10947b() {
        if (this.f10450d) {
            this.f10447a.unregisterReceiver(this.f10451e);
            this.f10450d = false;
        }
    }

    /* access modifiers changed from: 0000 */
    @SuppressLint({"MissingPermission"})
    /* renamed from: a */
    public boolean mo18598a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        C6024i.m11264a(connectivityManager);
        boolean z = true;
        try {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo == null || !networkInfo.isConnected()) {
                z = false;
            }
            return z;
        } catch (RuntimeException e) {
            String str = "ConnectivityMonitor";
            if (Log.isLoggable(str, 5)) {
                Log.w(str, "Failed to determine connectivity status when connectivity changed", e);
            }
            return true;
        }
    }

    public void onStart() {
        m10946a();
    }

    public void onStop() {
        m10947b();
    }

    public void onDestroy() {
    }
}
