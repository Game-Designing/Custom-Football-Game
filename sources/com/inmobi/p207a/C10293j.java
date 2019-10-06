package com.inmobi.p207a;

import com.inmobi.commons.core.network.C10676c;
import com.inmobi.commons.core.utilities.uid.C10711d;

/* renamed from: com.inmobi.a.j */
/* compiled from: IceNetworkRequest */
public class C10293j extends C10676c {

    /* renamed from: c */
    private static final String f31182c = C10293j.class.getSimpleName();

    /* renamed from: a */
    int f31183a;

    /* renamed from: b */
    int f31184b;

    C10293j(String str, int i, int i2, C10711d dVar, C10294k kVar) {
        super("POST", str, true, dVar);
        this.f31183a = i;
        this.f31184b = i2;
        this.f32577o.put("payload", kVar.mo33653a().toString());
    }
}
