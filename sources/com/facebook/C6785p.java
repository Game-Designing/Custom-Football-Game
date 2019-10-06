package com.facebook;

import android.content.Context;
import com.facebook.C6787r.C6788a;
import com.facebook.p127a.C6638q;
import java.util.concurrent.Callable;

/* renamed from: com.facebook.p */
/* compiled from: FacebookSdk */
class C6785p implements Callable<Void> {

    /* renamed from: a */
    final /* synthetic */ C6788a f12465a;

    /* renamed from: b */
    final /* synthetic */ Context f12466b;

    C6785p(C6788a aVar, Context context) {
        this.f12465a = aVar;
        this.f12466b = context;
    }

    public Void call() throws Exception {
        C6663g.m13290d().mo19872e();
        C6543G.m12869b().mo19674c();
        if (AccessToken.m12821m() && Profile.m12985c() == null) {
            Profile.m12984b();
        }
        C6788a aVar = this.f12465a;
        if (aVar != null) {
            aVar.mo20141a();
        }
        C6638q.m13216a(C6787r.f12481m, C6787r.f12472d);
        C6638q.m13220b(this.f12466b.getApplicationContext()).mo19834a();
        return null;
    }
}
