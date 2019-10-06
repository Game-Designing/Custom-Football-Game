package com.paypal.android.sdk;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.paypal.android.sdk.Ha */
public class C11731Ha implements C12027ya {

    /* renamed from: a */
    final C11740Ka f36684a;

    public C11731Ha(C11740Ka ka) {
        this.f36684a = ka;
    }

    /* renamed from: d */
    public static List m38848d() {
        ArrayList arrayList = new ArrayList();
        for (C11740Ka ha : C11740Ka.values()) {
            arrayList.add(new C11731Ha(ha));
        }
        return arrayList;
    }

    /* renamed from: a */
    public String mo38569a() {
        return this.f36684a.name();
    }

    /* renamed from: b */
    public C11819fa mo38570b() {
        return this.f36684a.mo38581a();
    }

    /* renamed from: c */
    public String mo38571c() {
        return this.f36684a.mo38582b();
    }
}
