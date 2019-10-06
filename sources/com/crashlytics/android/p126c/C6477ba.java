package com.crashlytics.android.p126c;

import java.io.File;
import java.io.IOException;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.C13929o;
import p024io.fabric.sdk.android.p348a.p352d.C13882a;

/* renamed from: com.crashlytics.android.c.ba */
/* compiled from: CrashlyticsFileMarker */
class C6477ba {

    /* renamed from: a */
    private final String f11637a;

    /* renamed from: b */
    private final C13882a f11638b;

    public C6477ba(String markerName, C13882a fileStore) {
        this.f11637a = markerName;
        this.f11638b = fileStore;
    }

    /* renamed from: a */
    public boolean mo19528a() {
        try {
            return m12643d().createNewFile();
        } catch (IOException e) {
            C13929o e2 = C13920f.m44245e();
            StringBuilder sb = new StringBuilder();
            sb.append("Error creating marker: ");
            sb.append(this.f11637a);
            e2.mo43325b("CrashlyticsCore", sb.toString(), e);
            return false;
        }
    }

    /* renamed from: b */
    public boolean mo19529b() {
        return m12643d().exists();
    }

    /* renamed from: c */
    public boolean mo19530c() {
        return m12643d().delete();
    }

    /* renamed from: d */
    private File m12643d() {
        return new File(this.f11638b.mo43292a(), this.f11637a);
    }
}
