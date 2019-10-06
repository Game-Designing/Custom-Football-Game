package com.smaato.soma;

import android.os.Build.VERSION;
import android.security.NetworkSecurityPolicy;

/* renamed from: com.smaato.soma.h */
/* compiled from: AdSettings */
public class C12394h implements C12399i {

    /* renamed from: a */
    private C12431j f38719a = C12431j.DISPLAY;

    /* renamed from: b */
    private C12150c f38720b = C12150c.f38088c;

    /* renamed from: c */
    private int f38721c = 0;

    /* renamed from: d */
    private int f38722d = 0;

    /* renamed from: e */
    private long f38723e = 0;

    /* renamed from: f */
    private long f38724f = 0;

    /* renamed from: g */
    private boolean f38725g = false;

    /* renamed from: h */
    private boolean f38726h = true;

    /* renamed from: i */
    private String f38727i;

    /* renamed from: h */
    public boolean mo39892h() {
        if (VERSION.SDK_INT >= 23 && !this.f38725g) {
            this.f38725g = !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
        }
        return this.f38725g;
    }

    /* renamed from: g */
    public final long mo39891g() {
        return this.f38723e;
    }

    /* renamed from: b */
    public final void mo39886b(long publisherId) {
        this.f38723e = publisherId;
    }

    /* renamed from: c */
    public final long mo39887c() {
        return this.f38724f;
    }

    /* renamed from: a */
    public final void mo39881a(long adspaceId) {
        this.f38724f = adspaceId;
    }

    /* renamed from: b */
    public final C12431j mo39885b() {
        return this.f38719a;
    }

    /* renamed from: a */
    public final void mo39883a(C12431j adType) {
        if (adType != null) {
            this.f38719a = adType;
            return;
        }
        throw new IllegalArgumentException("adType must not be null");
    }

    /* renamed from: a */
    public final C12150c mo39880a() {
        return this.f38720b;
    }

    /* renamed from: a */
    public final void mo39882a(C12150c adDimension) {
        this.f38720b = adDimension;
    }

    /* renamed from: e */
    public int mo39889e() {
        return this.f38721c;
    }

    /* renamed from: d */
    public int mo39888d() {
        return this.f38722d;
    }

    /* renamed from: a */
    public void mo39884a(String nativeSupport) {
        this.f38727i = nativeSupport;
    }

    /* renamed from: f */
    public String mo39890f() {
        return this.f38727i;
    }
}
