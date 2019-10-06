package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.C6031a;
import com.bumptech.glide.load.C6344g;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.C6307g.C6308a;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.load.p109a.C6042d.C6043a;
import com.bumptech.glide.load.p111b.C6128u;
import com.bumptech.glide.load.p111b.C6128u.C6129a;
import java.io.File;
import java.util.List;

/* renamed from: com.bumptech.glide.load.engine.F */
/* compiled from: ResourceCacheGenerator */
class C6237F implements C6307g, C6043a<Object> {

    /* renamed from: a */
    private final C6308a f11013a;

    /* renamed from: b */
    private final C6309h<?> f11014b;

    /* renamed from: c */
    private int f11015c;

    /* renamed from: d */
    private int f11016d = -1;

    /* renamed from: e */
    private C6344g f11017e;

    /* renamed from: f */
    private List<C6128u<File, ?>> f11018f;

    /* renamed from: g */
    private int f11019g;

    /* renamed from: h */
    private volatile C6129a<?> f11020h;

    /* renamed from: i */
    private File f11021i;

    /* renamed from: j */
    private C6238G f11022j;

    C6237F(C6309h<?> helper, C6308a cb) {
        this.f11014b = helper;
        this.f11013a = cb;
    }

    /* renamed from: a */
    public boolean mo19101a() {
        List<Key> sourceIds = this.f11014b.mo19237c();
        boolean z = false;
        if (sourceIds.isEmpty()) {
            return false;
        }
        List<Class<?>> resourceClasses = this.f11014b.mo19245j();
        if (resourceClasses.isEmpty() && File.class.equals(this.f11014b.mo19247l())) {
            return false;
        }
        while (true) {
            if (this.f11018f == null || !m11896b()) {
                this.f11016d++;
                if (this.f11016d >= resourceClasses.size()) {
                    this.f11015c++;
                    if (this.f11015c >= sourceIds.size()) {
                        return z;
                    }
                    this.f11016d = z ? 1 : 0;
                }
                C6344g sourceId = (C6344g) sourceIds.get(this.f11015c);
                Class<?> resourceClass = (Class) resourceClasses.get(this.f11016d);
                C6344g gVar = sourceId;
                C6238G g = r5;
                C6238G g2 = new C6238G(this.f11014b.mo19234b(), gVar, this.f11014b.mo19246k(), this.f11014b.mo19248m(), this.f11014b.mo19241f(), this.f11014b.mo19235b(resourceClass), resourceClass, this.f11014b.mo19243h());
                this.f11022j = g;
                this.f11021i = this.f11014b.mo19239d().mo19176a(this.f11022j);
                File file = this.f11021i;
                if (file != null) {
                    this.f11017e = sourceId;
                    this.f11018f = this.f11014b.mo19230a(file);
                    z = false;
                    this.f11019g = 0;
                } else {
                    z = false;
                }
            } else {
                this.f11020h = null;
                boolean started = false;
                while (!started && m11896b()) {
                    List<C6128u<File, ?>> list = this.f11018f;
                    int i = this.f11019g;
                    this.f11019g = i + 1;
                    this.f11020h = ((C6128u) list.get(i)).mo18889a(this.f11021i, this.f11014b.mo19248m(), this.f11014b.mo19241f(), this.f11014b.mo19243h());
                    if (this.f11020h != null && this.f11014b.mo19238c(this.f11020h.f10816c.mo18847a())) {
                        started = true;
                        this.f11020h.f10816c.mo18853a(this.f11014b.mo19244i(), this);
                    }
                }
                return started;
            }
        }
    }

    /* renamed from: b */
    private boolean m11896b() {
        return this.f11019g < this.f11018f.size();
    }

    public void cancel() {
        LoadData<?> local = this.f11020h;
        if (local != null) {
            local.f10816c.cancel();
        }
    }

    /* renamed from: a */
    public void mo18868a(Object data) {
        this.f11013a.mo19120a(this.f11017e, data, this.f11020h.f10816c, C6031a.RESOURCE_DISK_CACHE, this.f11022j);
    }

    /* renamed from: a */
    public void mo18867a(Exception e) {
        this.f11013a.mo19119a(this.f11022j, e, this.f11020h.f10816c, C6031a.RESOURCE_DISK_CACHE);
    }
}
