package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.C6031a;
import com.bumptech.glide.load.C6344g;
import com.bumptech.glide.load.engine.C6307g.C6308a;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.load.p109a.C6042d.C6043a;
import com.bumptech.glide.load.p111b.C6128u;
import com.bumptech.glide.load.p111b.C6128u.C6129a;
import java.io.File;
import java.util.List;

/* renamed from: com.bumptech.glide.load.engine.d */
/* compiled from: DataCacheGenerator */
class C6303d implements C6307g, C6043a<Object> {

    /* renamed from: a */
    private final List<C6344g> f11154a;

    /* renamed from: b */
    private final C6309h<?> f11155b;

    /* renamed from: c */
    private final C6308a f11156c;

    /* renamed from: d */
    private int f11157d;

    /* renamed from: e */
    private C6344g f11158e;

    /* renamed from: f */
    private List<C6128u<File, ?>> f11159f;

    /* renamed from: g */
    private int f11160g;

    /* renamed from: h */
    private volatile C6129a<?> f11161h;

    /* renamed from: i */
    private File f11162i;

    C6303d(C6309h<?> helper, C6308a cb) {
        this(helper.mo19237c(), helper, cb);
    }

    C6303d(List<C6344g> cacheKeys, C6309h<?> helper, C6308a cb) {
        this.f11157d = -1;
        this.f11154a = cacheKeys;
        this.f11155b = helper;
        this.f11156c = cb;
    }

    /* renamed from: a */
    public boolean mo19101a() {
        while (true) {
            if (this.f11159f == null || !m12094b()) {
                this.f11157d++;
                if (this.f11157d >= this.f11154a.size()) {
                    return false;
                }
                C6344g sourceId = (C6344g) this.f11154a.get(this.f11157d);
                this.f11162i = this.f11155b.mo19239d().mo19176a(new C6305e(sourceId, this.f11155b.mo19246k()));
                File file = this.f11162i;
                if (file != null) {
                    this.f11158e = sourceId;
                    this.f11159f = this.f11155b.mo19230a(file);
                    this.f11160g = 0;
                }
            } else {
                this.f11161h = null;
                boolean started = false;
                while (!started && m12094b()) {
                    List<C6128u<File, ?>> list = this.f11159f;
                    int i = this.f11160g;
                    this.f11160g = i + 1;
                    this.f11161h = ((C6128u) list.get(i)).mo18889a(this.f11162i, this.f11155b.mo19248m(), this.f11155b.mo19241f(), this.f11155b.mo19243h());
                    if (this.f11161h != null && this.f11155b.mo19238c(this.f11161h.f10816c.mo18847a())) {
                        started = true;
                        this.f11161h.f10816c.mo18853a(this.f11155b.mo19244i(), this);
                    }
                }
                return started;
            }
        }
    }

    /* renamed from: b */
    private boolean m12094b() {
        return this.f11160g < this.f11159f.size();
    }

    public void cancel() {
        LoadData<?> local = this.f11161h;
        if (local != null) {
            local.f10816c.cancel();
        }
    }

    /* renamed from: a */
    public void mo18868a(Object data) {
        this.f11156c.mo19120a(this.f11158e, data, this.f11161h.f10816c, C6031a.DATA_DISK_CACHE, this.f11158e);
    }

    /* renamed from: a */
    public void mo18867a(Exception e) {
        this.f11156c.mo19119a(this.f11158e, e, this.f11161h.f10816c, C6031a.DATA_DISK_CACHE);
    }
}
