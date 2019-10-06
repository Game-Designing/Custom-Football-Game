package com.google.android.gms.internal.ads;

import org.json.JSONException;

public class zzbpc {

    /* renamed from: a */
    protected zzcxu f25746a;

    /* renamed from: b */
    protected zzcxm f25747b;

    /* renamed from: c */
    protected zzbry f25748c;

    /* renamed from: d */
    protected zzbso f25749d;

    /* renamed from: e */
    protected String f25750e;

    /* renamed from: d */
    public final zzbry mo30855d() {
        return this.f25748c;
    }

    /* renamed from: c */
    public void mo28633c() {
        this.f25749d.onAdLoaded();
    }

    /* renamed from: b */
    public final String mo30854b() {
        return this.f25750e;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x001a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String mo30856e() {
        /*
            r2 = this;
            java.lang.String r0 = r2.f25750e
            java.lang.String r1 = "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0017
            java.lang.String r0 = r2.f25750e
            java.lang.String r1 = "com.google.ads.mediation.customevent.CustomEventAdapter"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r0 = 0
            goto L_0x0018
        L_0x0017:
            r0 = 1
        L_0x0018:
            if (r0 == 0) goto L_0x0021
            com.google.android.gms.internal.ads.zzcxm r0 = r2.f25747b
            java.lang.String r0 = m27637a(r0)
            goto L_0x0022
        L_0x0021:
            r0 = 0
        L_0x0022:
            if (r0 != 0) goto L_0x0026
            java.lang.String r0 = r2.f25750e
        L_0x0026:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbpc.mo30856e():java.lang.String");
    }

    /* renamed from: a */
    public void mo30853a() {
        this.f25748c.mo30881d(null);
    }

    /* renamed from: a */
    private static String m27637a(zzcxm zzcxm) {
        try {
            return zzcxm.f27568s.getString("class_name");
        } catch (JSONException e) {
            return null;
        }
    }
}
