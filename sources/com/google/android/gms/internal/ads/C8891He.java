package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@zzard
/* renamed from: com.google.android.gms.internal.ads.He */
final class C8891He {

    /* renamed from: a */
    private final ArrayList<zzsa> f21129a = new ArrayList<>();

    /* renamed from: b */
    private long f21130b;

    C8891He() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final long mo28310a() {
        Iterator it = this.f21129a.iterator();
        while (it.hasNext()) {
            Map a = ((zzsa) it.next()).mo32180a();
            if (a != null) {
                for (Entry entry : a.entrySet()) {
                    try {
                        if ("content-length".equalsIgnoreCase((String) entry.getKey())) {
                            this.f21130b = Math.max(this.f21130b, Long.parseLong((String) ((List) entry.getValue()).get(0)));
                        }
                    } catch (RuntimeException e) {
                    }
                }
                it.remove();
            }
        }
        return this.f21130b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo28311a(zzsa zzsa) {
        this.f21129a.add(zzsa);
    }
}
