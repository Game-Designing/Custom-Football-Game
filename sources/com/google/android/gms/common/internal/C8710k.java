package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.common.internal.k */
final class C8710k implements ServiceConnection {

    /* renamed from: a */
    private final Set<ServiceConnection> f20161a = new HashSet();

    /* renamed from: b */
    private int f20162b = 2;

    /* renamed from: c */
    private boolean f20163c;

    /* renamed from: d */
    private IBinder f20164d;

    /* renamed from: e */
    private final zza f20165e;

    /* renamed from: f */
    private ComponentName f20166f;

    /* renamed from: g */
    private final /* synthetic */ C8709j f20167g;

    public C8710k(C8709j jVar, zza zza) {
        this.f20167g = jVar;
        this.f20165e = zza;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f20167g.f20155c) {
            this.f20167g.f20157e.removeMessages(1, this.f20165e);
            this.f20164d = iBinder;
            this.f20166f = componentName;
            for (ServiceConnection onServiceConnected : this.f20161a) {
                onServiceConnected.onServiceConnected(componentName, iBinder);
            }
            this.f20162b = 1;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f20167g.f20155c) {
            this.f20167g.f20157e.removeMessages(1, this.f20165e);
            this.f20164d = null;
            this.f20166f = componentName;
            for (ServiceConnection onServiceDisconnected : this.f20161a) {
                onServiceDisconnected.onServiceDisconnected(componentName);
            }
            this.f20162b = 2;
        }
    }

    /* renamed from: a */
    public final void mo27835a(String str) {
        this.f20162b = 3;
        this.f20163c = this.f20167g.f20158f.mo27925a(this.f20167g.f20156d, str, this.f20165e.mo27794a(this.f20167g.f20156d), this, this.f20165e.mo27796c());
        if (this.f20163c) {
            this.f20167g.f20157e.sendMessageDelayed(this.f20167g.f20157e.obtainMessage(1, this.f20165e), this.f20167g.f20160h);
            return;
        }
        this.f20162b = 2;
        try {
            this.f20167g.f20158f.mo27923a(this.f20167g.f20156d, this);
        } catch (IllegalArgumentException e) {
        }
    }

    /* renamed from: b */
    public final void mo27839b(String str) {
        this.f20167g.f20157e.removeMessages(1, this.f20165e);
        this.f20167g.f20158f.mo27923a(this.f20167g.f20156d, this);
        this.f20163c = false;
        this.f20162b = 2;
    }

    /* renamed from: a */
    public final void mo27834a(ServiceConnection serviceConnection, String str) {
        this.f20167g.f20158f;
        this.f20167g.f20156d;
        this.f20165e.mo27794a(this.f20167g.f20156d);
        this.f20161a.add(serviceConnection);
    }

    /* renamed from: b */
    public final void mo27838b(ServiceConnection serviceConnection, String str) {
        this.f20167g.f20158f;
        this.f20167g.f20156d;
        this.f20161a.remove(serviceConnection);
    }

    /* renamed from: d */
    public final boolean mo27841d() {
        return this.f20163c;
    }

    /* renamed from: c */
    public final int mo27840c() {
        return this.f20162b;
    }

    /* renamed from: a */
    public final boolean mo27836a(ServiceConnection serviceConnection) {
        return this.f20161a.contains(serviceConnection);
    }

    /* renamed from: e */
    public final boolean mo27842e() {
        return this.f20161a.isEmpty();
    }

    /* renamed from: a */
    public final IBinder mo27833a() {
        return this.f20164d;
    }

    /* renamed from: b */
    public final ComponentName mo27837b() {
        return this.f20166f;
    }
}
