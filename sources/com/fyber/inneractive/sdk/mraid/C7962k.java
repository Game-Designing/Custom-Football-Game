package com.fyber.inneractive.sdk.mraid;

import com.fyber.inneractive.sdk.mraid.C7954e.C7956a;
import com.fyber.inneractive.sdk.p179l.C7930d;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Map;

/* renamed from: com.fyber.inneractive.sdk.mraid.k */
public final class C7962k extends C7950a {
    C7962k(Map<String, String> map, C7930d dVar) {
        super(map, dVar);
    }

    /* renamed from: a */
    public final void mo24813a() {
        String b = mo24814b("url");
        StringBuilder sb = new StringBuilder("IAmraidActionOpen: opening Internal Browser For Url: ");
        sb.append(b);
        IAlog.m18019a(sb.toString());
        C7930d dVar = this.f16231c;
        if (dVar != null && !dVar.mo24653b(b)) {
            C7930d dVar2 = this.f16231c;
            C7956a aVar = C7956a.OPEN;
            StringBuilder sb2 = new StringBuilder("Invalid URL ");
            sb2.append(b);
            dVar2.mo24770a(aVar, sb2.toString());
        }
    }

    /* renamed from: b */
    public final boolean mo24815b() {
        return true;
    }
}
