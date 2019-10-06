package com.google.android.gms.internal.ads;

import android.content.Context;

@zzard
public final class zzalk {

    /* renamed from: a */
    private final Object f24406a = new Object();

    /* renamed from: b */
    private final Object f24407b = new Object();

    /* renamed from: c */
    private zzalr f24408c;

    /* renamed from: d */
    private zzalr f24409d;

    /* renamed from: a */
    public final zzalr mo29806a(Context context, zzbai zzbai) {
        zzalr zzalr;
        synchronized (this.f24407b) {
            if (this.f24409d == null) {
                this.f24409d = new zzalr(m25197a(context), zzbai, (String) zzyt.m31536e().mo29599a(zzacu.f24064b));
            }
            zzalr = this.f24409d;
        }
        return zzalr;
    }

    /* renamed from: b */
    public final zzalr mo29807b(Context context, zzbai zzbai) {
        zzalr zzalr;
        synchronized (this.f24406a) {
            if (this.f24408c == null) {
                this.f24408c = new zzalr(m25197a(context), zzbai, (String) zzyt.m31536e().mo29599a(zzacu.f24070c));
            }
            zzalr = this.f24408c;
        }
        return zzalr;
    }

    /* renamed from: a */
    private static Context m25197a(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }
}
