package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.common.zze;
import java.util.HashMap;

/* renamed from: com.google.android.gms.common.internal.j */
final class C8709j extends GmsClientSupervisor implements Callback {
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final HashMap<zza, C8710k> f20155c = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Context f20156d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Handler f20157e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final ConnectionTracker f20158f;

    /* renamed from: g */
    private final long f20159g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final long f20160h;

    C8709j(Context context) {
        this.f20156d = context.getApplicationContext();
        this.f20157e = new zze(context.getMainLooper(), this);
        this.f20158f = ConnectionTracker.m22050a();
        this.f20159g = 5000;
        this.f20160h = 300000;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo27791a(zza zza, ServiceConnection serviceConnection, String str) {
        boolean d;
        Preconditions.m21858a(serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f20155c) {
            C8710k kVar = (C8710k) this.f20155c.get(zza);
            if (kVar == null) {
                kVar = new C8710k(this, zza);
                kVar.mo27834a(serviceConnection, str);
                kVar.mo27835a(str);
                this.f20155c.put(zza, kVar);
            } else {
                this.f20157e.removeMessages(0, zza);
                if (!kVar.mo27836a(serviceConnection)) {
                    kVar.mo27834a(serviceConnection, str);
                    int c = kVar.mo27840c();
                    if (c == 1) {
                        serviceConnection.onServiceConnected(kVar.mo27837b(), kVar.mo27833a());
                    } else if (c == 2) {
                        kVar.mo27835a(str);
                    }
                } else {
                    String valueOf = String.valueOf(zza);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
            }
            d = kVar.mo27841d();
        }
        return d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo27792b(zza zza, ServiceConnection serviceConnection, String str) {
        Preconditions.m21858a(serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f20155c) {
            C8710k kVar = (C8710k) this.f20155c.get(zza);
            if (kVar == null) {
                String valueOf = String.valueOf(zza);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 50);
                sb.append("Nonexistent connection status for service config: ");
                sb.append(valueOf);
                throw new IllegalStateException(sb.toString());
            } else if (kVar.mo27836a(serviceConnection)) {
                kVar.mo27838b(serviceConnection, str);
                if (kVar.mo27842e()) {
                    this.f20157e.sendMessageDelayed(this.f20157e.obtainMessage(0, zza), this.f20159g);
                }
            } else {
                String valueOf2 = String.valueOf(zza);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 76);
                sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb2.append(valueOf2);
                throw new IllegalStateException(sb2.toString());
            }
        }
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            synchronized (this.f20155c) {
                zza zza = (zza) message.obj;
                C8710k kVar = (C8710k) this.f20155c.get(zza);
                if (kVar != null && kVar.mo27842e()) {
                    if (kVar.mo27841d()) {
                        kVar.mo27839b("GmsClientSupervisor");
                    }
                    this.f20155c.remove(zza);
                }
            }
            return true;
        } else if (i != 1) {
            return false;
        } else {
            synchronized (this.f20155c) {
                zza zza2 = (zza) message.obj;
                C8710k kVar2 = (C8710k) this.f20155c.get(zza2);
                if (kVar2 != null && kVar2.mo27840c() == 3) {
                    String valueOf = String.valueOf(zza2);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append("Timeout waiting for ServiceConnection callback ");
                    sb.append(valueOf);
                    Log.e("GmsClientSupervisor", sb.toString(), new Exception());
                    ComponentName b = kVar2.mo27837b();
                    if (b == null) {
                        b = zza2.mo27793a();
                    }
                    if (b == null) {
                        b = new ComponentName(zza2.mo27795b(), "unknown");
                    }
                    kVar2.onServiceDisconnected(b);
                }
            }
            return true;
        }
    }
}
