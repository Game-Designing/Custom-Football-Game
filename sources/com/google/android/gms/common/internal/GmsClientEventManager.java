package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.base.zap;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public final class GmsClientEventManager implements Callback {

    /* renamed from: a */
    private final GmsClientEventState f20092a;

    /* renamed from: b */
    private final ArrayList<ConnectionCallbacks> f20093b = new ArrayList<>();
    @VisibleForTesting

    /* renamed from: c */
    private final ArrayList<ConnectionCallbacks> f20094c = new ArrayList<>();

    /* renamed from: d */
    private final ArrayList<OnConnectionFailedListener> f20095d = new ArrayList<>();

    /* renamed from: e */
    private volatile boolean f20096e = false;

    /* renamed from: f */
    private final AtomicInteger f20097f = new AtomicInteger(0);

    /* renamed from: g */
    private boolean f20098g = false;

    /* renamed from: h */
    private final Handler f20099h;

    /* renamed from: i */
    private final Object f20100i = new Object();

    @VisibleForTesting
    public interface GmsClientEventState {
        Bundle getConnectionHint();

        boolean isConnected();
    }

    public GmsClientEventManager(Looper looper, GmsClientEventState gmsClientEventState) {
        this.f20092a = gmsClientEventState;
        this.f20099h = new zap(looper, this);
    }

    /* renamed from: a */
    public final void mo27781a() {
        this.f20096e = false;
        this.f20097f.incrementAndGet();
    }

    /* renamed from: b */
    public final void mo27787b() {
        this.f20096e = true;
    }

    @VisibleForTesting
    /* renamed from: a */
    public final void mo27783a(Bundle bundle) {
        Preconditions.m21861a(this.f20099h, "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.f20100i) {
            boolean z = true;
            Preconditions.m21867b(!this.f20098g);
            this.f20099h.removeMessages(1);
            this.f20098g = true;
            if (this.f20094c.size() != 0) {
                z = false;
            }
            Preconditions.m21867b(z);
            ArrayList arrayList = new ArrayList(this.f20093b);
            int i = this.f20097f.get();
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) obj;
                if (!this.f20096e || !this.f20092a.isConnected() || this.f20097f.get() != i) {
                    break;
                } else if (!this.f20094c.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(bundle);
                }
            }
            this.f20094c.clear();
            this.f20098g = false;
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    public final void mo27782a(int i) {
        Preconditions.m21861a(this.f20099h, "onUnintentionalDisconnection must only be called on the Handler thread");
        this.f20099h.removeMessages(1);
        synchronized (this.f20100i) {
            this.f20098g = true;
            ArrayList arrayList = new ArrayList(this.f20093b);
            int i2 = this.f20097f.get();
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) obj;
                if (!this.f20096e || this.f20097f.get() != i2) {
                    break;
                } else if (this.f20093b.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnectionSuspended(i);
                }
            }
            this.f20094c.clear();
            this.f20098g = false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0046, code lost:
        return;
     */
    @com.google.android.gms.common.util.VisibleForTesting
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo27784a(com.google.android.gms.common.ConnectionResult r8) {
        /*
            r7 = this;
            android.os.Handler r0 = r7.f20099h
            java.lang.String r1 = "onConnectionFailure must only be called on the Handler thread"
            com.google.android.gms.common.internal.Preconditions.m21861a(r0, r1)
            android.os.Handler r0 = r7.f20099h
            r1 = 1
            r0.removeMessages(r1)
            java.lang.Object r0 = r7.f20100i
            monitor-enter(r0)
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0049 }
            java.util.ArrayList<com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener> r2 = r7.f20095d     // Catch:{ all -> 0x0049 }
            r1.<init>(r2)     // Catch:{ all -> 0x0049 }
            java.util.concurrent.atomic.AtomicInteger r2 = r7.f20097f     // Catch:{ all -> 0x0049 }
            int r2 = r2.get()     // Catch:{ all -> 0x0049 }
            int r3 = r1.size()     // Catch:{ all -> 0x0049 }
            r4 = 0
        L_0x0022:
            if (r4 >= r3) goto L_0x0047
            java.lang.Object r5 = r1.get(r4)     // Catch:{ all -> 0x0049 }
            int r4 = r4 + 1
            com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener r5 = (com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener) r5     // Catch:{ all -> 0x0049 }
            boolean r6 = r7.f20096e     // Catch:{ all -> 0x0049 }
            if (r6 == 0) goto L_0x0045
            java.util.concurrent.atomic.AtomicInteger r6 = r7.f20097f     // Catch:{ all -> 0x0049 }
            int r6 = r6.get()     // Catch:{ all -> 0x0049 }
            if (r6 == r2) goto L_0x0039
            goto L_0x0045
        L_0x0039:
            java.util.ArrayList<com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener> r6 = r7.f20095d     // Catch:{ all -> 0x0049 }
            boolean r6 = r6.contains(r5)     // Catch:{ all -> 0x0049 }
            if (r6 == 0) goto L_0x0044
            r5.onConnectionFailed(r8)     // Catch:{ all -> 0x0049 }
        L_0x0044:
            goto L_0x0022
        L_0x0045:
            monitor-exit(r0)     // Catch:{ all -> 0x0049 }
            return
        L_0x0047:
            monitor-exit(r0)     // Catch:{ all -> 0x0049 }
            return
        L_0x0049:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0049 }
            goto L_0x004d
        L_0x004c:
            throw r8
        L_0x004d:
            goto L_0x004c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.GmsClientEventManager.mo27784a(com.google.android.gms.common.ConnectionResult):void");
    }

    /* renamed from: a */
    public final void mo27785a(ConnectionCallbacks connectionCallbacks) {
        Preconditions.m21857a(connectionCallbacks);
        synchronized (this.f20100i) {
            if (this.f20093b.contains(connectionCallbacks)) {
                String valueOf = String.valueOf(connectionCallbacks);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 62);
                sb.append("registerConnectionCallbacks(): listener ");
                sb.append(valueOf);
                sb.append(" is already registered");
                Log.w("GmsClientEvents", sb.toString());
            } else {
                this.f20093b.add(connectionCallbacks);
            }
        }
        if (this.f20092a.isConnected()) {
            Handler handler = this.f20099h;
            handler.sendMessage(handler.obtainMessage(1, connectionCallbacks));
        }
    }

    /* renamed from: a */
    public final void mo27786a(OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.m21857a(onConnectionFailedListener);
        synchronized (this.f20100i) {
            if (this.f20095d.contains(onConnectionFailedListener)) {
                String valueOf = String.valueOf(onConnectionFailedListener);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 67);
                sb.append("registerConnectionFailedListener(): listener ");
                sb.append(valueOf);
                sb.append(" is already registered");
                Log.w("GmsClientEvents", sb.toString());
            } else {
                this.f20095d.add(onConnectionFailedListener);
            }
        }
    }

    /* renamed from: b */
    public final void mo27788b(OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.m21857a(onConnectionFailedListener);
        synchronized (this.f20100i) {
            if (!this.f20095d.remove(onConnectionFailedListener)) {
                String valueOf = String.valueOf(onConnectionFailedListener);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 57);
                sb.append("unregisterConnectionFailedListener(): listener ");
                sb.append(valueOf);
                sb.append(" not found");
                Log.w("GmsClientEvents", sb.toString());
            }
        }
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) message.obj;
            synchronized (this.f20100i) {
                if (this.f20096e && this.f20092a.isConnected() && this.f20093b.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(this.f20092a.getConnectionHint());
                }
            }
            return true;
        }
        StringBuilder sb = new StringBuilder(45);
        sb.append("Don't know how to handle message: ");
        sb.append(i);
        Log.wtf("GmsClientEvents", sb.toString(), new Exception());
        return false;
    }
}
