package com.bumptech.glide.p100c;

import android.util.Log;
import com.bumptech.glide.p103f.C5986c;
import com.bumptech.glide.p107h.C6026k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: com.bumptech.glide.c.p */
/* compiled from: RequestTracker */
public class C5945p {

    /* renamed from: a */
    private final Set<C5986c> f10468a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b */
    private final List<C5986c> f10469b = new ArrayList();

    /* renamed from: c */
    private boolean f10470c;

    /* renamed from: b */
    public void mo18624b(C5986c request) {
        this.f10468a.add(request);
        if (!this.f10470c) {
            request.mo18673a();
            return;
        }
        String str = "RequestTracker";
        if (Log.isLoggable(str, 2)) {
            Log.v(str, "Paused, delaying request");
        }
        this.f10469b.add(request);
    }

    /* renamed from: a */
    public boolean mo18622a(C5986c request) {
        return m10977a(request, true);
    }

    /* renamed from: a */
    private boolean m10977a(C5986c request, boolean isSafeToRecycle) {
        boolean isOwnedByUs = true;
        if (request == null) {
            return true;
        }
        boolean isOwnedByUs2 = this.f10468a.remove(request);
        if (!this.f10469b.remove(request) && !isOwnedByUs2) {
            isOwnedByUs = false;
        }
        if (isOwnedByUs) {
            request.clear();
            if (isSafeToRecycle) {
                request.mo18676b();
            }
        }
        return isOwnedByUs;
    }

    /* renamed from: b */
    public void mo18623b() {
        this.f10470c = true;
        for (C5986c request : C6026k.m11279a((Collection<T>) this.f10468a)) {
            if (request.isRunning()) {
                request.pause();
                this.f10469b.add(request);
            }
        }
    }

    /* renamed from: d */
    public void mo18626d() {
        this.f10470c = false;
        for (C5986c request : C6026k.m11279a((Collection<T>) this.f10468a)) {
            if (!request.isComplete() && !request.isCancelled() && !request.isRunning()) {
                request.mo18673a();
            }
        }
        this.f10469b.clear();
    }

    /* renamed from: a */
    public void mo18621a() {
        for (C5986c request : C6026k.m11279a((Collection<T>) this.f10468a)) {
            m10977a(request, false);
        }
        this.f10469b.clear();
    }

    /* renamed from: c */
    public void mo18625c() {
        for (C5986c request : C6026k.m11279a((Collection<T>) this.f10468a)) {
            if (!request.isComplete() && !request.isCancelled()) {
                request.pause();
                if (!this.f10470c) {
                    request.mo18673a();
                } else {
                    this.f10469b.add(request);
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{numRequests=");
        sb.append(this.f10468a.size());
        sb.append(", isPaused=");
        sb.append(this.f10470c);
        sb.append("}");
        return sb.toString();
    }
}
