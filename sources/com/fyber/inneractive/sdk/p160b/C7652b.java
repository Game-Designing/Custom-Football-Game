package com.fyber.inneractive.sdk.p160b;

import com.fyber.inneractive.sdk.p163d.C7716a;
import com.fyber.inneractive.sdk.p174i.C7903b;
import com.fyber.inneractive.sdk.p174i.C7904c;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.HashMap;

/* renamed from: com.fyber.inneractive.sdk.b.b */
public final class C7652b {

    /* renamed from: a */
    public HashMap<C7903b, C7654b> f15184a;

    /* renamed from: com.fyber.inneractive.sdk.b.b$a */
    private static class C7653a {

        /* renamed from: a */
        public static C7652b f15185a = new C7652b(0);
    }

    /* renamed from: com.fyber.inneractive.sdk.b.b$b */
    public interface C7654b {
        /* renamed from: a */
        C7904c mo24084a();

        /* renamed from: b */
        C7716a mo24085b();
    }

    /* synthetic */ C7652b(byte b) {
        this();
    }

    private C7652b() {
        this.f15184a = new HashMap<>();
    }

    /* renamed from: a */
    public final void mo24082a(C7903b bVar, C7654b bVar2) {
        if (this.f15184a.containsKey(bVar)) {
            StringBuilder sb = new StringBuilder("Handler already exists for ad type ");
            sb.append(bVar);
            sb.append("! : ");
            sb.append(this.f15184a.get(bVar));
            IAlog.m18023d(sb.toString());
            return;
        }
        this.f15184a.put(bVar, bVar2);
    }

    /* renamed from: a */
    public final boolean mo24083a(C7903b bVar) {
        if (this.f15184a.containsKey(bVar)) {
            return true;
        }
        return false;
    }
}
