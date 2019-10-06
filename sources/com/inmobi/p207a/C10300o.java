package com.inmobi.p207a;

import android.content.Context;
import android.location.Criteria;
import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationServices;
import com.inmobi.commons.core.configs.C10639a;
import com.inmobi.commons.core.configs.C10641b;
import com.inmobi.commons.core.configs.C10641b.C10644c;
import com.inmobi.commons.core.p222e.C10659b;
import com.inmobi.commons.core.utilities.C10702f;
import com.inmobi.commons.core.utilities.p225b.C10698h;
import com.inmobi.commons.core.utilities.uid.C10711d;
import com.inmobi.commons.p217a.C10619a;
import java.util.HashMap;

/* renamed from: com.inmobi.a.o */
/* compiled from: SignalsComponent */
public class C10300o implements C10644c {

    /* renamed from: b */
    private static final String f31214b = C10300o.class.getSimpleName();

    /* renamed from: c */
    private static final Object f31215c = new Object();

    /* renamed from: d */
    private static volatile C10300o f31216d;

    /* renamed from: a */
    public C10301p f31217a = new C10301p();

    /* renamed from: e */
    private C10289h f31218e;

    /* renamed from: f */
    private C10287g f31219f;

    /* renamed from: g */
    private boolean f31220g = false;

    /* renamed from: a */
    public static C10300o m33571a() {
        C10300o oVar = f31216d;
        if (oVar == null) {
            synchronized (f31215c) {
                oVar = f31216d;
                if (oVar == null) {
                    oVar = new C10300o();
                    f31216d = oVar;
                }
            }
        }
        return oVar;
    }

    private C10300o() {
        C10641b.m34915a().mo34452a((C10639a) this.f31217a, (C10644c) this);
        C10698h.m35136a().mo34521a(this.f31217a.f31222a.mo33677b());
        C10296m.m33551a();
        C10296m.m33553a(this.f31217a.f31222a.mo33676a());
        C10659b.m34983a().mo34486a("signals", this.f31217a.f31224c);
    }

    /* renamed from: a */
    public final void mo33666a(C10639a aVar) {
        this.f31217a = (C10301p) aVar;
        C10296m.m33551a();
        C10296m.m33553a(this.f31217a.f31222a.mo33676a());
        C10698h.m35136a().mo34521a(this.f31217a.f31222a.mo33677b());
        C10659b.m34983a().mo34486a("signals", this.f31217a.f31224c);
    }

    /* renamed from: b */
    public final synchronized void mo33667b() {
        if (!this.f31220g) {
            this.f31220g = true;
            m33572f();
            C10296m a = C10296m.m33551a();
            try {
                if (C10296m.f31195a && C10296m.m33556c() && a.mo33658g()) {
                    if (a.f31200b != null) {
                        Criteria criteria = new Criteria();
                        criteria.setBearingAccuracy(2);
                        criteria.setPowerRequirement(2);
                        criteria.setCostAllowed(false);
                        String bestProvider = a.f31200b.getBestProvider(criteria, true);
                        if (bestProvider != null) {
                            a.f31200b.requestSingleUpdate(bestProvider, a, a.f31201c.getLooper());
                        }
                    }
                    if (!C10296m.m33554b() && C10702f.m35151a("signals")) {
                        Context b = C10619a.m34839b();
                        try {
                            if (a.f31202d == null) {
                                a.f31202d = new Builder(b).mo27393a((ConnectionCallbacks) new ConnectionCallbacks() {
                                    public final void onConnected(Bundle bundle) {
                                        C10296m.f31196e;
                                        C10296m.f31199h = true;
                                    }

                                    public final void onConnectionSuspended(int i) {
                                        C10296m.f31199h = false;
                                        C10296m.f31196e;
                                    }
                                }).mo27394a((OnConnectionFailedListener) new OnConnectionFailedListener() {
                                    public final void onConnectionFailed(ConnectionResult connectionResult) {
                                        C10296m.f31199h = false;
                                    }
                                }).mo27391a(LocationServices.f30505c).mo27395a();
                                a.f31202d.mo27385c();
                                return;
                            }
                            a.f31202d.mo27385c();
                        } catch (Exception e) {
                            StringBuilder sb = new StringBuilder("Error in connecting to GooglePlayServices API : (");
                            sb.append(e.getMessage());
                            sb.append(")");
                        }
                    }
                }
            } catch (Exception e2) {
                new StringBuilder("SDK encountered unexpected error in initializing location collection; ").append(e2.getMessage());
            }
        }
    }

