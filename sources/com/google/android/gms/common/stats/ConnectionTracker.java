package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;
import java.util.List;

@KeepForSdk
public class ConnectionTracker {

    /* renamed from: a */
    private static final Object f20251a = new Object();

    /* renamed from: b */
    private static volatile ConnectionTracker f20252b;
    @VisibleForTesting

    /* renamed from: c */
    private static boolean f20253c = false;

    /* renamed from: d */
    private final List<String> f20254d;

    /* renamed from: e */
    private final List<String> f20255e;

    /* renamed from: f */
    private final List<String> f20256f;

    /* renamed from: g */
    private final List<String> f20257g;

    @KeepForSdk
    /* renamed from: a */
    public static ConnectionTracker m22050a() {
        if (f20252b == null) {
            synchronized (f20251a) {
                if (f20252b == null) {
                    f20252b = new ConnectionTracker();
                }
            }
        }
        return f20252b;
    }

    private ConnectionTracker() {
        List<String> list = Collections.EMPTY_LIST;
        this.f20254d = list;
        this.f20255e = list;
        this.f20256f = list;
        this.f20257g = list;
    }

    /* renamed from: a */
    public final boolean mo27925a(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        boolean z;
        ComponentName component = intent.getComponent();
        if (component == null) {
            z = false;
        } else {
            z = ClientLibraryUtils.m22074b(context, component.getPackageName());
        }
        if (!z) {
            return context.bindService(intent, serviceConnection, i);
        }
        Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
        return false;
    }

    @KeepForSdk
    /* renamed from: a */
    public boolean mo27924a(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return mo27925a(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    @SuppressLint({"UntrackedBindService"})
    @KeepForSdk
    /* renamed from: a */
    public void mo27923a(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
    }
}
