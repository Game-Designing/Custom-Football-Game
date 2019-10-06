package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class zzcfk implements zzczz {

    /* renamed from: a */
    private final Map<zzczs, Long> f26528a = new HashMap();

    /* renamed from: b */
    private final zzcfi f26529b;

    /* renamed from: c */
    private final Clock f26530c;

    /* renamed from: d */
    private final Map<zzczs, C8769Bi> f26531d = new HashMap();

    public zzcfk(zzcfi zzcfi, Set<C8769Bi> set, Clock clock) {
        this.f26529b = zzcfi;
        for (C8769Bi bi : set) {
            this.f26531d.put(bi.f20514c, bi);
        }
        this.f26530c = clock;
    }

    /* renamed from: c */
    public final void mo31139c(zzczs zzczs, String str) {
    }

    /* renamed from: b */
    public final void mo31138b(zzczs zzczs, String str) {
        this.f26528a.put(zzczs, Long.valueOf(this.f26530c.mo27934a()));
    }

    /* renamed from: a */
    public final void mo31137a(zzczs zzczs, String str, Throwable th) {
        if (this.f26528a.containsKey(zzczs)) {
            long a = this.f26530c.mo27934a() - ((Long) this.f26528a.get(zzczs)).longValue();
            Map a2 = this.f26529b.mo31142a();
            String str2 = "task.";
            String valueOf = String.valueOf(str);
            String concat = valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2);
            String str3 = "f.";
            String valueOf2 = String.valueOf(Long.toString(a));
            a2.put(concat, valueOf2.length() != 0 ? str3.concat(valueOf2) : new String(str3));
        }
        if (this.f26531d.containsKey(zzczs)) {
            m28364a(zzczs, false);
        }
    }

    /* renamed from: a */
    public final void mo31136a(zzczs zzczs, String str) {
        if (this.f26528a.containsKey(zzczs)) {
            long a = this.f26530c.mo27934a() - ((Long) this.f26528a.get(zzczs)).longValue();
            Map a2 = this.f26529b.mo31142a();
            String str2 = "task.";
            String valueOf = String.valueOf(str);
            String concat = valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2);
            String str3 = "s.";
            String valueOf2 = String.valueOf(Long.toString(a));
            a2.put(concat, valueOf2.length() != 0 ? str3.concat(valueOf2) : new String(str3));
        }
        if (this.f26531d.containsKey(zzczs)) {
            m28364a(zzczs, true);
        }
    }

    /* renamed from: a */
    private final void m28364a(zzczs zzczs, boolean z) {
        zzczs b = ((C8769Bi) this.f26531d.get(zzczs)).f20513b;
        String str = z ? "s." : "f.";
        if (this.f26528a.containsKey(b)) {
            long a = this.f26530c.mo27934a() - ((Long) this.f26528a.get(b)).longValue();
            Map a2 = this.f26529b.mo31142a();
            String str2 = "label.";
            String valueOf = String.valueOf(((C8769Bi) this.f26531d.get(zzczs)).f20512a);
            String concat = valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2);
            String valueOf2 = String.valueOf(str);
            String valueOf3 = String.valueOf(Long.toString(a));
            a2.put(concat, valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2));
        }
    }
}
