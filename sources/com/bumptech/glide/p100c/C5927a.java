package com.bumptech.glide.p100c;

import com.bumptech.glide.p107h.C6026k;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: com.bumptech.glide.c.a */
/* compiled from: ActivityFragmentLifecycle */
class C5927a implements C5936i {

    /* renamed from: a */
    private final Set<C5937j> f10443a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b */
    private boolean f10444b;

    /* renamed from: c */
    private boolean f10445c;

    C5927a() {
    }

    /* renamed from: b */
    public void mo18593b(C5937j listener) {
        this.f10443a.add(listener);
        if (this.f10445c) {
            listener.onDestroy();
        } else if (this.f10444b) {
            listener.onStart();
        } else {
            listener.onStop();
        }
    }

    /* renamed from: a */
    public void mo18591a(C5937j listener) {
        this.f10443a.remove(listener);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo18592b() {
        this.f10444b = true;
        for (C5937j lifecycleListener : C6026k.m11279a((Collection<T>) this.f10443a)) {
            lifecycleListener.onStart();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo18594c() {
        this.f10444b = false;
        for (C5937j lifecycleListener : C6026k.m11279a((Collection<T>) this.f10443a)) {
            lifecycleListener.onStop();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo18590a() {
        this.f10445c = true;
        for (C5937j lifecycleListener : C6026k.m11279a((Collection<T>) this.f10443a)) {
            lifecycleListener.onDestroy();
        }
    }
}
