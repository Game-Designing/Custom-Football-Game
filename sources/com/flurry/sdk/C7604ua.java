package com.flurry.sdk;

import com.flurry.sdk.C7554lc.C7555a;

/* renamed from: com.flurry.sdk.ua */
class C7604ua implements C7555a<byte[], Void> {

    /* renamed from: a */
    final /* synthetic */ String f15102a;

    /* renamed from: b */
    final /* synthetic */ String f15103b;

    /* renamed from: c */
    final /* synthetic */ C7616wa f15104c;

    C7604ua(C7616wa waVar, String str, String str2) {
        this.f15104c = waVar;
        this.f15102a = str;
        this.f15103b = str2;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo23837a(C7554lc lcVar, Object obj) {
        int i = lcVar.f15017x;
        if (i > 0) {
            C7513ec.m16651d(C7616wa.f15120f, "Analytics report sent.");
            String d = C7616wa.f15120f;
            StringBuilder sb = new StringBuilder("FlurryDataSender: report ");
            sb.append(this.f15102a);
            sb.append(" sent. HTTP response: ");
            sb.append(i);
            C7513ec.m16639a(3, d, sb.toString());
            if (C7513ec.m16647c() <= 3 && C7513ec.m16652d()) {
                C7379Fb.m16300a().mo23815a((Runnable) new C7599ta(this, i));
            }
            this.f15104c.mo23828a(this.f15102a, this.f15103b, i);
            this.f15104c.mo23832c();
            return;
        }
        C7379Fb.m16300a().mo23817b(new C7385Gc(this.f15104c, this.f15102a));
    }
}
