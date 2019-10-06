package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdha.zzb;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class zzdca<P> {

    /* renamed from: a */
    private static final Charset f27773a = Charset.forName("UTF-8");

    /* renamed from: b */
    private ConcurrentMap<String, List<zzdcb<P>>> f27774b = new ConcurrentHashMap();

    /* renamed from: c */
    private zzdcb<P> f27775c;

    /* renamed from: d */
    private final Class<P> f27776d;

    /* renamed from: b */
    public final zzdcb<P> mo31385b() {
        return this.f27775c;
    }

    private zzdca(Class<P> cls) {
        this.f27776d = cls;
    }

    /* renamed from: a */
    public static <P> zzdca<P> m29169a(Class<P> cls) {
        return new zzdca<>(cls);
    }

    /* renamed from: a */
    public final void mo31384a(zzdcb<P> zzdcb) {
        this.f27775c = zzdcb;
    }

    /* renamed from: a */
    public final zzdcb<P> mo31382a(P p, zzb zzb) throws GeneralSecurityException {
        byte[] bArr;
        int i = C9088Qm.f21621a[zzb.mo31490l().ordinal()];
        if (i == 1 || i == 2) {
            bArr = ByteBuffer.allocate(5).put(0).putInt(zzb.mo31494p()).array();
        } else if (i == 3) {
            bArr = ByteBuffer.allocate(5).put(1).putInt(zzb.mo31494p()).array();
        } else if (i == 4) {
            bArr = zzdbm.f27765a;
        } else {
            throw new GeneralSecurityException("unknown output prefix type");
        }
        zzdcb<P> zzdcb = new zzdcb<>(p, bArr, zzb.mo31493o(), zzb.mo31490l());
        ArrayList arrayList = new ArrayList();
        arrayList.add(zzdcb);
        String str = new String(zzdcb.mo31388c(), f27773a);
        List list = (List) this.f27774b.put(str, Collections.unmodifiableList(arrayList));
        if (list != null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(list);
            arrayList2.add(zzdcb);
            this.f27774b.put(str, Collections.unmodifiableList(arrayList2));
        }
        return zzdcb;
    }

    /* renamed from: a */
    public final Class<P> mo31383a() {
        return this.f27776d;
    }
}
