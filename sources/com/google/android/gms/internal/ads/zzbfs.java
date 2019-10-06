package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzard
public final class zzbfs implements Iterable<zzbfq> {

    /* renamed from: a */
    private final List<zzbfq> f25276a = new ArrayList();

    /* renamed from: a */
    public static boolean m26706a(zzbdf zzbdf) {
        zzbfq b = m26707b(zzbdf);
        if (b == null) {
            return false;
        }
        b.f25273e.mo30549b();
        return true;
    }

    /* renamed from: b */
    static zzbfq m26707b(zzbdf zzbdf) {
        Iterator it = zzk.zzmc().iterator();
        while (it.hasNext()) {
            zzbfq zzbfq = (zzbfq) it.next();
            if (zzbfq.f25272d == zzbdf) {
                return zzbfq;
            }
        }
        return null;
    }

    /* renamed from: a */
    public final void mo30536a(zzbfq zzbfq) {
        this.f25276a.add(zzbfq);
    }

    /* renamed from: b */
    public final void mo30537b(zzbfq zzbfq) {
        this.f25276a.remove(zzbfq);
    }

    public final Iterator<zzbfq> iterator() {
        return this.f25276a.iterator();
    }
}
