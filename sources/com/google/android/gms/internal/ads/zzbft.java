package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.Map;

@zzard
public abstract class zzbft implements Releasable {

    /* renamed from: a */
    protected Context f25277a;

    /* renamed from: b */
    protected String f25278b;

    /* renamed from: c */
    protected WeakReference<zzbdf> f25279c;

    public zzbft(zzbdf zzbdf) {
        this.f25277a = zzbdf.getContext();
        this.f25278b = zzk.zzlg().mo30237b(this.f25277a, zzbdf.mo28793z().f25057a);
        this.f25279c = new WeakReference<>(zzbdf);
    }

    /* renamed from: a */
    public abstract boolean mo30546a(String str);

    /* renamed from: b */
    public abstract void mo30549b();

    /* renamed from: a */
    public boolean mo30547a(String str, String[] strArr) {
        return mo30546a(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo30551c(int i) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo30550b(int i) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo30552d(int i) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo30553e(int i) {
    }

    /* renamed from: a */
    public void mo27353a() {
    }

    @VisibleForTesting
    /* renamed from: a */
    public final void mo30541a(String str, String str2, int i, int i2, boolean z, int i3, int i4) {
        Handler handler = zzazt.f25042a;
        C9811xe xeVar = new C9811xe(this, str, str2, i, 0, z, i3, i4);
        handler.post(xeVar);
    }

    @VisibleForTesting
    /* renamed from: a */
    public final void mo30543a(String str, String str2, long j, long j2, boolean z) {
        Handler handler = zzazt.f25042a;
        C9832ye yeVar = new C9832ye(this, str, str2, j, j2, z);
        handler.post(yeVar);
    }

    @VisibleForTesting
    /* renamed from: a */
    public final void mo30544a(String str, String str2, long j, long j2, boolean z, int i, int i2) {
        Handler handler = zzazt.f25042a;
        C9853ze zeVar = new C9853ze(this, str, str2, j, j2, z, i, i2);
        handler.post(zeVar);
    }

    @VisibleForTesting
    /* renamed from: a */
    public final void mo30540a(String str, String str2, int i, int i2, long j, long j2, boolean z, int i3, int i4) {
        Handler handler = zzazt.f25042a;
        C8744Ae ae = new C8744Ae(this, str, str2, i, i2, j, j2, z, i3, i4);
        handler.post(ae);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo30539a(String str, String str2, int i) {
        zzazt.f25042a.post(new C8765Be(this, str, str2, i));
    }

    @VisibleForTesting
    /* renamed from: a */
    public final void mo30542a(String str, String str2, long j) {
        Handler handler = zzazt.f25042a;
        C8786Ce ce = new C8786Ce(this, str, str2, j);
        handler.post(ce);
    }

    @VisibleForTesting
    /* renamed from: a */
    public final void mo30545a(String str, String str2, String str3, String str4) {
        Handler handler = zzazt.f25042a;
        C8807De de = new C8807De(this, str, str2, str3, str4);
        handler.post(de);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo30548b(String str) {
        zzyt.m31532a();
        return zzazt.m26305a(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String mo30562c(java.lang.String r1) {
        /*
            int r0 = r1.hashCode()
            switch(r0) {
                case -1947652542: goto L_0x007e;
                case -1396664534: goto L_0x0073;
                case -1347010958: goto L_0x0069;
                case -918817863: goto L_0x005e;
                case -659376217: goto L_0x0054;
                case -642208130: goto L_0x004a;
                case -354048396: goto L_0x003f;
                case -32082395: goto L_0x0034;
                case 3387234: goto L_0x002a;
                case 96784904: goto L_0x0020;
                case 580119100: goto L_0x0015;
                case 725497484: goto L_0x000a;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0088
        L_0x000a:
            java.lang.String r0 = "noCacheDir"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0008
            r1 = 7
            goto L_0x0089
        L_0x0015:
            java.lang.String r0 = "expireFailed"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0008
            r1 = 6
            goto L_0x0089
        L_0x0020:
            java.lang.String r0 = "error"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0008
            r1 = 1
            goto L_0x0089
        L_0x002a:
            java.lang.String r0 = "noop"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0008
            r1 = 4
            goto L_0x0089
        L_0x0034:
            java.lang.String r0 = "externalAbort"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0008
            r1 = 10
            goto L_0x0089
        L_0x003f:
            java.lang.String r0 = "sizeExceeded"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0008
            r1 = 11
            goto L_0x0089
        L_0x004a:
            java.lang.String r0 = "playerFailed"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0008
            r1 = 5
            goto L_0x0089
        L_0x0054:
            java.lang.String r0 = "contentLengthMissing"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x0089
        L_0x005e:
            java.lang.String r0 = "downloadTimeout"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0008
            r1 = 9
            goto L_0x0089
        L_0x0069:
            java.lang.String r0 = "inProgress"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0008
            r1 = 2
            goto L_0x0089
        L_0x0073:
            java.lang.String r0 = "badUrl"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0008
            r1 = 8
            goto L_0x0089
        L_0x007e:
            java.lang.String r0 = "interrupted"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0008
            r1 = 3
            goto L_0x0089
        L_0x0088:
            r1 = -1
        L_0x0089:
            java.lang.String r0 = "internal"
            switch(r1) {
                case 0: goto L_0x009a;
                case 1: goto L_0x009a;
                case 2: goto L_0x009a;
                case 3: goto L_0x009a;
                case 4: goto L_0x009a;
                case 5: goto L_0x009a;
                case 6: goto L_0x0096;
                case 7: goto L_0x0096;
                case 8: goto L_0x0092;
                case 9: goto L_0x0092;
                case 10: goto L_0x008f;
                case 11: goto L_0x008f;
                default: goto L_0x008e;
            }
        L_0x008e:
            goto L_0x009c
        L_0x008f:
            java.lang.String r0 = "policy"
            goto L_0x009c
        L_0x0092:
            java.lang.String r0 = "network"
            goto L_0x009c
        L_0x0096:
            java.lang.String r0 = "io"
            goto L_0x009c
        L_0x009a:
        L_0x009c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbft.mo30562c(java.lang.String):java.lang.String");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m26712a(String str, Map<String, String> map) {
        zzbdf zzbdf = (zzbdf) this.f25279c.get();
        if (zzbdf != null) {
            zzbdf.mo28729a(str, map);
        }
    }
}
