package com.fyber.inneractive.sdk.mraid;

import com.fyber.inneractive.sdk.p179l.C7930d;
import java.util.Map;

/* renamed from: com.fyber.inneractive.sdk.mraid.a */
public abstract class C7950a {

    /* renamed from: a */
    public String f16229a;

    /* renamed from: b */
    protected Map<String, String> f16230b;

    /* renamed from: c */
    protected C7930d f16231c;

    /* renamed from: a */
    public abstract void mo24813a();

    C7950a(Map<String, String> map, C7930d dVar) {
        this.f16230b = map;
        this.f16231c = dVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final int mo24812a(String str) {
        String str2 = (String) this.f16230b.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Integer.parseInt(str2, 10);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /* renamed from: b */
    public final String mo24814b(String str) {
        return (String) this.f16230b.get(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final boolean mo24816c(String str) {
        return "true".equals(this.f16230b.get(str));
    }

    /* renamed from: b */
    public boolean mo24815b() {
        return false;
    }
}
