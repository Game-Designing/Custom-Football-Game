package com.ironsource.sdk.data;

import android.content.Context;
import p019d.p273h.p274a.C12724b;
import p019d.p273h.p285d.p295h.C13004g;

/* renamed from: com.ironsource.sdk.data.k */
/* compiled from: SSASession */
public class C10898k {

    /* renamed from: a */
    public final String f33282a = "sessionStartTime";

    /* renamed from: b */
    public final String f33283b = "sessionEndTime";

    /* renamed from: c */
    public final String f33284c = "sessionType";

    /* renamed from: d */
    public final String f33285d = "connectivity";

    /* renamed from: e */
    private long f33286e;

    /* renamed from: f */
    private long f33287f;

    /* renamed from: g */
    private C10899a f33288g;

    /* renamed from: h */
    private String f33289h;

    /* renamed from: com.ironsource.sdk.data.k$a */
    /* compiled from: SSASession */
    public enum C10899a {
        launched,
        backFromBG
    }

    public C10898k(Context context, C10899a type) {
        mo35681b(C13004g.m42462f().longValue());
        mo35678a(type);
        mo35679a(C12724b.m41073a(context));
    }

    /* renamed from: a */
    public void mo35676a() {
        mo35677a(C13004g.m42462f().longValue());
    }

    /* renamed from: d */
    public long mo35683d() {
        return this.f33286e;
    }

    /* renamed from: b */
    public void mo35681b(long sessionStartTime) {
        this.f33286e = sessionStartTime;
    }

    /* renamed from: c */
    public long mo35682c() {
        return this.f33287f;
    }

    /* renamed from: a */
    public void mo35677a(long sessionEndTime) {
        this.f33287f = sessionEndTime;
    }

    /* renamed from: e */
    public C10899a mo35684e() {
        return this.f33288g;
    }

    /* renamed from: a */
    public void mo35678a(C10899a sessionType) {
        this.f33288g = sessionType;
    }

    /* renamed from: b */
    public String mo35680b() {
        return this.f33289h;
    }

    /* renamed from: a */
    public void mo35679a(String connectivity) {
        this.f33289h = connectivity;
    }
}
