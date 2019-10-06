package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;
import java.util.Set;
import p002b.p003c.p053g.p061f.C1253b;

public final class zak {

    /* renamed from: a */
    private final C1253b<zai<?>, ConnectionResult> f19901a = new C1253b<>();

    /* renamed from: b */
    private final C1253b<zai<?>, String> f19902b = new C1253b<>();

    /* renamed from: c */
    private final TaskCompletionSource<Map<zai<?>, String>> f19903c = new TaskCompletionSource<>();

    /* renamed from: d */
    private int f19904d;

    /* renamed from: e */
    private boolean f19905e = false;

    public zak(Iterable<? extends GoogleApi<?>> iterable) {
        for (GoogleApi g : iterable) {
            this.f19901a.put(g.mo27368g(), null);
        }
        this.f19904d = this.f19901a.keySet().size();
    }

    /* renamed from: b */
    public final Set<zai<?>> mo27630b() {
        return this.f19901a.keySet();
    }

    /* renamed from: a */
    public final Task<Map<zai<?>, String>> mo27628a() {
        return this.f19903c.mo33180a();
    }

    /* renamed from: a */
    public final void mo27629a(zai<?> zai, ConnectionResult connectionResult, String str) {
        this.f19901a.put(zai, connectionResult);
        this.f19902b.put(zai, str);
        this.f19904d--;
        if (!connectionResult.mo27281f()) {
            this.f19905e = true;
        }
        if (this.f19904d == 0) {
            if (this.f19905e) {
                this.f19903c.mo33181a((Exception) new AvailabilityException(this.f19901a));
                return;
            }
            this.f19903c.mo33182a(this.f19902b);
        }
    }
}
