package com.ironsource.sdk.data;

import java.util.Map;
import p019d.p273h.p285d.p292f.C12981a;

/* renamed from: com.ironsource.sdk.data.c */
/* compiled from: DemandSource */
public class C10890c {

    /* renamed from: a */
    private String f33244a;

    /* renamed from: b */
    private String f33245b;

    /* renamed from: c */
    private int f33246c = -1;

    /* renamed from: d */
    private Map<String, String> f33247d;

    /* renamed from: e */
    private int f33248e;

    /* renamed from: f */
    private boolean f33249f;

    /* renamed from: g */
    private C12981a f33250g;

    public C10890c(String id, String demandSourceName, Map<String, String> extraParams, C12981a listener) {
        this.f33245b = id;
        this.f33244a = demandSourceName;
        this.f33247d = extraParams;
        this.f33250g = listener;
        this.f33248e = 0;
        this.f33249f = false;
    }

    /* renamed from: e */
    public String mo35655e() {
        return this.f33245b;
    }

    /* renamed from: c */
    public String mo35652c() {
        return this.f33244a;
    }

    /* renamed from: b */
    public int mo35650b() {
        return this.f33248e;
    }

    /* renamed from: a */
    public boolean mo35648a() {
        return this.f33249f;
    }

    /* renamed from: a */
    public void mo35647a(boolean isAvailable) {
        this.f33249f = isAvailable;
    }

    /* renamed from: d */
    public Map<String, String> mo35654d() {
        return this.f33247d;
    }

    /* renamed from: b */
    public synchronized void mo35651b(int initState) {
        this.f33248e = initState;
    }

    /* renamed from: f */
    public C12981a mo35656f() {
        return this.f33250g;
    }

    /* renamed from: g */
    public int mo35657g() {
        return this.f33246c;
    }

    /* renamed from: c */
    public void mo35653c(int state) {
        this.f33246c = state;
    }

    /* renamed from: a */
    public boolean mo35649a(int state) {
        return this.f33246c == state;
    }

    /* renamed from: h */
    public boolean mo35658h() {
        Map<String, String> map = this.f33247d;
        if (map != null) {
            String str = "rewarded";
            if (map.containsKey(str)) {
                return Boolean.parseBoolean((String) this.f33247d.get(str));
            }
        }
        return false;
    }
}
