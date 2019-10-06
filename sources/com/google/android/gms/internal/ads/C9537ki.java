package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.ki */
final class C9537ki<T> implements zzaho<Object> {

    /* renamed from: a */
    private final WeakReference<T> f22684a;

    /* renamed from: b */
    private final String f22685b;

    /* renamed from: c */
    private final zzaho<T> f22686c;

    /* renamed from: d */
    private final /* synthetic */ zzccj f22687d;

    private C9537ki(zzccj zzccj, WeakReference<T> weakReference, String str, zzaho<T> zzaho) {
        this.f22687d = zzccj;
        this.f22684a = weakReference;
        this.f22685b = str;
        this.f22686c = zzaho;
    }

    /* renamed from: a */
    public final void mo27996a(Object obj, Map<String, String> map) {
        Object obj2 = this.f22684a.get();
        if (obj2 == null) {
            this.f22687d.mo31118b(this.f22685b, this);
        } else {
            this.f22686c.mo27996a(obj2, map);
        }
    }

    /* synthetic */ C9537ki(zzccj zzccj, WeakReference weakReference, String str, zzaho zzaho, C9405ei eiVar) {
        this(zzccj, weakReference, str, zzaho);
    }
}