    /* renamed from: c */
    public final synchronized void mo33668c() {
        if (this.f31220g) {
            this.f31220g = false;
            C10299n a = C10299n.m33566a();
            if (m33571a().f31217a.f31222a.mo33677b()) {
                C10698h.m35136a().f32653c = System.currentTimeMillis();
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("sessionId", C10698h.m35136a().f32651a);
                    hashMap.put("totalNetworkTime", Long.valueOf(a.f31212e));
                    hashMap.put("sessionDuration", Long.valueOf(SystemClock.elapsedRealtime() - a.f31213f));
                    C10659b.m34983a();
                    C10659b.m34987a("signals", "SDKSessionEnded", hashMap);
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder("Error in submitting telemetry event : (");
                    sb.append(e.getMessage());
                    sb.append(")");
                }
            }
            if (this.f31218e != null) {
                C10289h hVar = this.f31218e;
                hVar.f31176a.f31178b = true;
                hVar.f31176a.sendEmptyMessageDelayed(2, (long) (m33571a().f31217a.f31222a.f31235c * 1000));
            }
            C10296m a2 = C10296m.m33551a();
            if (C10296m.f31195a && C10296m.m33556c()) {
                if (a2.f31200b != null) {
                    a2.f31200b.removeUpdates(a2);
                }
                if (a2.f31202d != null) {
                    a2.f31202d.mo27386d();
                }
            }
            a2.f31202d = null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public final C10711d mo33669d() {
        return new C10711d(this.f31217a.f32441p.f32442a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008e, code lost:
        return;
     */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m33572f() {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.f31220g     // Catch:{ all -> 0x008f }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r7)
            return
        L_0x0007:
            com.inmobi.a.p r0 = r7.f31217a     // Catch:{ all -> 0x008f }
            com.inmobi.a.p$b r0 = r0.f31222a     // Catch:{ all -> 0x008f }
            boolean r0 = r0.f31233a     // Catch:{ all -> 0x008f }
            if (r0 == 0) goto L_0x008d
            com.inmobi.a.n r0 = com.inmobi.p207a.C10299n.m33566a()     // Catch:{ all -> 0x008f }
            com.inmobi.a.o r1 = m33571a()     // Catch:{ all -> 0x008f }
            com.inmobi.a.p r1 = r1.f31217a     // Catch:{ all -> 0x008f }
            com.inmobi.a.p$b r1 = r1.f31222a     // Catch:{ all -> 0x008f }
            boolean r1 = r1.mo33677b()     // Catch:{ all -> 0x008f }
            if (r1 == 0) goto L_0x007d
            java.util.UUID r1 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x008f }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x008f }
            com.inmobi.commons.core.utilities.b.h r2 = com.inmobi.commons.core.utilities.p225b.C10698h.m35136a()     // Catch:{ all -> 0x008f }
            r2.f32651a = r1     // Catch:{ all -> 0x008f }
            com.inmobi.commons.core.utilities.b.h r2 = com.inmobi.commons.core.utilities.p225b.C10698h.m35136a()     // Catch:{ all -> 0x008f }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x008f }
            r2.f32652b = r3     // Catch:{ all -> 0x008f }
            com.inmobi.commons.core.utilities.b.h r2 = com.inmobi.commons.core.utilities.p225b.C10698h.m35136a()     // Catch:{ all -> 0x008f }
            r3 = 0
            r2.f32653c = r3     // Catch:{ all -> 0x008f }
            long r5 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x008f }
            r0.f31213f = r5     // Catch:{ all -> 0x008f }
            r0.f31208a = r3     // Catch:{ all -> 0x008f }
            r0.f31209b = r3     // Catch:{ all -> 0x008f }
            r0.f31210c = r3     // Catch:{ all -> 0x008f }
            r0.f31211d = r3     // Catch:{ all -> 0x008f }
            r0.f31212e = r3     // Catch:{ all -> 0x008f }
            r0.f31213f = r3     // Catch:{ all -> 0x008f }
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x008f }
            r0.<init>()     // Catch:{ all -> 0x008f }
            java.lang.String r2 = "sessionId"
            r0.put(r2, r1)     // Catch:{ all -> 0x008f }
            com.inmobi.commons.core.p222e.C10659b.m34983a()     // Catch:{ Exception -> 0x0069 }
            java.lang.String r1 = "signals"
            java.lang.String r2 = "SDKSessionStarted"
            com.inmobi.commons.core.p222e.C10659b.m34987a(r1, r2, r0)     // Catch:{ Exception -> 0x0069 }
            goto L_0x007d
        L_0x0069:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x008f }
            java.lang.String r2 = "Error in submitting telemetry event : ("
            r1.<init>(r2)     // Catch:{ all -> 0x008f }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x008f }
            r1.append(r0)     // Catch:{ all -> 0x008f }
            java.lang.String r0 = ")"
            r1.append(r0)     // Catch:{ all -> 0x008f }
        L_0x007d:
            com.inmobi.a.h r0 = r7.f31218e     // Catch:{ all -> 0x008f }
            if (r0 != 0) goto L_0x0088
            com.inmobi.a.h r0 = new com.inmobi.a.h     // Catch:{ all -> 0x008f }
            r0.<init>()     // Catch:{ all -> 0x008f }
            r7.f31218e = r0     // Catch:{ all -> 0x008f }
        L_0x0088:
            com.inmobi.a.h r0 = r7.f31218e     // Catch:{ all -> 0x008f }
            r0.mo33650a()     // Catch:{ all -> 0x008f }
        L_0x008d:
            monitor-exit(r7)
            return
        L_0x008f:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.p207a.C10300o.m33572f():void");
    }

    /* renamed from: e */
    public final void mo33670e() {
        if (this.f31220g && this.f31217a.f31223b.f31225a) {
            if (this.f31219f == null) {
                this.f31219f = new C10287g();
            }
            this.f31219f.mo33648a(this.f31217a.f31223b);
        }
    }
}
