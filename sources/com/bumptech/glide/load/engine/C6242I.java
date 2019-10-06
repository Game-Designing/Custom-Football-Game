package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.C6031a;
import com.bumptech.glide.load.C6344g;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.engine.C6307g.C6308a;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.load.p109a.C6042d;
import com.bumptech.glide.load.p109a.C6042d.C6043a;
import com.bumptech.glide.load.p111b.C6128u.C6129a;
import com.bumptech.glide.p107h.C6020e;
import java.util.Collections;
import java.util.List;

/* renamed from: com.bumptech.glide.load.engine.I */
/* compiled from: SourceGenerator */
class C6242I implements C6307g, C6043a<Object>, C6308a {

    /* renamed from: a */
    private final C6309h<?> f11042a;

    /* renamed from: b */
    private final C6308a f11043b;

    /* renamed from: c */
    private int f11044c;

    /* renamed from: d */
    private C6303d f11045d;

    /* renamed from: e */
    private Object f11046e;

    /* renamed from: f */
    private volatile C6129a<?> f11047f;

    /* renamed from: g */
    private C6305e f11048g;

    C6242I(C6309h<?> helper, C6308a cb) {
        this.f11042a = helper;
        this.f11043b = cb;
    }

    /* renamed from: a */
    public boolean mo19101a() {
        if (this.f11046e != null) {
            Object data = this.f11046e;
            this.f11046e = null;
            m11913b(data);
        }
        C6303d dVar = this.f11045d;
        if (dVar != null && dVar.mo19101a()) {
            return true;
        }
        this.f11045d = null;
        this.f11047f = null;
        boolean started = false;
        while (!started && m11914b()) {
            List g = this.f11042a.mo19242g();
            int i = this.f11044c;
            this.f11044c = i + 1;
            this.f11047f = (C6129a) g.get(i);
            if (this.f11047f != null && (this.f11042a.mo19240e().mo19274a(this.f11047f.f10816c.mo18855c()) || this.f11042a.mo19238c(this.f11047f.f10816c.mo18847a()))) {
                started = true;
                this.f11047f.f10816c.mo18853a(this.f11042a.mo19244i(), this);
            }
        }
        return started;
    }

    /* renamed from: b */
    private boolean m11914b() {
        return this.f11044c < this.f11042a.mo19242g().size();
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: b */
    private void m11913b(Object dataToCache) {
        String str = "SourceGenerator";
        long startTime = C6020e.m11250a();
        try {
            Encoder<Object> encoder = this.f11042a.mo19227a(dataToCache);
            DataCacheWriter<Object> writer = new C6306f<>(encoder, dataToCache, this.f11042a.mo19243h());
            this.f11048g = new C6305e(this.f11047f.f10814a, this.f11042a.mo19246k());
            this.f11042a.mo19239d().mo19177a(this.f11048g, writer);
            if (Log.isLoggable(str, 2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Finished encoding source to cache, key: ");
                sb.append(this.f11048g);
                sb.append(", data: ");
                sb.append(dataToCache);
                sb.append(", encoder: ");
                sb.append(encoder);
                sb.append(", duration: ");
                sb.append(C6020e.m11249a(startTime));
                Log.v(str, sb.toString());
            }
            this.f11047f.f10816c.mo18854b();
            this.f11045d = new C6303d(Collections.singletonList(this.f11047f.f10814a), this.f11042a, this);
        } catch (Throwable th) {
            this.f11047f.f10816c.mo18854b();
            throw th;
        }
    }

    public void cancel() {
        LoadData<?> local = this.f11047f;
        if (local != null) {
            local.f10816c.cancel();
        }
    }

    /* renamed from: a */
    public void mo18868a(Object data) {
        C6326q diskCacheStrategy = this.f11042a.mo19240e();
        if (data == null || !diskCacheStrategy.mo19274a(this.f11047f.f10816c.mo18855c())) {
            this.f11043b.mo19120a(this.f11047f.f10814a, data, this.f11047f.f10816c, this.f11047f.f10816c.mo18855c(), this.f11048g);
            return;
        }
        this.f11046e = data;
        this.f11043b.mo19121f();
    }

    /* renamed from: a */
    public void mo18867a(Exception e) {
        this.f11043b.mo19119a(this.f11048g, e, this.f11047f.f10816c, this.f11047f.f10816c.mo18855c());
    }

    /* renamed from: f */
    public void mo19121f() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public void mo19120a(C6344g sourceKey, Object data, C6042d<?> fetcher, C6031a dataSource, C6344g attemptedKey) {
        this.f11043b.mo19120a(sourceKey, data, fetcher, this.f11047f.f10816c.mo18855c(), sourceKey);
    }

    /* renamed from: a */
    public void mo19119a(C6344g sourceKey, Exception e, C6042d<?> fetcher, C6031a dataSource) {
        this.f11043b.mo19119a(sourceKey, e, fetcher, this.f11047f.f10816c.mo18855c());
    }
}
