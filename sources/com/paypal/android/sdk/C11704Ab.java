package com.paypal.android.sdk;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.paypal.android.sdk.Ab */
public final class C11704Ab extends C11735Ib {

    /* renamed from: q */
    public final String f36574q;

    /* renamed from: r */
    private List f36575r;

    /* renamed from: s */
    private final String f36576s;

    public C11704Ab(C11707Ba ba, C11706B b, String str, String str2, String str3, String str4, List list) {
        super(C11740Ka.ConsentRequest, ba, b, C11735Ib.m38862b(str, str2));
        this.f36574q = str3;
        this.f36576s = str4;
        this.f36575r = list;
    }

    /* renamed from: b */
    public final String mo38503b() {
        HashMap hashMap = new HashMap();
        hashMap.put("code", this.f36574q);
        hashMap.put("nonce", this.f36576s);
        hashMap.put("scope", TextUtils.join(" ", this.f36575r));
        return C11723Fa.m38813a((Map) hashMap);
    }

    /* renamed from: c */
    public final void mo38505c() {
    }

    /* renamed from: d */
    public final void mo38507d() {
        mo38574b(mo38515m());
    }

    /* renamed from: e */
    public final String mo38508e() {
        return "{\"code\":\"EOTHbvqh0vwM2ldM2QIXbjVw0hZNuZEJLqdWmfTBLLSvGfqgyy9GKvjGybIxyGMd7gHXCXVtymqFQHS-J-4-Ir6u2LUVVdyLKonwTtdFw9qhBaMb4NZuZHKS0bGxdZlRAB3_Fk8HX2r3z8j03xScx4M\",\"scope\":\"https://uri.paypal.com/services/payments/futurepayments\"}";
    }
}
