package com.smaato.soma.p239c.p244e;

import com.smaato.soma.p239c.p252i.C12280f;

/* renamed from: com.smaato.soma.c.e.b */
/* compiled from: EventTracker */
public class C12210b {

    /* renamed from: a */
    private int f38270a;

    /* renamed from: b */
    private int f38271b;

    /* renamed from: c */
    private String f38272c;

    public C12210b(int eventType, int trackingMethod, String url) {
        this.f38270a = eventType;
        this.f38271b = trackingMethod;
        this.f38272c = url;
    }

    /* renamed from: a */
    public int mo39540a() {
        return this.f38270a;
    }

    /* renamed from: b */
    public String mo39541b() {
        return this.f38272c;
    }

    /* renamed from: c */
    public boolean mo39542c() {
        if (mo39540a() != 1 || C12280f.m40428a((CharSequence) mo39541b())) {
            return false;
        }
        return true;
    }
}
