package com.bumptech.glide.p100c;

import com.bumptech.glide.p103f.p104a.C5976i;
import com.bumptech.glide.p107h.C6026k;
import com.bumptech.glide.request.target.Target;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: com.bumptech.glide.c.r */
/* compiled from: TargetTracker */
public final class C5948r implements C5937j {

    /* renamed from: a */
    private final Set<C5976i<?>> f10478a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: a */
    public void mo18635a(C5976i<?> target) {
        this.f10478a.add(target);
    }

    /* renamed from: b */
    public void mo18637b(C5976i<?> target) {
        this.f10478a.remove(target);
    }

    public void onStart() {
        for (Target<?> target : C6026k.m11279a((Collection<T>) this.f10478a)) {
            target.onStart();
        }
    }

    public void onStop() {
        for (Target<?> target : C6026k.m11279a((Collection<T>) this.f10478a)) {
            target.onStop();
        }
    }

    public void onDestroy() {
        for (Target<?> target : C6026k.m11279a((Collection<T>) this.f10478a)) {
            target.onDestroy();
        }
    }

    /* renamed from: b */
    public List<C5976i<?>> mo18636b() {
        return C6026k.m11279a((Collection<T>) this.f10478a);
    }

    /* renamed from: a */
    public void mo18634a() {
        this.f10478a.clear();
    }
}
