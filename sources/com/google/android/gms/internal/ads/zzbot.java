package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;
import p002b.p003c.p053g.p061f.C1253b;

public final class zzbot implements zzbrw, zzbsr {

    /* renamed from: a */
    private final Context f25682a;

    /* renamed from: b */
    private final zzbgz f25683b;

    /* renamed from: c */
    private final zzcxm f25684c;

    /* renamed from: d */
    private final zzbai f25685d;

    /* renamed from: e */
    private IObjectWrapper f25686e;

    /* renamed from: f */
    private boolean f25687f;

    public zzbot(Context context, zzbgz zzbgz, zzcxm zzcxm, zzbai zzbai) {
        this.f25682a = context;
        this.f25683b = zzbgz;
        this.f25684c = zzcxm;
        this.f25685d = zzbai;
    }

    public final synchronized void onAdLoaded() {
        if (!this.f25687f) {
            m27333a();
        }
    }

    public final synchronized void onAdImpression() {
        if (!this.f25687f) {
            m27333a();
        }
        if (!(!this.f25684c.f27544J || this.f25686e == null || this.f25683b == null)) {
            this.f25683b.mo28729a("onSdkImpression", (Map<String, ?>) new C1253b<String,Object>());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008c, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void m27333a() {
        /*
            r10 = this;
            monitor-enter(r10)
            com.google.android.gms.internal.ads.zzcxm r0 = r10.f25684c     // Catch:{ all -> 0x008d }
            boolean r0 = r0.f27544J     // Catch:{ all -> 0x008d }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r10)
            return
        L_0x0009:
            com.google.android.gms.internal.ads.zzbgz r0 = r10.f25683b     // Catch:{ all -> 0x008d }
            if (r0 != 0) goto L_0x000f
            monitor-exit(r10)
            return
        L_0x000f:
            com.google.android.gms.internal.ads.zzaqd r0 = com.google.android.gms.ads.internal.zzk.zzlv()     // Catch:{ all -> 0x008d }
            android.content.Context r1 = r10.f25682a     // Catch:{ all -> 0x008d }
            boolean r0 = r0.mo30001b(r1)     // Catch:{ all -> 0x008d }
            if (r0 != 0) goto L_0x001d
            monitor-exit(r10)
            return
        L_0x001d:
            com.google.android.gms.internal.ads.zzbai r0 = r10.f25685d     // Catch:{ all -> 0x008d }
            int r0 = r0.f25058b     // Catch:{ all -> 0x008d }
            com.google.android.gms.internal.ads.zzbai r1 = r10.f25685d     // Catch:{ all -> 0x008d }
            int r1 = r1.f25059c     // Catch:{ all -> 0x008d }
            r2 = 23
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x008d }
            r3.<init>(r2)     // Catch:{ all -> 0x008d }
            r3.append(r0)     // Catch:{ all -> 0x008d }
            java.lang.String r0 = "."
            r3.append(r0)     // Catch:{ all -> 0x008d }
            r3.append(r1)     // Catch:{ all -> 0x008d }
            java.lang.String r5 = r3.toString()     // Catch:{ all -> 0x008d }
            com.google.android.gms.internal.ads.zzcxm r0 = r10.f25684c     // Catch:{ all -> 0x008d }
            org.json.JSONObject r0 = r0.f27546L     // Catch:{ all -> 0x008d }
            java.lang.String r1 = "media_type"
            r2 = -1
            int r0 = r0.optInt(r1, r2)     // Catch:{ all -> 0x008d }
            if (r0 != 0) goto L_0x004b
            r0 = 0
            r9 = r0
            goto L_0x004e
        L_0x004b:
            java.lang.String r0 = "javascript"
            r9 = r0
        L_0x004e:
            com.google.android.gms.internal.ads.zzaqd r4 = com.google.android.gms.ads.internal.zzk.zzlv()     // Catch:{ all -> 0x008d }
            com.google.android.gms.internal.ads.zzbgz r0 = r10.f25683b     // Catch:{ all -> 0x008d }
            android.webkit.WebView r6 = r0.getWebView()     // Catch:{ all -> 0x008d }
            java.lang.String r7 = ""
            java.lang.String r8 = "javascript"
            com.google.android.gms.dynamic.IObjectWrapper r0 = r4.mo29995a(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x008d }
            r10.f25686e = r0     // Catch:{ all -> 0x008d }
            com.google.android.gms.internal.ads.zzbgz r0 = r10.f25683b     // Catch:{ all -> 0x008d }
            android.view.View r0 = r0.getView()     // Catch:{ all -> 0x008d }
            com.google.android.gms.dynamic.IObjectWrapper r1 = r10.f25686e     // Catch:{ all -> 0x008d }
            if (r1 == 0) goto L_0x008b
            if (r0 == 0) goto L_0x008b
            com.google.android.gms.internal.ads.zzaqd r1 = com.google.android.gms.ads.internal.zzk.zzlv()     // Catch:{ all -> 0x008d }
            com.google.android.gms.dynamic.IObjectWrapper r2 = r10.f25686e     // Catch:{ all -> 0x008d }
            r1.mo29999a(r2, r0)     // Catch:{ all -> 0x008d }
            com.google.android.gms.internal.ads.zzbgz r0 = r10.f25683b     // Catch:{ all -> 0x008d }
            com.google.android.gms.dynamic.IObjectWrapper r1 = r10.f25686e     // Catch:{ all -> 0x008d }
            r0.mo28719a(r1)     // Catch:{ all -> 0x008d }
            com.google.android.gms.internal.ads.zzaqd r0 = com.google.android.gms.ads.internal.zzk.zzlv()     // Catch:{ all -> 0x008d }
            com.google.android.gms.dynamic.IObjectWrapper r1 = r10.f25686e     // Catch:{ all -> 0x008d }
            r0.mo29998a(r1)     // Catch:{ all -> 0x008d }
            r0 = 1
            r10.f25687f = r0     // Catch:{ all -> 0x008d }
        L_0x008b:
            monitor-exit(r10)
            return
        L_0x008d:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbot.m27333a():void");
    }
}
