package com.facebook.internal;

import com.facebook.C6817z;
import com.facebook.GraphRequest.C6545b;
import com.facebook.internal.C6694S.C6695a;

/* renamed from: com.facebook.internal.P */
/* compiled from: Utility */
class C6692P implements C6545b {

    /* renamed from: a */
    final /* synthetic */ C6695a f12220a;

    /* renamed from: b */
    final /* synthetic */ String f12221b;

    C6692P(C6695a aVar, String str) {
        this.f12220a = aVar;
        this.f12221b = str;
    }

    /* renamed from: a */
    public void mo9460a(C6817z response) {
        if (response.mo20227a() != null) {
            this.f12220a.mo19649a(response.mo20227a().mo19665e());
            return;
        }
        C6689M.m13386a(this.f12221b, response.mo20228b());
        this.f12220a.mo19650a(response.mo20228b());
    }
}
